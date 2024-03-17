package SwerProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class userSwer extends InterFaceUserSwer{
	
protected ArrayList <String>ArrayListUserData;
String na;
String pa;

public userSwer(String na, String pa) {
	this.na = na;
	this.pa = pa;

}


public void changtoarrayList() throws Exception{
	
	this.ArrayListUserData=new ArrayList <String> ();
	
    File f=new File("/user.txt");
	Scanner sc=new Scanner(f); 
    try {
       while(sc.hasNextLine()) {
        	ArrayListUserData.add(sc.nextLine());
        }
        sc.close();      
    } catch (Exception e) {
    	JOptionPane.showMessageDialog(null, "  I'M SORRY , YOU CAN'T ENTER ...");
  	}

}



}

