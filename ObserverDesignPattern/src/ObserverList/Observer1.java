package ObserverList;

public class Observer1 implements IObserver {

	@Override
	public void update(String s, int i) {
		// TODO Auto-generated method stub
		System.out.println("This is observer " + s + " and the value is " + i) ;
	}

}
