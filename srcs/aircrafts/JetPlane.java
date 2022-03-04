package avaj_launcher.aircrafts;
import avaj_launcher.tower.Flyable;
import avaj_launcher.tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	private JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
	}

	public void registerTower(WeatherTower weatherTower) {
	}
}
