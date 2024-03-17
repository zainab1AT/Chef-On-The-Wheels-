package SwerProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class menu  extends InterFaceUserSwer{
	ArrayList<String >foodarray;
	ArrayList<String >drinkarray;
	ArrayList<String >dessertarray;
	
	ImageView imageviewPizza=new ImageView(new Image("pizzaa.jpg"));
	ImageView imageviewCockes=new ImageView(new Image("cockes.jpg"));
	ImageView imageviewLimon=new ImageView(new Image("MintLemonade.jpg"));
	ImageView imageviewkentaki=new ImageView(new Image("knta.jpg"));	
	ImageView imageviewkoktail=new ImageView(new Image("Koktail.jpg"));

	
	String[] foodName = {"Pizza","Burger","Hot Dog","kentucky fried chicken","KEBAB"};
	 String[] drinkName = {"Mint Lemonade","Koktail","Coca-Cola","Barbajada","Orange Juice"};
	 String[] dessertName = {"Chocolate chip cookies","Glazer Doughnuts","Pineapple upside-down cake","Bavarian cream crumb ","pastry"};

     ImageView[] ImageViewsFood = { imageviewPizza,new ImageView(new Image("mooburger.jpg")),new ImageView(new Image("HotDog.jpg")),imageviewkentaki,new ImageView(new Image("kaba.jpg"))};
	 ImageView[] ImageViewsDrinks = {imageviewLimon,imageviewkoktail,new ImageView(new Image("coca.jpg")),new ImageView(new Image("Barbajada.jpg")),new ImageView(new Image("orangj.jpg"))} ;			 
	 ImageView[] ImageViewsDessert = {imageviewCockes,new ImageView(new Image("dona.jpg")),new ImageView(new Image("pin.jpg")),new ImageView(new Image("Bavarian.jpg")),new ImageView(new Image("tart.jpg"))} ;			 

	 double[] foodCost = {40,35,35,50,70};
	 double[] drinkCost = {15,7,15,5,17};
	 double[] dessertCost = {55,55,55,20,30};
	 
	 public void changtoarrayList(File f,ArrayList array) throws Exception{
			
			
			Scanner sc=new Scanner(f); 
		    try {
		       while(sc.hasNextLine()) {
		        	array.add(sc.nextLine());
		        }
		        sc.close();      
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, "  I'M SORRY , YOU CAN'T ENTER ...");
		  	}

		}

}

