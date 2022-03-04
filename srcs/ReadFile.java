package avaj_launcher;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import avaj_launcher.tower.Tower;

public class ReadFile {
	public void getScenario(String fileName) {
		int nb;
		String data;
		File myObj;
		Scanner myReader;
		String[] checks;

		try {
			myObj = new File(fileName);
			myReader = new Scanner(myObj);
			if (myReader.hasNextLine()) {
				data = myReader.nextLine();
				nb = Integer.parseInt(data);
			}
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				if (checkLine(data)) {
					checks = data.split(" ");
					Tower.register(AircraftFactory.newAircraft(checks[0], checks[1], Integer.parseInt(checks[2]), Integer.parseInt(checks[3]), Integer.parseInt(checks[4])));
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public boolean checkLine(String line) {
		String[] checks;

		checks = line.split(" ");
		if (checks.length != 5)
			return false;
		else if (!checks[0].equals("Baloon") && !checks[0].equals("JetPlane") && !checks.equals("Helicopter"))
			return false;
		else if (!(Integer.parseInt(checks[2]) > 0 && Integer.parseInt(checks[3]) > 0 && Integer.parseInt(checks[4]) > 0))
			return false;
		else
			return true;
	}
}
