package avaj_launcher.tower;

public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private static string[] weather;

	private WeatherProvider();

	public WeatherProvider getProvider();

	public string getCurrentWeather(coordinates: Coordinates);
}
