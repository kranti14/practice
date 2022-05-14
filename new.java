import java.io.*;
import java.lang.*;
import java.sql.*;

class xyz
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	String sql;

	public xyz()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://tybcadb.accdb");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void display()
	{
		try
		{
			sql = "Select * from tybcatable";
			stmt = con.createStatement();
		    rs = stmt.executeQuery(sql);

		    if(rs.next())
		    {
				System.out.println("\n ROLLNO: \t NAME: \t MARKS:");

				do
				{
					System.out.println("t"+rs.getInt("rollno")+"t"+rs.getString("name")+"t"+rs.getInt("marks"));

				}while(rs.next());
			}
			else
			{
				System.out.println("NO DATA FOUND");
			}
		}

		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}
class jdbc43
{
	public static void main(String args[])
	{
		xyz x=new xyz();
		x.display();
	}
}