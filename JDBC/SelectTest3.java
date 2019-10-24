//SelectTest3.java

import java.sql.*;
import java.util.*;

public  class SelectTest3   
{
	public  static void main(String args[])throws Exception{
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter dept no:");
		int no=sc.nextInt();
			//register JDBC driver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create JDBC Statement object
			Statement st=con.createStatement();
			//prepare SQL Query
			       //  SELECT * FROM DEPT WHERE DEPTNO=10
             String query="SELECT * FROM DEPT WHERE DEPTNO="+no;
			 System.out.println(query);
			//send and execute SQL Query in Db s/w
			ResultSet rs=st.executeQuery(query);
			//process the Resultset object
			if(rs.next()){
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));
			}
			else{
				System.out.println("record not found");
			}
			//close jdbc objs
			rs.close();
			st.close();
			con.close();
	}//main
}//class