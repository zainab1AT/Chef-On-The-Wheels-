package SwerProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class list extends Application {

	menu m;

public void start(Stage primaryStage) {

	//ListView
	 m=new menu();
			 ListView <String> food = new ListView<String>(FXCollections.observableArrayList(m.foodName)); 
			 food.setPrefSize(120, 150);
		 	 food.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		 	 ListView <String> drinks = new ListView<String>(FXCollections.observableArrayList(m.drinkName));
		 	 drinks.setPrefSize(120,150);
		 	 drinks.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		 	 
		 	 ListView <String> dessert = new ListView<String>(FXCollections.observableArrayList(m.dessertName));
		 	 dessert.setPrefSize(120,150);
		 	 dessert.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		 	 
		 	 
		 	 
	//flowPane for Image	 	 
			 FlowPane imagePane = new FlowPane(10, 10);
	//GridPane		 
			 GridPane pane = new GridPane();
			 pane.setHgap(1);
			 pane.setVgap(1);
			 pane.setStyle("-fx-padding: 20;" +
	                 "-fx-border-style: solid inside;" +
	                 "-fx-border-width: 10;" +
	                 "-fx-border-insets: 0;" +
	                 "-fx-border-radius: 0;" +
	                 "-fx-background-color:black;"+
	                 /*"-fx-background-image:url(nan.jpg);"*/" -fx-background-repeat: no-repeat;"+" -fx-background-size: 900 650;"+"-fx-background-position: center center;");
			   

	//Label Food Drinks Dessert
			 
		Button foodLabel=new Button("Meal");
		foodLabel.setPrefWidth(120);
		 ImageView mealImage=new ImageView(new Image("menuf.png"));
		 mealImage.setFitHeight(20);mealImage.setFitWidth(20);
		 foodLabel.setStyle("-fx-background-color:BURLYWOOD; ");
		 foodLabel.setTextFill(Color.BLACK);
		 foodLabel.setFont(Font.font("Cambria", 17));
	     DropShadow shadow=new DropShadow();
	     foodLabel.setEffect(shadow);
	     foodLabel.setGraphic(mealImage);
	     
	     Button drinkLabel=new Button("Drinks");	
	     drinkLabel.setPrefWidth(120);
		 ImageView drinkImage=new ImageView(new Image("drsym.png"));
		 drinkImage.setFitHeight(20);drinkImage.setFitWidth(20);
		 drinkLabel.setStyle("-fx-background-color:BURLYWOOD; ");
		 drinkLabel.setTextFill(Color.BLACK);
		 drinkLabel.setFont(Font.font("Cambria", 17));
		 drinkLabel.setEffect(shadow);
		 drinkLabel.setGraphic(drinkImage);
	     
	     Button dessertLabel=new Button("Dessert");
	     dessertLabel.setPrefWidth(120);
		 ImageView dessertImage=new ImageView(new Image("dessertsym.png"));
		 dessertImage.setFitHeight(20);dessertImage.setFitWidth(20);
		 dessertLabel.setStyle("-fx-background-color:BURLYWOOD; ");
		 dessertLabel.setFont(Font.font("Cambria", 17));
		 dessertLabel.setTextFill(Color.BLACK);
	     dessertLabel.setEffect(shadow);
	     dessertLabel.setGraphic(dessertImage);
			 
			 
 
				 
	//Add		 
			 pane.add(new ScrollPane(food),0,1);
			 pane.add(new ScrollPane(drinks),0,6); 
			 pane.add(new ScrollPane(dessert),0,11); 
			 
			 pane.add(imagePane,20,1);		 
			 pane.add(foodLabel, 0, 0);
			 pane.add(drinkLabel, 0, 4);
			 pane.add(dessertLabel, 0, 9);
			 
	//Action	
			 
			 
			food.getSelectionModel().selectedItemProperty().addListener( ov -> {
				
			 imagePane.getChildren().clear();
			 
			 for (Integer i: food.getSelectionModel().getSelectedIndices()) {
			 imagePane.getChildren().add(m.ImageViewsFood[i]);
			}});
			 
			drinks.getSelectionModel().selectedItemProperty().addListener( ov -> {
				
			 imagePane.getChildren().clear();
			 
			 for (Integer i: drinks.getSelectionModel().getSelectedIndices()) {
			 imagePane.getChildren().add(m.ImageViewsDrinks[i]);
			}});
			
			 
			dessert.getSelectionModel().selectedItemProperty().addListener( ov -> {
				
			 imagePane.getChildren().clear();
			 
			 for (Integer i: dessert.getSelectionModel().getSelectedIndices()) {
			 imagePane.getChildren().add(m.ImageViewsDessert[i]);
			}});
			
			
			
			
			 Scene scene = new Scene(pane,900,600); 
//			 primaryStage.setFullScreen(true);
			 primaryStage.setTitle("Chef On The Wheels "); // Set the stage title
			 primaryStage.setScene(scene); // Place the scene in the stage
			 primaryStage.show(); // Display the stage
			 }

	
			 public void changtoarrayList() throws Exception{
					
					m.MENU=new ArrayList <String> ();
					
				    File f=new File("/Users/ismaeel/Desktop/menu.txt");
					Scanner sc=new Scanner(f); 
				    try {
				       while(sc.hasNextLine()) {
				        	m.MENU.add(sc.nextLine());
				        }
				        sc.close();      
				    } catch (Exception e) {
				    	JOptionPane.showMessageDialog(null, "  I'M SORRY , YOU CAN'T CHOOSE ...");
				  	}				}
			 






 public static void main (String[]args) {
					launch(args);
				}

}

