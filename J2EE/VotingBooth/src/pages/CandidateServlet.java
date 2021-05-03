package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import pojos.Candidate;

/**
 * Servlet implementation class CandidateServlet
 */
@WebServlet("/candidate_list")
public class CandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter())
		{
			HttpSession hs = request.getSession();
			CandidateDaoImpl candidate = (CandidateDaoImpl)hs.getAttribute("candidate_dao");
				List<Candidate> candidateList = candidate.listCandidates();
				
				pw.print("<form action='status' method='post'>");
				pw.print("<h3>Candidate list: </h3>");
				pw.print("<select name='choose'>");
				for (Candidate c : candidateList)
					pw.print("<option value=" + c.getId() + ">" + c + "</option>");
				pw.print("</select><br>");
				pw.print("<input type='submit' value='Vote'>");
				pw.print("</form>");
				
		}catch (Exception e) {
			throw new ServletException("Error in doGet of candidate list" , e );
		}
	}

}








