package aircraft;

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
