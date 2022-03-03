package avaj_launcher.aircrafts;

public class Aircraft {
	protected long id;
	protected string name;
	protected Coordinates coordinates;
	private long idCounter;

	protected Aircraft(name: string, coordinates: Coordinates) {
		this.name = name;
		this.coodinates = coordinates;
	}

	private long nextId();
}

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	private Helicopter(name: string, coordinates: Coordinates);
	public void updateConditions();
	public void registerTower(weatherTower: WeatherTower);
}

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	private JetPlane(name: string, coordinates: Coordinates);
	public void updateConditions();
	public void registerTower(weatherTower: WeatherTower);
}

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	private Baloon(name: string, coordinates: Coordinates);
	public void updateConditions();
	public void registerTower(weatherTower: WeatherTower);
}
