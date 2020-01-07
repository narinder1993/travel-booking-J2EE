

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Check
 */
@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		String u1=request.getParameter("username");
		String p1=request.getParameter("password");
		String t1=request.getParameter("type");
		HttpSession session=request.getSession();
		session.setAttribute("username", u1);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			
			Statement st=con.createStatement();
			
			
			ResultSet rs=st.executeQuery("Select * from signup where email='"+u1+"' and password= '"+p1+"'");
			
			if(t1.equals("Member"))
			{
			while(rs.next())
			{
			if(u1.equals(rs.getString("email"))&& p1.equals(rs.getString("password")))
			{
				response.sendRedirect("index.html");
		           rs.close();
		           
				
			}
			/*if(rs.next())
			{
				response.sendRedirect("welcome.html");
				
			}*/
			else{
				System.out.println("invalid input");
				
			}
			}
			
			}
			else if(t1.equals("Agent"))
			{
				ResultSet rs1=st.executeQuery("Select * from loginagent where name='"+u1+"' and password= '"+p1+"'");
				while(rs1.next())
				{
				if(u1.equals(rs1.getString("name"))&& p1.equals(rs1.getString("password")))
				{
					response.sendRedirect("index.html");
					
				}
				/*if(rs.next())
				{
					response.sendRedirect("welcome.html");
					
				}*/
				else{
					System.out.println("invalid input");
					
				}
				}
				
				
			}
		}
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		catch(SQLException e){
			System.out.println(e);
			
		}
		
	}

}
