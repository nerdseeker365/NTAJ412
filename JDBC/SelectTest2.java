//SelectTest2.java

import java.sql.*;
import java.util.*;

public  class SelectTest2    //boiler plate code
{
	public  static void main(String args[])throws Exception{
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Desg:");
		String desg=sc.next().toUpperCase();  // CLERK
		//convert input value as required for the SQL Query
		desg="'"+desg+"'";  //gives  'CLERK'
		    //desg='\''+desg+'\'';  //gives 'CLERK'
			//register JDBC driver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create JDBC Statement object
			Statement st=con.createStatement();
			//prepare SQL Query
			       //  select empno,ename,job,sal from emp where job='CLERK' order by ENAME desc
             String query="SELECT SAL,EMPNO,ENAME,JOB FROM EMP WHERE JOB="+desg+" ORDER BY ENAME DESC";
			 System.out.println(query);
			//send and execute SQL Query in Db s/w
			ResultSet rs=st.executeQuery(query);
			//process the Resultset object
			boolean flag=false;
			while(rs.next()){
				flag=true;
				//System.out.println(rs.getFloat(1)+"  "+rs.getInt(2)+" "+rs.getString(3)+"  "+rs.getString(4));
				//System.out.println(rs.getFloat("SAL")+"  "+rs.getInt("EMPNO")+" "+rs.getString("ENAME")+"  "+rs.getString("JOB"));
				System.out.println(rs.getFloat("SAL")+"  "+rs.getInt("EMPNO")+" "+rs.getString("JOB")+"  "+rs.getString("ENAME"));
			}
			if(flag)
				System.out.println("records found and displayed");
			else
				System.out.println("records not displayed");
			//close jdbc objs
			rs.close();
			st.close();
			con.close();
	}//main
}//class