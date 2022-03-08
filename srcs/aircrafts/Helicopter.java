package avaj_launcher.aircrafts;
import avaj_launcher.tower.Flyable;
import avaj_launcher.tower.WeatherTower;
import avaj_launcher.file.AvajFile;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN")) {
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
			this.coordinates.setHeight(this.coordinates.getHeight() + 2);
		} else if (weather.equals("RAIN")) {
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
		} else if (weather.equals("FOG")) {
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
		} else if (weather.equals("SNOW")) {
			this.coordinates.setHeight(this.coordinates.getHeight() - 12);
		}
		AvajFile.updateToFile("Helicopter", this.name, Long.toString(this.id), weather, Integer.toString(this.coordinates.getHeight()));
		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
			AvajFile.writeToFile("Tower says: ");
			writeId();
			AvajFile.writeToFile(" unregistered from weather tower\n");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		AvajFile.writeToFile("Tower says: ");
		writeId();
		AvajFile.writeToFile(" registered to weather tower\n");
	}

	public void writeId() {
		AvajFile.registerToFile("Helicopter", this.name, Long.toString(this.id));
	}
}
