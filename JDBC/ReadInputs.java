//ReadInputs.java

import java.io.*;
import java.util.*;

public class ReadInputs
{
	public static void main(String args[])throws Exception{
		//using Cmd line args
		String name1=args[0];
		//using user-defined System properties
		String  name2=System.getProperty("my.name");
		//Using Scanner
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name3:");
		String name3=sc.next();
		//Using BufferedReader 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name4:");
		String name4=br.readLine();
		//Using Console
		Console cons=System.console();
		System.out.println("Enter name5:");
		String name5=cons.readLine();

         //display all the names
		System.out.println(name1+"  "+name2+"   "+name3+"  "+name4+"  "+name5);
	}//main
}//class