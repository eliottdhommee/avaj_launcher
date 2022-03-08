package avaj_launcher.tower;
import java.util.LinkedList;
import java.util.List;

public class Tower {
	private List<Flyable> observers = new LinkedList<Flyable>() ;
	private List<Flyable> toRemove = new LinkedList<Flyable>() ;

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		toRemove.add(flyable);
	}

	protected void conditionsChanged() {
		for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
		observers.removeAll(toRemove);
	}

}
