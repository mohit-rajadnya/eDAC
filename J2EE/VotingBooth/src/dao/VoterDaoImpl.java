package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static utils.DBUtils.fetchConnection;

import pojos.Voters;

public class VoterDaoImpl implements IVoterDao {
	
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	
	public VoterDaoImpl() throws SQLException , ClassNotFoundException
	{
		String sql1 = "Select * from voters where email = ? and password = ?";
		String sql2 = "Update voters set status = 1 where id = ?";
		cn = fetchConnection();
		pst1 = cn.prepareStatement(sql1);
		pst2 = cn.prepareStatement(sql2);
	}

	@Override
	public Voters validateVoter(String email, String password) throws SQLException {
		
		Voters voter = null;
		pst1.setString(1, email);
		pst1.setString(2, password);
		
		try(ResultSet rst = pst1.executeQuery())
		{
			if(rst.next());
			voter = new Voters(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getBoolean(5), rst.getString(6));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return voter;
	}

	@Override
	public String updateVotingStatus(int id)throws SQLException {
		
		pst2.setInt(1, id);
		int val = pst2.executeUpdate();
		if(val>0)
			return "Successfully registered your vote!!";
		else		
			return "Failed to register your vote!!";
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
