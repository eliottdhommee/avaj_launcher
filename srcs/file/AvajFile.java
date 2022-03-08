package avaj_launcher.file;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

import avaj_launcher.tower.Tower;

public class AvajFile {
	private static File fileToRead;
	private static File fileToWrite;
	private static Scanner myReader;
	private static FileWriter myWriter;

	public static void initFile(String fileName) {
		try {
			fileToRead= new File(fileName);
			myReader = new Scanner(fileToRead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			fileToWrite = new File("simulation.txt");
			if (!fileToWrite.createNewFile()) {
				fileToWrite.delete();
				fileToWrite.createNewFile();
			}
			myWriter = new FileWriter("simulation.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void registerToFile(String type, String name, String id) {
		writeToFile(type.concat("#").concat(name).concat("(").concat(id).concat(")"));
	}

	public static void updateToFile(String type, String name, String id, String weather, String height) {
		writeToFile(type.concat("#").concat(name).concat("(").concat(id).concat(")").concat(weather).concat(height).concat("\n"));
	}

	public static void writeToFile(String string) {
		try {
			myWriter.write(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void closeFile() {
		try {
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getNextLine() {
		if (myReader.hasNextLine()) {
			return myReader.nextLine();
		} else {
			myReader.close();
			return null;
		}
	}

}
