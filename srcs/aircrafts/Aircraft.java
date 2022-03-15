package avaj_launcher.aircrafts;
import avaj_launcher.file.AvajFile;

public class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;

	protected Aircraft(String name, Coordinates coordinates) {
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
	}

	private long nextId() {
		idCounter = idCounter + 1;
		return idCounter;
	}

	public void updateCoordinates(int longitude, int latitude, int height) {
		this.coordinates.setLongitude(this.coordinates.getLongitude() + longitude);
		this.coordinates.setLatitude(this.coordinates.getLatitude() + latitude);
		this.coordinates.setHeight(this.coordinates.getHeight() + height);
	}

	public void writeLanding() {
		AvajFile.writeToFile(" landing, coordinates: longitude:".concat(Integer.toString(this.coordinates.getLongitude())).concat(", latitude:").concat(Integer.toString(this.coordinates.getLatitude())).concat(", height:").concat(Integer.toString(this.coordinates.getHeight())).concat(".\n"));
	}
}
