package main;
import java.util.Scanner;
public class Input{
	
	private static Scanner in = new Scanner(System.in);
	public static String inputString(String prompt){
		System.out.print(prompt);
		String ret = "";
		ret = in.nextLine();
		return ret;
	}
	
	public static void close(){
		in.close();
	}
}