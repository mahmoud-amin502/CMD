/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 *
 * @author Mohamedhesham
 */
public class Functions {
 public static void copy(String from,String to){
       
        InputStream inStream = null;
	OutputStream outStream = null;

    	try{

    	    File afile =new File(from);
    	    File bfile =new File(to);

    	    inStream = new FileInputStream(afile);
    	    outStream = new FileOutputStream(bfile);

    	    byte[] buffer = new byte[1024];

    	    int length;
    	    //copy the file content in bytes
    	    while ((length = inStream.read(buffer)) > 0){

    	    	outStream.write(buffer, 0, length);

    	    }

    	    inStream.close();
    	    outStream.close();

    	    //delete the original file
    	  

    	    System.out.println("File is copied successful!");

    	}catch(IOException e){
    	    e.printStackTrace();
    	}} 
 public static void  cat(String fn) throws   FileNotFoundException,IOException {
     BufferedReader br = new BufferedReader(new FileReader("1.txt"));
 String line = null;
 while ((line = br.readLine()) != null) {
   System.out.println(line);
 }
 
 
 }
 public static void move(String from,String to){
 
 try {File f1=new File (from);
            File file = new File(to);
            if(file.createNewFile()){
                System.out.println("File creation successfull");
            copy(from,to);
            f1.delete();}
            
            else
                System.out.println("Error while creating File, file already exists in specified path");
        }
        catch(IOException io) {
            io.printStackTrace();
        }

 } 
 public static void date(){
 
 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
//	   Date date = new Date();
//	   System.out.println(dateFormat.format(date));

	   //get current date time with Calendar()
	   Calendar cal = Calendar.getInstance();
	   System.out.println(dateFormat.format(cal.getTime()));
 } 
 public static void help(){
 System.out.println("move :move the file to anthor folder move(path from ,path to)");
 System.out.println("copy :copy the content of the file to other file copy(path from ,path to)");
 System.out.println("cat : display the content of the file cat(path file");
 System.out.println("data : display the current date date()");
 }
 public static void exit(){
 System.exit(0);
 }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException  {
     //copy("1.txt","aa.txt");
      //cat("1.txt");
//move("C:\\Users\\Mohamedhesham\\Desktop\\functions\\aa.txt","C:\\Users\\Mohamedhesham\\Desktop\\functions\\a\\aa.txt")  ;  
//date();
//exit();
//help();

    }
}
        






// TODO code application logic here1
    
    

