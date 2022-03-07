package avaj_launcher.aircrafts;

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
}
