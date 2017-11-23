package ObserverList;

public class Observer3 implements IObserver {

	@Override
	public void update(String s, int i) {
		// TODO Auto-generated method stub
		System.out.println("Observer3 is observing:myValue is changed in "+s+" to :"+i);
	}

}
