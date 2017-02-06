
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
//		ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","start","cmd");
//		pb=pb.directory(new File("D:\\"));
//		pb.start();
		
		
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		functions f1 = new functions();
		String default_dir = "D:\\Courspwdes level three\\New folder\\Assignment_OS";
		boolean stat = true;
		String s= "";

		
		while(stat==true){
			System.out.println("CMD : ");
			s=s1.nextLine();
			
			if(s.equals("cl")||s.contains("cl")){
				f1.cl();
			}
			if(s.equals("pwd")||s.contains("pwd")){
				f1.pwd();
			}
			if(s.equals("cd")||s.contains("cd")){
				String d="";
				d=s1.nextLine();
				if(d.isEmpty())f1.cd(default_dir);
				else f1.cd(d);	
			}
			if(s.equals("ls")||s.contains("ls")){
				if(s.contains(">>")){
					try {
						f1.ls(f1, s.substring(4), ">>");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(s.contains(">")){
					try {
						f1.ls(f1, s.substring(3), ">");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else
					f1.ls(f1);
			}
			if(s.equals("rm")||s.contains("rm")){
				String d="";
				d=s1.nextLine();
				f1.rm(d);	
			}
			if(s.equals("mkdir")||s.contains("mkdir")){
				String d="";
				d=s1.nextLine();
				try {
					f1.mkdir(d);
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			if(s.equals("rmdir")||s.contains("rmdir"))
			{
				String d="";
				d=s1.nextLine();
				f1.rmdir(d);
			}
			if(s.equals("cp")||s.contains("cp"))
			{
				String d="";
				String d2="";
				d=s1.nextLine();
				d2=s2.nextLine();
				f1.cp(d, d2);
			}
			if(s.equals("cat")||s.contains("cat"))
			{
				String d="";
				d=s1.nextLine();
				try {
					f1.cat(d);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(s.equals("mv")||s.contains("mv"))
			{
				String d="";
				String d2="";
				d=s1.nextLine();
				d2=s2.nextLine();
				f1.mv(d,d2);
			}
			if(s.equals("date")||s.contains("date"))
			{
				f1.date();
			}
			if(s.equals("help")||s.contains("help"))
			{
				f1.help();
			}
			if(s.charAt(0)=='?')
			{
				f1.question_mark(s.substring(1));
			}
			if(s.equals("args")||s.contains("args"))
			{
				String d="";
				d=s1.nextLine();
				f1.args(d);
			}
			if(s.equals("exit")||s.contains("exit")){
				System.out.print("Thanks For Using Our Program"); //function el exit ya samy 
				f1.exit();
				stat=false;
			}
//			else
//				System.out.println("You have intered an inexact command.");
		}
		s1.close();
		s2.close();

	}
}
