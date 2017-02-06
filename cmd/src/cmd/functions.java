package cmd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class functions {
	
	String h="";
	String m="";
	Scanner d1=new Scanner(System.in);
	
	
	
	public void more(functions r1){
		
		for(int i=0;i<2;i++){
			System.out.println("");
		}
		
	}


	
	public void cl(){
		
		for(int i=0;i<=50;i++){
			System.out.println("");
		}
		
	}
	
	
	public String cd(String d){
		
		File file=new File(".");
	    System.out.println("Current Working Directory: " + file.getAbsolutePath());
	    System.setProperty("user.dir",d);
	    System.out.println("New Current Working Directory: " + file.getAbsolutePath());
	    h=d;
		return d;

	}
	
//make the java folder my default folder and get the directory i am in if i change it 
	
	public String pwd(){
		String j=System.getProperty("user.dir");
		System.out.println("Current relative path is: " + j);
		return j;
	}
	
	
	
	public void ls(functions f1) {

		File folder = new File(f1.h);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("file " + listOfFiles[i].getName());
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("folder " + listOfFiles[i].getName());
		      }
		    }
    }
	
	
	public void rm(String s1){
		s1=h+s1;
		File xx = new File(s1);
	    if (xx.isFile()) {
	       xx.delete();     
	    }
	    
	    else System.out.println("File Not Found");
	}
	

	
	
	
	
	public void mkdir(String s1) throws IOException{
		String h1=h+s1;
		File x1=new File(h1);
		if(x1.exists()){
			functions f1=new functions();
			f1.cd(h1);
		}
		else{
			File f=new File(h1);
			f.createNewFile();
			functions f1=new functions();
			f1.cd(h1);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
