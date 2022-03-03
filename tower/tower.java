package avaj_launcher.tower;

public class Tower {
	private List<Flyable> *observers = new ArrayList<Flyable>();

	public void register(flyable: Flyable);
	public void unregister(flyable: Flyable);
	protected void conditionsChanged();

}

public class WeatherTower extends Tower {
	public string getWeather(coordinates: Coordinates);
	private void changeWeather();
}
