package avaj_launcher.aircrafts;

	public class Coordinates {
		private int longitude;
		private int latitude;
		private int height;

		Coordinates(int longitude, int latitude, int height) {
			this.longitude = longitude;
			this.latitude = latitude;
			this.height = height;
		}

		public int getLatitude() {
			return this.latitude;
		}

		public int getLongitude() {
			return this.longitude;
		}

		public int getHeight() {
			return this.height;
		}

		public void setLatitude(int latitude) {
			this.latitude = latitude;
		}

		public void setLongitude(int longitude) {
			this.longitude = longitude;
		}

		public void setHeight(int height) {
			if (height > 100)
				height = 100;
			this.height = height;
		}
	}
