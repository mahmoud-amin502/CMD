import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class functions {

	private String h = "";

	public static void clear() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	public void date() {
		Date d = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		DateFormat dt = DateFormat.getTimeInstance(DateFormat.FULL);
		System.out.println(df.format(d));
		System.out.println(dt.format(d));
	}

	public void cp(String from, String to) {
		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			File afile = new File(from);
			File bfile = new File(to);
			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);
			byte[] buffer = new byte[1024];
			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}
			inStream.close();
			outStream.close();
			// delete the original file
			System.out.println("File is copied successful!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cat(String fn) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fn));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}

	public void mv(String from, String to) {
		try {
			File f1 = new File(from);
			File file = new File(to);
			if (file.createNewFile()) {
				System.out.println("File creation successfull");
				cp(from, to);
				f1.delete();
			} else
				System.out
						.println("Error while creating File, file already exists in specified path");
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public void date2() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// get current date time with Date()
		Date date = new Date();
		System.out.println(dateFormat.format(date));

		// get current date time with Calendar()
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
	}

	public void exit() {
		System.exit(0);
	}

	public void cl() {

		for (int i = 0; i <= 50; i++) {
			System.out.println("");
		}

	}

	public String cd(String d) {

		File file = new File(".");
		System.out.println("Current Working Directory: "
				+ file.getAbsolutePath());
		System.setProperty("user.dir", d);
		System.out.println("New Current Working Directory: "
				+ file.getAbsolutePath());
		h = d;
		return d;

	}

	// make the java folder my default folder and get
	// the directory i am in if i change it

	public String pwd() {
		String j = System.getProperty("user.dir");
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

	public void ls(functions f1, String s1, String type) throws IOException {

		File folder = new File(f1.h);
		File[] listOfFiles = folder.listFiles();

		if (type.equalsIgnoreCase(">>")) {
			FileWriter appendfile = new FileWriter(s1, true);
			BufferedWriter buffer2 = new BufferedWriter(appendfile);
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					buffer2.write(listOfFiles[i].getName());
					buffer2.newLine();
				} else if (listOfFiles[i].isDirectory()) {
					buffer2.write(listOfFiles[i].getName());
					buffer2.newLine();
				}
			}
			buffer2.close();

		} else {
			FileWriter truncfile = new FileWriter(s1);
			BufferedWriter buffer1 = new BufferedWriter(truncfile);
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					buffer1.write(listOfFiles[i].getName());
					buffer1.newLine();
				} else if (listOfFiles[i].isDirectory()) {
					buffer1.write(listOfFiles[i].getName());
					buffer1.newLine();
				}
			}
			buffer1.close();
		}
	}

	public void rm(String s1) {
		s1 = h + s1;
		File xx = new File(s1);
		if (xx.isFile()) {
			xx.delete();
		}

		else
			System.out.println("File Not Found");
	}

	public void mkdir(String s1) throws IOException {
		String h1 = h + s1;
		File x1 = new File(h1);
		if (x1.exists()) {
			functions f1 = new functions();
			f1.cd(h1);
		} else {
			File f = new File(h1);
			f.createNewFile();
			functions f1 = new functions();
			f1.cd(h1);
		}
	}

	public void help() {

		System.out
				.println("mv(path from ,path to) : move the file to anthor folder.");
		System.out
				.println("cp(path from ,path to) : copy the content of the file to other file.");
		System.out.println("cat(path file : display the content of the file.");
		System.out.println("data() : display the current date.");
		System.out.println("clear() : clear the console.");
		System.out
				.println("cd(new path) : take path and change the directory to it.");
		System.out.println("ls() : print all folders and files in alist.");
		System.out
				.println("rm(fiel name) : remove file from the current directory.");
		System.out
				.println("mkdir(name ) : creat new directory with the given name.");
		System.out
				.println("rmdir(name ) : remove the empty directory with the given name.");
		System.out.println("pwd() : show you the current directory.");
		System.out
				.println("args(command name) : show you arguments of this command.");
		System.out
				.println("help() : show you all commands and there arguments.");
		System.out.println("more() : display the output in pages.");
		System.out
				.println("?(command name) : show you the help about the command only.");
	}

	public void args(String com) {
		switch (com) {
		case "clear":
			System.out.println("The command clear has no args.");
			break;
		case "cd":
			System.out.println("String : Directory");
			break;
		case "ls":
			System.out.println("The command ls has no args.");
			break;
		case "cp":
			System.out.println("String : FromFile.txt, String : ToFile.txt");
			break;
		case "mv":
			System.out.println("String : FromPath, String : ToPath");
			break;
		case "rm":
			System.out.println("String : FileName.txt");
			break;
		case "mkdir":
			System.out.println("String : FileName");
			break;
		case "rmdir":
			System.out.println("String : FileName");

			break;
		case "cat":
			System.out.println("String : Directory");
			break;
		case "pwd":
			System.out.println("The command pwd has no args");
			break;
		case "date":
			System.out.println("The command date has no args");
			break;
		case "args":
			System.out.println("String : CommandName");
			break;
		case "help":
			System.out.println("The command help has no args");
			break;
		case "more":
			System.out.println("The command more has no args");
			break;
		default:
			System.out.println("You have enterd an inexact command.");
			break;
		}
	}

	public void question_mark(String com) {
		switch (com) {
		case "clear":
			System.out.println("clear() : clear the console.");
			break;
		case "cd":
			System.out
					.println("cd(new path) : it take path and change the directory to it.");
			break;
		case "ls":
			System.out
					.println("ls() : is print all folders and files in alist.");
			break;
		case "cp":
			System.out
					.println("cp(path from ,path to) : copy the content of the file to other file.");
			break;
		case "mv":
			System.out
					.println("mv(path from ,path to) : move the file to anthor folder.");
			break;
		case "rm":
			System.out
					.println("rm(file name) : remove file from the current directory.");
			break;
		case "mkdir":
			System.out
					.println("mkdir(path ) : it change the directory to the new path.");
			break;
		case "rmdir":
			System.out
					.println("rmdir(name ) : remove the empty directory with the given name.");
			break;
		case "cat":
			System.out
					.println("cat(path file : display the content of the file.");
			break;
		case "pwd":
			System.out.println("pwd() : it show you the current directory.");
			break;
		case "date":
			System.out.println("data() : display the current date.");
			break;
		case "args":
			System.out
					.println("args(command name) : it show you arguments of this command.");
			break;
		case "help":
			System.out
					.println("help() : it show you all commands and there arguments.");
			break;
		case "more":
			System.out.println("more() : it display the output in pages.");
			break;
		default:
			System.out.println("You have enterd an inexact command.");
			break;
		}
	}

	public void rmdir(String s1) {
		s1 = h + s1;
		File xx = new File(s1);
		try {
			if (xx.isFile() && FileUtils.readFileToString(xx).trim().isEmpty()) {
				xx.delete();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}