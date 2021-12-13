package business;

import java.io.*;
import java.util.ArrayList;

import fabrik.ConcreteCreator;
import fabrik.Creator;
import fabrik.Product;
import gui.guiFreizeitbaeder.FreizeitbaederView;
import fabrik.ConcreteTxTCreator;
import observer.Observable;
import observer.Observer;

public final class FreizeitbaederModel implements Observable {

	private ArrayList<Observer> observers = new ArrayList<Observer>();

	private Freizeitbad freizeitbad;
	private static FreizeitbaederModel getInstance=null;
	
	
	private FreizeitbaederModel() {
		super();
	}

	public static FreizeitbaederModel getInstance() {
		if(getInstance==null)
		getInstance = new FreizeitbaederModel();
		
		return getInstance;
	}

	public Freizeitbad getFreizeitbad() {
		return this.freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
		notifyObservers();
	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		Creator c = new ConcreteCreator();
		Product writer = c.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();

	}

	public void schreibeFreizeitbaederInTxTDatei() throws IOException {
		Creator c = new ConcreteTxTCreator();
		Product writer = c.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}

	public void deleteObserver(Observer o) {
		observers.remove(o);
	}

	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update();
		}
	}

	@Override
	public void removeObserver(Observer obs) {}
}
