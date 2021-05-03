package dao;
import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;

public interface ICanditateDao {
	
	List<Candidate> listCandidates()throws SQLException;
	String incrementVotes(int id) throws SQLException;

}
