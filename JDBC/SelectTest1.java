//SelectTest1.java

import java.sql.*;
import java.util.*;
public  class SelectTest1
{
	public static void  main(String args[])throws Exception{
	    
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Start range of student number::");
		int start=sc.nextInt();  //gives 1000
		System.out.println("Enter end range of student number::");
		int end=sc.nextInt();  //gives 2000

		//register JDBC driver s/w 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		//create Statement object
		Statement st=con.createStatement();
		//prepare SQL Query
		       //select * from student where sno>=1000 and sno<=2000
		String query="SELECT * FROM STUDENT WHERE SNO>="+start+" AND SNO<="+end;
		System.out.println(query);
		//send  and execute SQL Query to DB s/w
		ResultSet rs=st.executeQuery(query);
		//process the ResultSet object
		boolean flag=false;
		while(rs.next()){
			flag=true;
			 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
		}

		if(flag)
			 System.out.println("Records  found and displayed");
		else
			System.out.println("Records not found");



		//close jdbc objs
		rs.close();
		st.close();
		con.close();
	}//main
}//class