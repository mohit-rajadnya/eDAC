package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;
import static utils.DBUtils.fetchConnection;


public class CandidateDaoImpl implements ICanditateDao {
	private Connection cn;
	private PreparedStatement pst1 , pst2;
	
	public CandidateDaoImpl() throws SQLException,ClassNotFoundException {
		
		String sql1 = "Select * from Candidates";
		String sql2 = "Update candidates set votes = (votes + 1) where id = ?";
		cn = fetchConnection();
		pst1 = cn.prepareStatement(sql1);
		pst2 = cn.prepareStatement(sql2);
		
	}

	@Override
	public List<Candidate> listCandidates() throws SQLException {
		
		List<Candidate> c = new ArrayList<Candidate>();
		
		try(ResultSet rst = pst1.executeQuery())
		{
			while(rst.next())
				c.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public String incrementVotes(int id) throws SQLException {
		
		pst2.setInt(1, id);
		int val = pst2.executeUpdate();
		
		if(val>0)
			return "Vote added";
		else
			return "Failed to add a vote";
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
