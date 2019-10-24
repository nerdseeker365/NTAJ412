//ConnTest.java

import java.sql.*;  //jdbc api

public class  ConnTest  
{
	public static void main(String[] args) throws Exception
	{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
			

        //establish the conenction with oracle DB s/w.
		   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		   if(con==null)
			    System.out.println("JDBC Connection is not established");
		   else
			    System.out.println("JDBC Connection is  established");

          System.out.println("jdbc con obj class name::"+con.getClass());
		  //create JDBC Statement object
		  Statement st=con.createStatement();
           System.out.println("jdbc statement obj class name::"+st.getClass());

 
	}//main
}//class
//>javac ConnTest.java
//>java  ConnTest
