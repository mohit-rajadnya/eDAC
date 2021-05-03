package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Candidate;

public interface IAdminDao {
	
	ArrayList<Candidate> topCandidates() throws SQLException;
	ArrayList<Candidate> voteList() throws SQLException;

}
