package avaj_launcher.aircrafts;
import avaj_launcher.tower.Flyable;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		Coordinates coordinates;

		if (height > 100)
			height = 100;
		coordinates = new Coordinates(longitude, latitude, height);
		if (type.equals("Baloon")) {
			return new Baloon(name, coordinates);
		}
		else if (type.equals("JetPlane")) {
			return new JetPlane(name, coordinates);
		}
		else if (type.equals("Helicopter")) {
			return new Helicopter(name, coordinates);
		}
		else
			return null;
	}
}
