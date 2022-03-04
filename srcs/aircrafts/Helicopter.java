package avaj_launcher.aircrafts;
import avaj_launcher.tower.Flyable;
import avaj_launcher.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	private Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	public void updateConditions() {
		return;
	}
	public void registerTower(WeatherTower weatherTower) {
	}
}
