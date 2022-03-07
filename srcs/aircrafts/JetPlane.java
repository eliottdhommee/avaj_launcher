package avaj_launcher.aircrafts;
import avaj_launcher.tower.Flyable;
import avaj_launcher.tower.WeatherTower;
import avaj_launcher.file.AvajFile;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN")) {
			this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
			this.coordinates.setHeight(this.coordinates.getHeight() + 2);
		} else if (weather.equals("RAIN")) {
			this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
		} else if (weather.equals("FOG")) {
			this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
		} else if (weather.equals("SNOW")) {
			this.coordinates.setHeight(this.coordinates.getHeight() - 7);
		}
		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		AvajFile.registerToFile("JetPlane", this.name, Long.toString(this.id));
	}
}
