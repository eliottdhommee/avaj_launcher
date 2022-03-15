package avaj_launcher.aircrafts;
import avaj_launcher.tower.Flyable;
import avaj_launcher.tower.WeatherTower;
import avaj_launcher.file.AvajFile;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch(weather) {

			case "SUN":
				this.updateCoordinates(2, 0, 4);
				writeId();
				AvajFile.writeToFile(" Let's enjoy the good weather and take some pics.\n");
				break;

			case "RAIN":
				this.updateCoordinates(0, 0, -5);
				writeId();
				AvajFile.writeToFile(" Damn you rain! You messed up my baloon.\n");
				break;

			case "FOG":
				this.updateCoordinates(0, 0, -3);
				writeId();
				AvajFile.writeToFile(" F***** fog! \n");
				break;

			case "SNOW":
				this.updateCoordinates(0, 0, -15);
				writeId();
				AvajFile.writeToFile(" It's snowing. We're gonna crash.\n");
				break;
		}
		if (this.coordinates.getHeight() <= 0) {
			writeId();
			writeLanding();
			this.weatherTower.unregister(this);
			AvajFile.writeToFile("Tower says: ");
			writeId();
			AvajFile.writeToFile(" unregistered from weather tower.\n");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		AvajFile.writeToFile("Tower says: ");
		writeId();
		AvajFile.writeToFile(" registered to weather tower.\n");
	}

	public void writeId() {
		AvajFile.registerToFile("Baloon", this.name, Long.toString(this.id));
	}
}
