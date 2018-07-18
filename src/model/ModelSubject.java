package model;
import view.ViewObserver;

public interface ModelSubject {
	void registerObserver(ViewObserver o);
	void removeObserver(ViewObserver o);
	void notifyObserver();
}
