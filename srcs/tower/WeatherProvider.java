package avaj_launcher.tower;

import avaj_launcher.aircrafts.Coordinates;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = new String[] {"SUN", "RAIN", "FOG", "SNOW"};

	private WeatherProvider() {}

	public static WeatherProvider getProvider() {
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int nbWeather;
		nbWeather = (coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) % 4;
		return (weather[nbWeather]);
	}
}
