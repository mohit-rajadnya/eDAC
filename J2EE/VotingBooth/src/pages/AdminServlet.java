package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDaoImpl;
import pojos.Candidate;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter())
		{
			HttpSession hs = request.getSession();
			AdminDaoImpl a = (AdminDaoImpl)hs.getAttribute("admin_dao");
			pw.write("Top two candidates: ");
			ArrayList<Candidate> cList = a.topCandidates(); 
			for(Candidate c : cList)
				pw.write("<h5>" + c + "</h5>");
			pw.println();
			pw.println();
			
			ArrayList<Candidate> cList1 = a.voteList();
			for(Candidate c : cList1)
				pw.write("<h5>" + c.getName() + " - " + c.getParty() + " - " + c.getVotes() + "</h5>");
			pw.print("<h5> <a href='check_out'>Check Out</a></h5>");
			
		}catch (Exception e) {
			throw new ServletException("Error in admin doGet",e);
		}
		
	}

}
