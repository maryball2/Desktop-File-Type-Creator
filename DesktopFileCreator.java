/*
 Title: This creates a .desktop file in java
 Author: Riley Carpenter
 TODO: Make the program able to move the .desktop file to ~/.local/share/applications
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
		Path file = Paths.get(fileName + ".desktop");
		Files.write(file, lines, Charset.forName("UTF-8"));
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
	}
}
