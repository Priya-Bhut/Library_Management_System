//FIRST OF ALL THIS PROJECT IS CONNECTED TO THE MYSQL DATABASE.
//INSTALL THE JDBC DRIVER.

/*  
     	Steps to run JDBC java program from cmd.

	( 1 )  Put mysql.jar file where java file is there.
	( 2 )  Go to the path using cd command where java file is there. Ex (c:\>cd c:users\chirag\desktop OR cd..).
	( 3 )  Compile the class file .Ex(javac JdbcDemo.java).
	( 4 )  Run the java file using which contains main method using the following command.
	( 5 )  java -cp "mysql.jar;" JdbcDemo (Here JdbcDemo is class name).
*/
import java.sql.*;
public class create_table
{

            public static void main(String[] args)
           {
			   
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/library_management", "root","");
		Statement s=cn.createStatement();
		//s.execute("create table book_add(book_id int primary key auto_increment,book_name varchar(50),book_author varchar(50),book_price int (10))");
s.execute("create table book_issue(student_id int(5),student_name varchar(50),book_id int(10),book_name varchar(50),issue_date date,return_book_date date)");
		//s.execute("create table book_return(student_id int,student_name varchar(50),book_id int(10))");
		System.out.println("Table Created Successfully.");
	} 
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}







