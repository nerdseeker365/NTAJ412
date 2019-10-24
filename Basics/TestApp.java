//TestApp.java
import java.util.*;
class Test
{
	static{
		System.out.println("Test:static block");
	}
	public Test(){
		System.out.println("Test:0-param constructor");
	}
}//class

class Demo
{
    static{
		  System.out.println("Demo: static block");
	}
	public  Demo(){
		 System.out.println("Demo:0-param construtor");
	}
	public static  void m1(){
		System.out.println("Demo:static m1() method");
	}
}//class

public class TestApp
{
	static{
		System.out.println("TestApp:static block");
    }
	public  TestApp(){
		System.out.println("TestApp:0-param constructor");
	}
	public  static void main(String args[])throws ClassNotFoundException{
           System.out.println("TestApp: start of main(-) method");
		      Demo.m1();
		     Demo d1=new Demo();
			 Demo d2=new Demo();
		

			 Class.forName("Test");
			 Class.forName("Test");
			 Class.forName("Demo");
			 	 System.out.println("TestApp: end of main(-) method");

				 Date d=null;
				 d=new Date();
				 System.out.println("current month::"+d.getMonth());
	}//main
}//class

//>javac  TestApp.java
//>java  TestApp  
