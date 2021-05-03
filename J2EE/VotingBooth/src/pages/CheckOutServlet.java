package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Voters;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/check_out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		try(PrintWriter pw=response.getWriter())
		{
	 
			HttpSession hs=request.getSession();
			
			Voters voter = (Voters)hs.getAttribute("voter");
			if(voter!=null)
			{
				pw.print("<h5> Details:  " + voter +"</h5>");
			}
			
			
			hs.invalidate();
			pw.print("<h5> You have logged out....</h5>");
			//add visit again link
			pw.print("<h5> <a href='login.html'>Visit Again</a></h5>");
		}
	}

}
