package dao;

import java.sql.SQLException;

import pojos.Voters;

public interface IVoterDao {
	
	Voters validateVoter(String email , String password) throws SQLException;
	String updateVotingStatus(int id) throws SQLException;
	
}
