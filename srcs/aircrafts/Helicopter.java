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
		switch(weather) {

			case "SUN":
				this.updateCoordinates(10, 0, 2);
				writeId();
				AvajFile.writeToFile(" This is hot.\n");
				break;

			case "RAIN":
				this.updateCoordinates(5, 0, 0);
				writeId();
				AvajFile.writeToFile(" My rotor is going to rust!\n");
				break;

			case "FOG":
				this.updateCoordinates(1, 0, 0);
				writeId();
				AvajFile.writeToFile(" Can't see shit! \n");
				break;

			case "SNOW":
				this.updateCoordinates(0, 0, -12);
				writeId();
				AvajFile.writeToFile(" My rotor is going to freeze!\n");
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
		AvajFile.writeToFile(" registered to weather tower\n");
	}

	public void writeId() {
		AvajFile.registerToFile("Helicopter", this.name, Long.toString(this.id));
	}
}
