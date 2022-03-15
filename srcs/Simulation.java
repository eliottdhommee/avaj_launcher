package avaj_launcher;
import avaj_launcher.file.AvajFile;
import avaj_launcher.aircrafts.AircraftFactory;
import avaj_launcher.tower.WeatherTower;

public class Simulation {
	private static int nb;
	private static WeatherTower weatherTower = new WeatherTower();

	public static void main (String[] args){
		if (args.length != 1) {
			System.out.print("error: invalid number of arguments.");
			System.exit(1);
		}
		getScenario(args[0]);
		while (nb > 0) {
			weatherTower.changeWeather();
			nb--;
		}
		AvajFile.closeFile();
	}

	public static void getScenario(String fileName) {
		String[] checks;
		String tmp;

		AvajFile.initFile(fileName);
		if ((tmp = AvajFile.getNextLine()) != null) {
			nb = Integer.parseInt(tmp);
			if (nb <= 0) {
				System.out.print("error: invalid number of simulations.");
				System.exit(1);
			}
		}
		while ((tmp = AvajFile.getNextLine()) != null) {
			if ((checks = checkLine(tmp)) != null)
				AircraftFactory.newAircraft(checks[0], checks[1], Integer.parseInt(checks[2]), Integer.parseInt(checks[3]), Integer.parseInt(checks[4])).registerTower(weatherTower);
			else
				System.exit(1);
		}
	}

	public static String[] checkLine(String line) {
		String[] checks;

		checks = line.split(" ");
		if (checks.length != 5) {
			System.out.print("error: invalid number of arguments for aircraft.");
			return null;
		} else if (!checks[0].equals("Baloon") && !checks[0].equals("JetPlane") && !checks[0].equals("Helicopter")) {
			System.out.print("error: aircraft type invalid.");
			return null;
		} else if (!(Integer.parseInt(checks[2]) > 0 && Integer.parseInt(checks[3]) > 0 && Integer.parseInt(checks[4]) > 0)) {
			System.out.print("error: invalid coordinates.");
			return null;
		} else
			return checks;
	}
}
