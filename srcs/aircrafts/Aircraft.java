package avaj_launcher.aircrafts;

public class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	private long nextId() {
		return 0;
	}

	public class Coordinates {
		private int longitude;
		private int latitude;
		private int height;

		private Coordinates(int longitude, int latitude, int height) {
			this.longitude = longitude;
			this.latitude = latitude;
			this.height = height;
		}

		public int getLatitude() {
			return latitude;
		}

		public int getLongitude() {
			return longitude;
		}

		public int getHeight() {
			return height;
		}
	}
}
