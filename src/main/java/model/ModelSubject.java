package main.java.model;
import main.java.view.ViewObserver;

public interface ModelSubject {
	void registerObserver(ViewObserver o);
	void removeObserver(ViewObserver o);
	void notifyObserver();
}
