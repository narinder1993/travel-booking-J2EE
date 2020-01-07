

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class checkdestination
 */
@WebServlet("/checkdestination")
public class checkdestination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkdestination() {
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
		  String place=null;
		    String cost=null;
		   
			String s1=request.getParameter("imagevalue");
		out.print(s1);	
			
					
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				
				Statement st=con.createStatement();
				
				
				ResultSet rs=st.executeQuery("select * from destinationinfo where sn='"+s1+"'");
			   
				while(rs.next())
				{
				
					
					 place=rs.getString(2);
						cost=rs.getString(3);
					
				
			
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
