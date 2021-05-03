package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.VoterDaoImpl;
import pojos.Voters;

/**
 * Servlet implementation class StatusServlet
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<h5>You already have voted once!! Thank you!!</h5>");
		pw.print("<h5> <a href='check_out'>Check Out</a></h5>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter())
		{
			HttpSession hs = request.getSession();
			CandidateDaoImpl c = (CandidateDaoImpl)hs.getAttribute("candidate_dao");
			int val = Integer.parseInt(request.getParameter("choose"));
			c.incrementVotes(val);
			VoterDaoImpl voter = (VoterDaoImpl)hs.getAttribute("voter_dao");
			Voters v = (Voters)hs.getAttribute("voter_details");
			voter.updateVotingStatus(v.getId());
			pw.print("<h5> Your vote has been registered!! Thank you!!<h5>");
			pw.print("<h5> <a href='check_out'>Check Out</a></h5>");
			
		}catch (Exception e) {
			throw new ServletException("Error inside doGet" , e);
		}
	}

}
