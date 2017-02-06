package cmd;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class main {
	
public static void main(String args[]) throws IOException{
	
//	ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","start","cmd");
//	pb=pb.directory(new File("D:\\"));
//	pb.start();
	
// سيب ال comment اللى فوق زى م هو متمسحوش
	
	
	
	functions s1=new functions();
	Scanner f1=new Scanner(System.in);
	boolean stat=true;
	
	
	while(stat==true){
		String s="";
		System.out.println("CMD : ");
		s=f1.nextLine();
		
		if(s.equals("cl")){
			s1.cl();
		}
		if(s.equals("pwd")){
			s1.pwd();
		}
		if(s.equals("cd")){
			String d="";
			d=f1.nextLine();
			s1.cd(d);	
		}
		if(s.equals("ls")){
			s1.ls(s1);
		}
		if(s.equals("rm")){
			String d="";
			d=f1.nextLine();
			s1.rm(d);	
		}
		if(s.equals("mkdir")){
			String d="";
			d=f1.nextLine();
			s1.mkdir(d);	
		}
		
		if(s.equals("q")){
			System.out.print("Thanks For Using Our Program"); //function el exit ya samy 
			stat=false;
		}
		
		
		
		
	}
	
	
	
	
	
	
	

	
	
	
	

	
//	String f="C:\\Users\\MRM\\Desktop\\";
//	String del="x1.txt";
//	
//	File f1=new File(del);
//		
//		
//		
//
//		
//		s1.rm(del);
//		s1.mkdir(del);
		
		
		
		
		
		
		
		
		//s1.cl();
		
		
		
		
		
		
		
		
		
	}

}
