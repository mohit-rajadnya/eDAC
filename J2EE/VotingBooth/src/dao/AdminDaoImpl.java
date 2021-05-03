package dao;

import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Candidate;

public class AdminDaoImpl implements IAdminDao {
	
	Connection cn;
	PreparedStatement pst1,pst2;
	
	public AdminDaoImpl() throws SQLException, ClassNotFoundException
	{
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select * from candidates order by votes desc limit 2");
		pst2 = cn.prepareStatement("select * from candidates order by votes desc");
	}
	

	@Override
	public ArrayList<Candidate> topCandidates() throws SQLException{
		
		
		ArrayList<Candidate> c = new ArrayList<>();
		try(ResultSet rst = pst1.executeQuery())
		{
			while(rst.next())
				c.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			
				
		}
		
		return c;
	}

	@Override
	public ArrayList<Candidate> voteList()throws SQLException
	{
		ArrayList<Candidate> c = new ArrayList<>();
		try(ResultSet rst = pst2.executeQuery())
		{
			while(rst.next())
				c.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			
				
		}
		
		return c;
	}
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (cn != null)
			cn.close();
		if (pst2 != null)
			pst2.close();
		System.out.println("cust dao cleaned up...");
	
}


}
