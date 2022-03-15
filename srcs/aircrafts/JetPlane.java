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
		switch(weather) {

			case "SUN":
				this.updateCoordinates(0, 10, 2);
				writeId();
				AvajFile.writeToFile(" Too much light.\n");
				break;

			case "RAIN":
				this.updateCoordinates(0, 5, 0);
				writeId();
				AvajFile.writeToFile(" It's raining. Better watch out for lightings.\n");
				break;

			case "FOG":
				this.updateCoordinates(0, 1, 0);
				writeId();
				AvajFile.writeToFile(" Fog is here.\n");
				break;

			case "SNOW":
				this.updateCoordinates(0, 0, -7);
				writeId();
				AvajFile.writeToFile(" OMG! Winter is coming!\n");
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
		AvajFile.registerToFile("JetPlane", this.name, Long.toString(this.id));
	}
}
