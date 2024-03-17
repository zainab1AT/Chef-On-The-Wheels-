package SwerProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


import javax.swing.JOptionPane;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class InterFaceUserSwer extends Application{
	
protected PasswordField passf;
protected TextField namef;
protected ComboBox combo_box;
protected File userData;
protected Boolean found;
protected menu m;
protected Boolean choice;
protected File foodFile; 
protected File FileDrink;
protected File DessertFile;
protected double price;
protected double number;
protected ArrayList<String> Bill;
protected double bool;
protected String nameUser1;
protected String allOrder;


	public void start(Stage stage) throws Exception {
		
   try {
	   allOrder="";
	   nameUser1="";
	   Bill=new ArrayList<String>();
//UserPane
    	 GridPane UserPane =new GridPane();
    	 UserPane.setHgap(3);UserPane.setVgap(4);  
    	 
//MenuPane   	 
    	 GridPane MenuPane = new GridPane();
		 MenuPane.setHgap(1);
		 MenuPane.setVgap(1);
//LoadPane
		GridPane LaodPane =new GridPane(); 
		LaodPane.setHgap(1); LaodPane.setHgap(1); 

//flowPane for Image	 	 
        FlowPane imagePane = new FlowPane(30,5);		
        imagePane.setPrefHeight(100);
        imagePane.setPrefWidth(100);
        imagePane.setScaleY(1.5);
        imagePane.setScaleX(1.1);
        
Scene scene= new Scene(UserPane,1200,700);  
userData=new File("/user.txt");

	   

 //ListView
    	 m=new menu();
    	        m.imageviewPizza.setFitWidth(220);
    	        m.imageviewPizza.setFitHeight(200);
    	       
    	        m.imageviewCockes.setFitWidth(250);
    	        m.imageviewCockes.setFitHeight(200);
    	        
    	        m.imageviewLimon.setFitHeight(200);
    	        m.imageviewLimon.setFitWidth(230);
    	        
    	        m.imageviewkentaki.setFitHeight(200);
    	        m.imageviewkentaki.setFitWidth(200);
    	        
    	        m.imageviewkoktail.setFitHeight(200);
    	        m.imageviewkoktail.setFitWidth(200);
    	        
    			 ListView <String> food = new ListView<String>(FXCollections.observableArrayList(m.foodName)); 
    			 food.setPrefSize(130, 150);
    		 	 food.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    		 
    		 	 
    		
    		 	 ListView <String> drinks = new ListView<String>(FXCollections.observableArrayList(m.drinkName));
    		 	 drinks.setPrefSize(130,170);
    		 	 drinks.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    		 	 
    		 	 ListView <String> dessert = new ListView<String>(FXCollections.observableArrayList(m.dessertName));
    		 	 dessert.setPrefSize(130,170);
    		 	 dessert.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    		 	 
    		 	 
    		 	 

    			 
//MenuPane		 	
    		  MenuPane.setStyle("-fx-padding: 20;" +
    	                 "-fx-border-style: solid inside;" +
    	                 "-fx-border-width: 15;" +
    	                 "-fx-border-insets: 0;" +
    	                 "-fx-border-radius: 0;" +
    	                 "-fx-background-color:black;"+
    	                 "-fx-background-image:url(pp.jpg);"+" -fx-background-repeat: no-repeat;"+" -fx-background-size: 1200 700;"+"-fx-background-position: center center;");

//UserPane 
    		 
              UserPane.setStyle("-fx-padding: 10;" +
                  "-fx-border-style: solid inside;" +
                  "-fx-border-width: 7;" +
                  "-fx-border-insets: 0;" +
                  "-fx-border-radius: 0;" +
                  "-fx-border-color: white;"+
                  "-fx-background-image:url(blue.jpg);"+" -fx-background-repeat: no-repeat;"+" -fx-background-size:1200 700;"+"-fx-background-position: top left;");
      			  

//order 
  		
//button
  			Button plus=new Button();
  			MenuPane.add(plus, 28,13);
  			
  			plus.setVisible(false);
  			plus.setPrefHeight(30);
  			plus.setPrefWidth(30);
  			ImageView PLUSImage=new ImageView(new Image("plus.png"));
    		PLUSImage.setFitHeight(30);PLUSImage.setFitWidth(30);
    		plus.setGraphic(PLUSImage);
    		
//textField
  			TextField counter=new TextField();
  			MenuPane.add(counter, 30,13);
  			
  			counter.setVisible(false);
  			counter.setPrefHeight(30);
  			counter.setPrefWidth(100);
 //minus
  			Button minus=new Button();
  			MenuPane.add(minus,35,13);
  			
  			ImageView MINUSImage=new ImageView(new Image("minus.png"));
   		    MINUSImage.setFitHeight(30);MINUSImage.setFitWidth(30);
  			minus.setVisible(false);
  			minus.setPrefHeight(30);
  			minus.setPrefWidth(30);          
  			minus.setGraphic(MINUSImage);
              
              
              
              
//Label Food Drinks Dessert
    			 
    		Button foodLabel=new Button("Meal");
    		foodLabel.setPrefWidth(130);
    		ImageView mealImage=new ImageView(new Image("menuf.png"));
    		 mealImage.setFitHeight(20);mealImage.setFitWidth(20);
    		 foodLabel.setStyle("-fx-background-color:BURLYWOOD; ");
    		 foodLabel.setTextFill(Color.BLACK);
    		 foodLabel.setFont(Font.font("Cambria", 17));
    	     DropShadow shadow=new DropShadow();
    	     foodLabel.setEffect(shadow);
    	     foodLabel.setGraphic(mealImage);
    	     
    	     Button drinkLabel=new Button("Drinks");	
    	     drinkLabel.setPrefWidth(130);
    		 ImageView drinkImage=new ImageView(new Image("drsym.png"));
    		 drinkImage.setFitHeight(20);drinkImage.setFitWidth(20);
    		 drinkLabel.setStyle("-fx-background-color:BURLYWOOD; ");
    		 drinkLabel.setTextFill(Color.BLACK);
    		 drinkLabel.setFont(Font.font("Cambria", 17));
    		 drinkLabel.setEffect(shadow);
    		 drinkLabel.setGraphic(drinkImage);
    	     
    	     Button dessertLabel=new Button("Dessert");
    	     dessertLabel.setPrefWidth(130);
    		 ImageView dessertImage=new ImageView(new Image("dessertsym.png"));
    		 dessertImage.setFitHeight(20);dessertImage.setFitWidth(20);
    		 dessertLabel.setStyle("-fx-background-color:BURLYWOOD; ");
    		 dessertLabel.setFont(Font.font("Cambria", 17));
    		 dessertLabel.setTextFill(Color.BLACK);
    	     dessertLabel.setEffect(shadow);
    	     dessertLabel.setGraphic(dessertImage);
    			 
	 
//Add		 
    			 MenuPane.add(new ScrollPane(food),0,2);
    			 MenuPane.add(new ScrollPane(drinks),0,6); 
    			 MenuPane.add(new ScrollPane(dessert),0,11); 
    			 
    			 MenuPane.add(imagePane,23,2);		 
    			 MenuPane.add(foodLabel, 0, 1);
    			 MenuPane.add(drinkLabel, 0,4);
    			 MenuPane.add(dessertLabel, 0, 9);
    		
    			 
    			
    			 
//File	 
    			 foodFile =new File("/Users/ismaeel/Pictures/prooj/menufood.txt");
    			 FileDrink=new File("/Users/ismaeel/Pictures/prooj/menudrinks.txt");
    			 DessertFile=new File("/Users/ismaeel/Pictures/prooj/menudessert.txt");
    			 
    			 
    			 
	
    			
 //TextArea
    			TextArea  area=new TextArea();
    			area.setOpacity(0.8);
    			area.setPrefHeight(200);
    			area.setPrefWidth(220);
   			    area.setScaleY(1.5);
    			area.setVisible(false);
    			area.setScaleX(1.7);
    			
    			MenuPane.add(area, 40, 2);
    			
    			
 //image foe menuPane
    			ImageView symbol1=new ImageView(new Image("s3.png"));
    			symbol1.setFitWidth(120);symbol1.setFitHeight(120);
    			symbol1.toFront();
    			MenuPane.add(symbol1, 280,0); 
    			
    			
    //Action	
    			
        		
        		Button buy=new Button("BUY")	;
        		
        			buy.setPrefWidth(150);
        			buy.setVisible(false);
          			buy.setPrefHeight(30);
          			MenuPane.add(buy, 50, 14);		
    			
    			
    			
    			food.getSelectionModel().selectedItemProperty().addListener( e -> {	
    				bool=1;
    			 imagePane.getChildren().clear();
    			 for (Integer i: food.getSelectionModel().getSelectedIndices()) {
    			 imagePane.getChildren().add(m.ImageViewsFood[i]);	 
    				counter.setVisible(true);
    				plus.setVisible(true);
    				minus.setVisible(true);
    			   buy.setVisible(true);
    			
    			   counter.setText("0");
    			 m.foodarray=new ArrayList <String> (); 
    			 try {
					m.changtoarrayList(foodFile,m.foodarray);
					
				} catch (Exception e1) {
					System.out.println( e1);}				
   
   		  	   for(int j=0;j<m.foodarray.size();j++) {
			    	String n=m.foodarray.get(j);
			    	String []arr=new String[m.foodarray.size()];
			    	arr=n.split(":");	
			    	 
					if(arr[0].equals(food.getSelectionModel().getSelectedItem())) {
							area.setText(arr[0]+"\n"+arr[1]+"\n"+arr[2]+"\n"+arr[3]+"\n"+arr[4]);
							area.setVisible(true);

	       
								break; }
			
   		  	   }number=0;	
    				}});
    		
buy.setOnAction(e->{
	try {
	if(bool==1) {
		
		int i=(int) element(food);
		number=Double.parseDouble(counter.getText());
		double costOne=m.foodCost[i]*number;
		Bill.add(costOne+" :     "+m.foodName[i]);
		this.price+=costOne;
		//System.out.print(costOne+m.foodName[i]);
	} else if(bool==2) {
		int i=(int) element(drinks);
		number=Double.parseDouble(counter.getText());
		double costOne=m.drinkCost[i]*number;
		Bill.add(m.drinkCost[i]+" :     "+m.drinkName[i]);
		this.price+=costOne;
	}
	else if(bool==3) {
		int i=(int) element(dessert);
		number=Double.parseDouble(counter.getText());
		double costOne=m.dessertCost[i]*number;
		Bill.add(m.dessertCost[i]+" :     "+m.dessertName[i]);
		this.price+=costOne;
	}
	}catch(Exception o) {
		JOptionPane.showMessageDialog(null, "  ERROR IN BUY BUTTON ");
	}
	
});
      			
      			
    			
    			plus.setOnAction(e->{
    				number++;
    				counter.setText(number+"");
    			});
    
    			minus.setOnAction(e->{
    				if(number==0) {
    					counter.setText("0");
    				}
    				else {
    				number--;
    				counter.setText(number+"");}
    			});
    
    			
    			 
    			 drinks.getSelectionModel().selectedItemProperty().addListener( e -> {
    				 bool=2;
    			 imagePane.getChildren().clear();    			 
    			 for (Integer i: drinks.getSelectionModel().getSelectedIndices()) {
    			 imagePane.getChildren().add(m.ImageViewsDrinks[i]);
    			 
    			 counter.setVisible(true);
 				 plus.setVisible(true);
 				 minus.setVisible(true);
 				buy.setVisible(true);
 				
    			 m.drinkarray=new ArrayList <String> (); 
     			try {
 					m.changtoarrayList(FileDrink,m.drinkarray);
 					
 				} catch (Exception e1) {
 					System.out.println( e1);}				
    
    			 for(int j=0;j<m.drinkarray.size();j++) {
 			    	String n=m.drinkarray.get(j);
 			    	String []arr=new String[m.drinkarray.size()];
 			    	arr=n.split(":");	
 			    	 
 					if(arr[0].equals(drinks.getSelectionModel().getSelectedItem())) {
 							area.setText(arr[0]+"\n"+arr[1]+"\n"+arr[2]+"\n"+arr[3]+arr[4]);
 							area.setVisible(true);
 							
 								break; }}
    			
    		     counter.setText(0+"");
    		     number=0;
    			}});
    			
    			 
    			dessert.getSelectionModel().selectedItemProperty().addListener( e -> {	
    				bool=3;
    			 imagePane.getChildren().clear(); 
    			 for (Integer i: dessert.getSelectionModel().getSelectedIndices()) {
    			 imagePane.getChildren().add(m.ImageViewsDessert[i]);
    			 
    			 counter.setVisible(true);
 				plus.setVisible(true);
 				minus.setVisible(true);
 				buy.setVisible(true);
 				number=0;
    			 m.dessertarray=new ArrayList <String> (); 
      			try {
  					m.changtoarrayList(DessertFile,m.dessertarray);
  					
  				} catch (Exception e1) {
  					System.out.println( e1);}				
     
     			 for(int j=0;j<m.dessertarray.size();j++) {
  			    	String n=m.dessertarray.get(j);
  			    	String []arr=new String[m.dessertarray.size()];
  			    	arr=n.split(":");	
  			    	 
  					if(arr[0].equals(dessert.getSelectionModel().getSelectedItem())) {
  							area.setText(arr[0]+"\n"+arr[1]+"\n"+arr[2]+"\n"+arr[3]);
  							area.setVisible(true);
  							
  								break; }}	
  		
//    		     counter.setText(0+"");
    		     number=0;
    			}});
   
  Button order=new Button ("Order's Bill");
  MenuPane.add(order, 200, 40);	
  order.setPrefWidth(150);
  order.setStyle("-fx-background-color:black; ");
  order.setTextFill(Color.WHITE);
  DropShadow shadow2=new DropShadow();
  order.setEffect(shadow2);
  
 //Bill 
  
        GridPane orderbill=new GridPane();
        orderbill.setStyle("-fx-background-color:CADETBLUE; ");
        orderbill.setHgap(10);
        orderbill.setVgap(5);
        
             Label fat=new Label("Your Bill"); 
             fat.setTextFill(Color.WHITE);
             fat.setFont(Font.font("Cambria", 25));
             fat.setUnderline(true);
             orderbill.add(fat, 25, 1);
   
   
   Label price1 =new Label("\nThe Total Price =   "+price);
   price1.setTextFill(Color.BLACK);
   
   Label thank=new Label("Thank You ..."); 
   thank.setTextFill(Color.BLACK);
   thank.toFront();
   thank.setFont(Font.font("Cambria", 25));
   orderbill.add(thank, 0,30);

   Label nameuser=new Label("You Name :      "+this.nameUser1+"\n");
   nameuser.setTextFill(Color.BLACK);
   nameuser.setFont(Font.font("Cambria",18));
 
   TextArea all=new TextArea();
   all.setPrefHeight(100);
   all.setPrefWidth(100);

 
   all.setText(allOrder);
   
   all.setStyle("-fx-background-color:CADETBLUE; ");

   
   
  VBox or=new VBox();
  or.setPrefHeight(400);
  or.setPrefWidth(250);
  or.setStyle("-fx-background-color:white; ");
  
  
  orderbill.add(or, 25, 5);
  or.setScaleX(2.1);

  or.getChildren().addAll(nameuser,price1,all);
//  orderbill.add(all, 15, 10);

  
    order.setOnAction(e->{
    	MenuPane.setVisible(false);
    	UserPane.setVisible(false);
    	orderbill.setVisible(true);
    	scene.setRoot(orderbill);
    	price1.setText("Your Total Price =     "+price);
    	  for(int y=0;y<Bill.size();y++) {
    		   this.allOrder=allOrder.concat(Bill.get(0)+"  ");}
    	  all.setText(allOrder);
    });			
    			


//AppImage
        Image im1=new Image("ch.jpg");
		stage.getIcons().add(im1);
//AppName
	    stage.setTitle("Chef On The Wheels");
//Images		
		ImageView symbol=new ImageView(new Image("s3.png"));
		symbol.setFitWidth(140);symbol.setFitHeight(140);
		symbol.toFront();
		UserPane.add(symbol, 0, 0);  
		
		 
//Labels
     Label welcome=new Label("  Welcome To\n     Our Family...");
     welcome.setFont(Font.font("Cambria", 20));
     welcome.setTextFill(Color.BLACK);
     UserPane.add(welcome,0,1);
     
     
//Rectangle
     Rectangle white=new Rectangle();
     white.setHeight(50);
     white.setWidth(160);
     white.setFill(Color.WHITE);
     white.setOpacity(0.5);
     UserPane.add(white,0,1);
     white.setScaleY(18);
     white.toBack() ;
     
     Rectangle recta=new Rectangle();
     recta.setHeight(20); recta.setWidth(100);
     MenuPane.add(recta, 0, 0);
     recta.toBack();
     recta.setScaleX(100);
     
       Label incorrect=new Label("Your name or Password is incorrect.. ");
       incorrect.setTextFill(Color.RED);
       incorrect.setUnderline(true);
       incorrect.setVisible(false);
       UserPane.add(incorrect, 5, 34);
       
//TextFields
       namef=new TextField();
       namef.setPromptText("Enter Your Name");
       namef.setDisable(true);
       UserPane.add(namef, 15, 31);
       
       passf=new PasswordField();
       passf.setPromptText("Password");
       passf.setDisable(true);
       UserPane.add(passf, 15, 32);
       
 //toolip for password  
      Tooltip tooltip = new Tooltip();
       tooltip.setText(
           "\nYour password must be\n" +
           "at least 4 characters in length\n"  
       );
      passf.setTooltip(tooltip);
      
  
ImageView user=new ImageView(new Image("usee.png"));
user.setFitHeight(200);
user.setFitWidth(200);
UserPane.add(user,15,1);
      
//Buttons        
        RadioButton newUser =new RadioButton("New User");
        newUser.setFont(Font.font("Cambria", 17));
        newUser.setTextFill(Color.WHITE);
        
        RadioButton oldUser =new RadioButton("Old User");
        oldUser.setTextFill(Color.WHITE);
        oldUser.setFont(Font.font("Cambria", 17));
        
        Button sign =new Button("Log in ->");
        sign.setStyle("-fx-background-color:black; ");
        sign.setTextFill(Color.WHITE);
        DropShadow shadow1=new DropShadow();
        sign.setEffect(shadow1);
           
        
        String citiesArray[] = { "Bethlehem", "Hebron", "Beit Jala","Beit Sahour", "Jericho","Ramallah & El-Bireh","Nablus",
        "Tulkarem", "Jenin","Gaza", "Rafah","Khan Younis" };

       // Create a combo box
        combo_box = new ComboBox(FXCollections.observableArrayList(citiesArray));
        combo_box.setDisable(true); 
        combo_box.setPromptText("City");
        
        
        UserPane.add(combo_box,15,33);
        UserPane.add(sign, 20, 36);
        UserPane.add(oldUser, 15, 20);
        UserPane.add(newUser, 15, 21);
//action
        newUser.setOnAction(e->{  
        	
        	passf.setDisable(false);
        	namef.setDisable(false);
        	combo_box.setDisable(false);
        	price=0;
            oldUser.setSelected(false);
            newUser.setSelected(true);
        
  });   
            oldUser.setOnAction(e->{  
        	this.found=false;
        	passf.setDisable(false);
        	namef.setDisable(false);
        	combo_box.setDisable(false);
        	oldUser.setSelected(true);
	        newUser.setSelected(false);
	        price=0;
	   });  
        sign.setOnAction(e->{ 
        	if(newUser.isSelected()) {
        		Bill.clear();
        	writeNewUser(); }
        	else if(oldUser.isSelected()) {
        		Bill.clear();
        		try {
        			
        		userSwer u1=new userSwer(namef.getText(),passf.getText());
        		this.nameUser1=this.namef.getText();
      	    	u1.changtoarrayList();
        		findUser(u1);
        		
                //to   		
        		if(found==true) {
        		scene.setRoot(MenuPane);	
        		UserPane.setVisible(false)	;
        	    MenuPane.setVisible(true);
        	
        		}
        		else {incorrect.setVisible(true);}
        		}catch(Exception nn) { JOptionPane.showMessageDialog(null, "Your Name or Password is incorrect -_-");}	
        	}
        	passf.clear();
        	namef.clear();
        	
        	combo_box.setDisable(true);
        	passf.setDisable(true);
        	namef.setDisable(true);
        	
        });  

	
    

       
		stage.setScene(scene);
		stage.show();
    }
    catch(Exception e) {   JOptionPane.showMessageDialog(null, " Please, Enter a valid value ");  }
	}
	
	
	  public void writeNewUser() {    
	        FileWriter fw = null;
	        try {
	            fw = new FileWriter(userData, true);
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(namef.getText());
	            bw.write(":");
	            bw.write(passf.getText());
	            bw.write(":");
	            bw.write(combo_box.getValue()+"");
	            bw.newLine();
	            bw.flush();
	            fw.close();
	            bw.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	  public void findUser(userSwer ur) throws Exception{
			try {
				ur.changtoarrayList();
				for(int i=0;i<ur.ArrayListUserData.size();i++) {
			    	String n=ur.ArrayListUserData.get(i);
			    	String []arr=new String[3];
			    	arr=n.split(":");	    	
			    	
					if(arr[0].equals(namef.getText())&&arr[1].equals(passf.getText())) {
							found=true;
							break; 		
					}	
				}	
			}catch(Exception ee) {JOptionPane.showMessageDialog(null, " ");} 
	  }  
	  
	  
	  
//	  public double costOne(ArrayList<String> array,ListView Lv) throws Exception{
//			try {
//					
//				for(int j=0;j<array.size();j++) {
//  			    	String n=array.get(j);
//  			    	String []arr=new String[array.size()];
//  			    	arr=n.split(":");
//  			    	
//  			  	if(arr[0].equals( Lv.getSelectionModel().getSelectedItem())) {
//  			    	double cost=Double.parseDouble(arr[2]);
//  			    	
//  			    	return cost;}	
//  			  	
//  			  	
//				}}catch(Exception ee) {JOptionPane.showMessageDialog(null, " Im Sorry");}
//			return 100; 
//	  }  
	  
	  public double element(ListView Lv) {
double g= Lv.getSelectionModel().getSelectedIndex();	  
return g;	  
	  }
	  
	  
	  
	  
	public static void main (String[]args) {
		launch(args);
		
}}

