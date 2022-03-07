package avaj_launcher.tower;
import avaj_launcher.aircrafts.Coordinates;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}

	public void changeWeather() {
		conditionsChanged();
	}
}
