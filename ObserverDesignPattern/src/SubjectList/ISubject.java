package SubjectList;

import ObserverList.IObserver;

public interface ISubject {

	void register(IObserver i);
	void unregister(IObserver i);
	void notifyObservers(int i);
}
