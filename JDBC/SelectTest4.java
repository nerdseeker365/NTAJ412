//SelectTest4.java
package com.nt.jdbc;
  /* App  to get Emp details based on the given 3 desgs  
    version:  1.0
	author :Team-J
  */
 import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectTest4
{
    public  static void main(String args[]) {
		Scanner sc=null;
		String desg1=null,desg2=null,desg3=null;
		String cond=null;
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		boolean flag=false;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter Desg1");
				desg1=sc.next().toUpperCase();   //CLERK
				System.out.println("Enter Desg2"); 
				desg2=sc.next().toUpperCase(); // MANAGER
				System.out.println("Enter Desg3");  
				desg3=sc.next().toUpperCase();//SALESMAN
			}
			//convert  input values as required for the SQL Query  ('CLERK','MANAGER','SALESMAN')
              cond="('"+desg1+"','"+desg2+"','"+desg3+"')";
			  System.out.println(cond);
			  //register JDBC Driver 
			  Class.forName("oracle.jdbc.driver.OracleDriver1");
			  //establish  the connection
			  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			  //create Statement object
			  if(con!=null)
                st=con.createStatement();
			  //prepare SQL Query
			          // select empno,ename,job,sal from emp where job in('CLERK','MANAGER','SALESMAN') order by job
                     query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN "+cond+" ORDER BY JOB";
					 System.out.println(query);
             //send and execute SQL Query in DB s/w
			 if(st!=null)
				   rs=st.executeQuery(query);
			 //gather  and process results..
			 if(rs!=null){
                 while(rs.next()){
					  flag=true;
                      System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
				 }
			 }
			 if(flag==false)
				    System.out.println("records not found");
		}//try
		catch(SQLException se){   // known Exception
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){  //known exception
			System.out.println(cnf.toString());
		}
		catch(Exception e){   //unknown exception
			e.printStackTrace();
		}
		finally{
			//close jdbc objs
			try{
				if(rs!=null)
                      rs.close();
			}
			catch(SQLException se){
				 se.printStackTrace();
			}
			try{
				if(st!=null)
                      st.close();
			}
			catch(SQLException se){
				 se.printStackTrace();
			}
			try{
				if(con!=null)
                      con.close();
			}
			catch(SQLException se){
				 se.printStackTrace();
			}

				try{
				if(sc!=null)
                      sc.close();
			}
			catch(Exception e){
				 e.printStackTrace();
			}

		}//finally
	}//main
}//class