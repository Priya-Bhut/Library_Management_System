//JAVA PROJECT

//LIBRARY MANAGEMENT SYSTEM PROJECT (CONSOLE APPLICATION)



import java.util.*;
import java.io.*;
import java.sql.*;
public class project
{
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	   char r;
	   do
	   {
		   System.out.println("********************Library Management System********************");
		   System.out.println("\n");
		   System.out.println("Press:- 1 for Add Book");
		   System.out.println("Press:- 2 for Issue a Book");
		   System.out.println("Press:- 3 for Return a Book");
		   System.out.println("Press:- 4 for Display issue book details");
		   System.out.println("Press:- 5 for Display All book details");
		   System.out.println("Press:- 6 for Delete a book");
		   System.out.println("Press:- 7 for To Stop Application... ");
		   Scanner obj=new Scanner(System.in);
		   System.out.println("\n");
		   System.out.println("**************Please Choice Any Option*****************");
		   int a=obj.nextInt();
		   obj.nextLine();
		   switch(a) 
		   {
		   		case 1:
		   				library aa=new library();
		   				aa.add();
		   				break;
	    	
		   		case 2:
		   				library bb=new library();
		   				bb.issue();
		   				break;
		   		case 3:
		   				library cc=new library();
		   				cc.returnbook();
		   				break;
		   		case 4:
		   				library dd=new library();
		   				dd.issue_detail();
		   				break;
				case 5:
						library ee=new library();
						ee.book_all();
						break;
				case 6:
						library ff=new library();
						ff.delete_book();
						break;
		   	
		   		case 7:
		   				library ex=new library();
		   				ex.exit();
		   				break;
		   		default:
		   				System.out.println("Oops, Your Entered Number is Invalid");
	             }
	    System.out.println("You Want to select Next option Y/N");
	    r=obj.next().charAt(0);
	   }
	    while(r=='y'|| r=='Y');
	    if(r=='n'|| r=='N')
	    {
	    	library z=new library();
	    	z.exit();
	    }
	   }
}
class library
{
	static String str,c,book_author,sn,bn,idate,rdate;
	static int o,b,sr,bi,sr2,bi2,bi3,temp;
	void add()
	{
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter Book Name:-->");
		String str=obj.nextLine();
		System.out.println("Enter Book Author Name:-->");
		String stra=obj.nextLine();
		System.out.println("Enter Book Price:-->");
		float price=obj.nextFloat();
					
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/library_management", "root","");
		Statement s=cn.createStatement();
		s.execute("insert into book_add (book_name,book_author,book_price) values('"+str+"','"+stra+"','"+price+"')");
		System.out.println("Record inserted Successfully.");
	}
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
	void issue()
	{
		Scanner obj2=new Scanner(System.in);
		System.out.println("Student RollNo");
		sr=obj2.nextInt();
		obj2.nextLine();
		System.out.println("Student Name");
		sn=obj2.nextLine();
		System.out.println("Book Id");
		bi=obj2.nextInt();
		obj2.nextLine();
		System.out.println("Book Name");
		bn=obj2.nextLine();
		System.out.println("Issue Date::(format:yyyy-mm-dd)");
		idate=obj2.nextLine();
		System.out.println("Return Book date::(format:yyyy-mm-dd)");
		rdate=obj2.nextLine();
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/library_management", "root","");
		Statement s=cn.createStatement();
		s.execute("insert into book_issue(student_id,student_name,book_id,book_name,issue_date,return_book_date)values('"+sr+"','"+sn+"','"+bi+"','"+bn+"','"+idate+"','"+rdate+"')");
		System.out.println("Record inserted Successfully.");
	}
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	int getbookid() 
	{
		return 0;
	}
	/*--------------------------------------------------------------------------------*/
	void returnbook()
	{
		Scanner obj3=new Scanner(System.in);
		System.out.println("Student RollNo");
		sr2=obj3.nextInt();
		System.out.println("Book Id");
		bi2=obj3.nextInt();
		obj3.nextLine();
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/library_management", "root","");
		Statement s=cn.createStatement();
		String sql=("SELECT * FROM book_issue WHERE student_id='"+sr2+"' AND book_id='"+bi2+"'"); 
		
		ResultSet rs=s.executeQuery(sql);
		if(rs.next())
		{ 
            //Retrieve by column name
         String sr = rs.getString("student_id");
         String sn = rs.getString("student_name");
		 String bi = rs.getString("book_id");
		 String bn = rs.getString("book_name");
		 String idate = rs.getString("issue_date");
		 String rdate = rs.getString("return_book_date");

         //Display values
         
         System.out.println("Student id:" + sr);
         System.out.println("Student name:" + sn);
         System.out.println("Book_id: " + bi);
		 System.out.println("Book_name: " + bn);
		 System.out.println("Book_Issue_date: " + idate);
		 System.out.println("Book_return_date: " + rdate);
		 System.out.println("******************************************");

		 
		}
		else{
			System.out.println("no user...");
		}
		
	}
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
	void book_all()
	{
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/library_management", "root","");
		Statement s=cn.createStatement();
		String sql=("select * from  book_add");
		ResultSet rs=s.executeQuery(sql);
		System.out.println("Avilable All books details....");
		System.out.println("\n \n");
	while(rs.next()){
         //Retrieve by column name
         
         String str = rs.getString("book_name");
         String stra = rs.getString("book_author");
		 String price = rs.getString("book_price");

         //Display values
         
         System.out.println("Book Name:" + str);
         System.out.println("Book Author:" + stra);
         System.out.println("Book Price: " + price);
		 System.out.println("******************************************");
      }
      rs.close();
		
	}
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	void issue_detail()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/library_management", "root","");
		Statement s=cn.createStatement();
		String sql=("select * from  book_issue");
		ResultSet rs=s.executeQuery(sql);
		System.out.println("Details of all issue_book...");
		System.out.println("\n \n");
		
	while(rs.next()){
         //Retrieve by column name
         
         String sr = rs.getString("student_id");
         String sn = rs.getString("student_name");
		 String bi = rs.getString("book_id");
		 String bn = rs.getString("book_name");
		 String idate = rs.getString("issue_date");
		 String rdate = rs.getString("return_book_date");

         //Display values
         
         System.out.println("Student id:" + sr);
         System.out.println("Student name:" + sn);
         System.out.println("Book_id: " + bi);
		 System.out.println("Book_name: " + bn);
		 System.out.println("Book_Issue_date: " + idate);
		 System.out.println("Book_return_date: " + rdate);
		 System.out.println("******************************************");
      }
      rs.close();
		
	}
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	/*-----------------------------------------------------------------------------*/
	
	void delete_book()
	{
		System.out.println("\n Enter the Book id which you want to delete::");
		Scanner obj4=new Scanner(System.in);
		System.out.println("Book Id");
		bi3=obj4.nextInt();
		
	
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/library_management", "root","");
		Statement s=cn.createStatement();
		
		s.executeUpdate("delete from book_add where book_id="+bi3+"");
		
            System.out.println("Record deleted Successfully...");
	}
	
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
	void exit()
	{
		System.exit(0);
	}
}






