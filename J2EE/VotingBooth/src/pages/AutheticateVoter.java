package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDaoImpl;
import dao.CandidateDaoImpl;
import dao.VoterDaoImpl;
import pojos.Voters;

/**
 * Servlet implementation class AutheticateVoter
 */
@WebServlet("/validate")
public class AutheticateVoter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoterDaoImpl voterDao;
	private CandidateDaoImpl candidateDao;
	private AdminDaoImpl adminDao;
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Inside init of authenticate");
		try {
			voterDao = new VoterDaoImpl();
			candidateDao = new CandidateDaoImpl();
			adminDao = new AdminDaoImpl();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Error Inside init " + getClass().getName(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy()  {
		System.out.println("Inside destroy of authenticate");
		
			try {
				voterDao.cleanUp();
				candidateDao.cleanUp();
				adminDao.cleanUp();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter())
		{
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			System.out.println("in doPost " + email + " " + password);
			
			Voters voter = voterDao.validateVoter(email, password);
			if(voter==null)
			{				
				pw.print("<h5>Invalid Login , Please <a href='login.html'>Retry</a></h5>");
			}
			else 
			{
				HttpSession hs = request.getSession();
				hs.setAttribute("voter_details", voter);
				hs.setAttribute("voter_dao", voterDao);				
				hs.setAttribute("candidate_dao", candidateDao);
				hs.setAttribute("admin_dao", adminDao);
				if(voter.getRole().equals("admin"))
				{
					response.sendRedirect("admin");
				}
				else if(voter.isStatus())
				{
					response.sendRedirect("status");
				}
				else
				{
					response.sendRedirect("candidate_list");
				}
			}
			
		}catch (Exception e) {
			throw new ServletException("Error in doPost login page " + getClass().getName(), e);
		}
		
	}

}













