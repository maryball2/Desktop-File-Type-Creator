/*
 Title: This creates a .desktop file in java
 Author: Riley Carpenter
 */


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class DesktopFileCreator {
	
	
	//Creates the File
	public static void createDesktopFile(String fileName, String exe, String ico) throws IOException {
		List<String> lines = Arrays.asList("[Desktop Entry]", "Encoding=UTF-8","Version=1.0","Type=Application","Terminal=false","Exec=" +exe,"Name=" +fileName,"Icon=" + ico);
		Path file = Paths.get(System.getProperty( "user.home" ) + "/.local/share/applications/" + fileName + ".desktop");

		//Sets File's Permissions
		Set<PosixFilePermission> ownerWritable = PosixFilePermissions.fromString("rw-r--r--");
		FileAttribute<?> permissions = PosixFilePermissions.asFileAttribute(ownerWritable);


		Files.write(file, permissions, lines, Charset.forName("UTF-8"));
	}

	
	//Main method
	public static void main(String[] args) throws IOException{
		Scanner reader = new Scanner(System.in);
		System.out.print("What is the name of the executable? ");
		String fileName = reader.nextLine();
		System.out.print("What is the file path for the executable? ");
		String executableFile = reader.nextLine();
		System.out.print("What is the icon path for the file? (Leave blank if none) ");
		String iconPath = reader.nextLine();
		reader.close();
		createDesktopFile(fileName, executableFile, iconPath);
		System.out.print("\u001b[2J");
		System.out.flush();
		System.out.println("Desktop File Created Successfully!");
	}
}
