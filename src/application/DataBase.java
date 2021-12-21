package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

	private Connection con;
	public void CreateConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("\nDriver Loaded Successfully!");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicvotingmachine","root","tiger1234"); 
			System.out.println("Connection Established!");			
			//con.close();	
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public boolean RetreiveAdminCredentials(Admin adminobj, String x, String y) throws SQLException
	{
		System.out.println("DB here !!!");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from admin");
		
		while(rs.next())
		{
			adminobj.setAdminID(rs.getInt(1));
			adminobj.setAdminNIC(rs.getInt(2));
			adminobj.setAdminName(rs.getString(3));
			adminobj.setDOB(rs.getString(4));
			adminobj.setAddress(rs.getString(5));
			adminobj.setUserName(rs.getString(6));
			adminobj.setPassword(rs.getString(7));
			
			System.out.println(rs.getInt(1) + "  " + rs.getInt(2));
		}
		if (adminobj.ValidateAdmin(x, y))
		{
			return true; 
		}
		else
			return false;
	}
	
	public boolean InsertParty(int pid, String pn, String pp, String tm, int tv) throws SQLException
	{
		Statement stmt2 = con.createStatement();
		ResultSet rs2 = stmt2.executeQuery("select count(ALL Party_ID) from Party");
		while(rs2.next())
		{
			pid = rs2.getInt(1);
		}
		
		System.out.println("Count : " + pid);
		pid = pid+1;
		
		String sql = "INSERT into Party (Party_ID,Party_Name,Party_President,Total_Members,Total_Votes) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setInt(1,pid);
		statement.setString(2,pn);
		statement.setString(3,pp);
		statement.setString(4,tm);
		statement.setInt(5,tv);
		
		int rowsInserted = statement.executeUpdate();
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Party");
		
		while (rs.next())
		{
			System.out.println("\n" + rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getInt(4) + "  " + rs.getInt(5));
		}
		
		con.close();
		
		if (rowsInserted > 0)
		{
			System.out.println("\nParty Inserted Successfully !!!");
			return true;
		}
		else
			return false;
	}

	public boolean InsertCandidate(String cn, String e, String a, String fn, String n, String pid) throws SQLException {

		Statement stmt2 = con.createStatement();
		ResultSet rs2 = stmt2.executeQuery("select count(ALL Candidate_ID) from Candidate");
		int c = 0;
		while(rs2.next())
		{
			c = rs2.getInt(1);
		}
		
		System.out.println("Count : " + c);
		c = c+1;
		
		String sql = "INSERT into Candidate (Candidate_ID,Candidate_Name,C_Education,Candidate_Age,C_FatherName,Nationality,Party_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setInt(1,c);
		statement.setString(2,cn);
		statement.setString(3,e);
		statement.setString(4,a);
		statement.setString(5,fn);
		statement.setString(6,n);
		statement.setString(7,pid);
		
		int rowsInserted = statement.executeUpdate();
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Candidate");
		
		while (rs.next())
		{
			System.out.println("\n" + rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getInt(4) + "  " + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getInt(7));
		}
		
		con.close();
		
		if (rowsInserted > 0)
		{
			System.out.println("\nCandidate Inserted Successfully !!!");
			return true;
		}
		else
			return false;
	}
	
	public boolean InsertVoter(String vn, String a, String cnic, String p, String n) throws SQLException {

		Statement stmt2 = con.createStatement();
		ResultSet rs2 = stmt2.executeQuery("select count(ALL Voter_ID) from Voter");
		int c = 0;
		while(rs2.next())
		{
			c = rs2.getInt(1);
		}
		
		System.out.println("Count : " + c);
		c = c+1;
		
		String sql = "INSERT into Voter (Voter_ID,Voter_Name,Voter_Age,Voter_CNIC,Voter_Party,Voter_Nationality) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setInt(1,c);
		statement.setString(2,vn);
		statement.setString(3,a);
		statement.setString(4,cnic);
		statement.setString(5,p);
		statement.setString(6,n);
		
		int rowsInserted = statement.executeUpdate();
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Voter");
		
		while (rs.next())
		{
			System.out.println("\n" + rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
		}
		
		String sql2 = "UPDATE Party SET Total_Votes = Total_Votes + 1 WHERE Party_Name = ?";
		PreparedStatement st = con.prepareStatement(sql2);
		st.setString(1,p);
		
		con.close();
		
		if (rowsInserted > 0)
		{
			System.out.println("\nVoter Inserted Successfully !!!");
			return true;
		}
		else
			return false;
	}
}
