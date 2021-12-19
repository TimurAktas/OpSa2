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

	private ArrayList <Freizeitbad> freizeitbaeder = new ArrayList<>();
	
	public void addFreizeitbad(Freizeitbad freizeitbad) {
		freizeitbaeder.add(freizeitbad);
		notifyObservers();
	}

	public ArrayList<Freizeitbad> getFreizeitbad() {
		return freizeitbaeder;
	}
	
	
	private FreizeitbaederModel() {
	}


	private static final FreizeitbaederModel fbModel = new FreizeitbaederModel();

	public static FreizeitbaederModel getInstance() {
		return fbModel;
	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		Creator c = new ConcreteCreator();
		Product writer = c.factoryMethod();
		for(Freizeitbad fzb : freizeitbaeder) {
			writer.fuegeInDateiHinzu(fzb);
		}
		writer.schliesseDatei();

	}

	public void schreibeFreizeitbaederInTxTDatei() throws IOException {
		Creator c = new ConcreteTxTCreator();
		Product writer = c.factoryMethod();
		for(Freizeitbad fzb: freizeitbaeder){
			writer.fuegeInDateiHinzu(fzb);
		}
		writer.schliesseDatei();
	}


	private ArrayList<Observer> observers = new ArrayList<Observer>();

	
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
	public void removeObserver(Observer obs) { observers.remove(obs);}
}
