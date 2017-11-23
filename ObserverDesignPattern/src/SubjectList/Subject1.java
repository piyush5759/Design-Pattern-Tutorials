package SubjectList;


import java.util.ArrayList;
import java.util.List;

import ObserverList.IObserver;

public class Subject1 implements ISubject {

	private int myValue;
	
	public int getMyValue() {
		return myValue;
	}

	public void setMyValue(int myValue) {
		this.myValue = myValue;
		notifyObservers(myValue);
	}

	@Override
	public void register(IObserver i) {
		// TODO Auto-generated method stub
		observerList.add(i);
	}

	@Override
	public void unregister(IObserver i) {
		// TODO Auto-generated method stub
		observerList.remove(i);
	}
	List<IObserver> observerList = new ArrayList<IObserver>();
	
	@Override 
	public void notifyObservers(int updatedValue) {
		for(int i=0;i<observerList.size();i++) {
			observerList.get(i).update(this.getClass().getSimpleName(), updatedValue);
		} 
		}

}
