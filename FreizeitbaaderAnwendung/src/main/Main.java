package main;

import gui.FreizeitbaederControl;
import gui.FreizeitbaederView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new FreizeitbaederControl(primaryStage);
		
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
