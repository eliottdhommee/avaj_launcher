package avaj_launcher.tower;
import java.util.LinkedList;
import java.util.List;

public class Tower {
	private List<Flyable> observers ;

	public void register(Flyable flyable) {
		if (observers == null)
			observers = new LinkedList();
		this.observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		if (this.observers.contains(flyable)) {
			this.observers.remove(observers.indexOf(flyable));
		}
	}

	protected void conditionsChanged() {
		for (Flyable flyable : this.observers) {
			flyable.updateConditions();
		}
	}

}
