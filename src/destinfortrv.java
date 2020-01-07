

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/destinfortrv")
public class destinfortrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public destinfortrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		String name= request.getParameter("name");
		String phone= request.getParameter("phone");
		String street1= request.getParameter("street1");
		String city= request.getParameter("city");
		String country1= request.getParameter("country1");
		String website1= request.getParameter("website1");
		String gender= request.getParameter("gender");
		String day= request.getParameter("day");
		String month= request.getParameter("month");
		String year= request.getParameter("year");
		String nationality= request.getParameter("nationality");
		String birthdate= request.getParameter("birthdate");
		String destination1=request.getParameter("tto");
		String members=request.getParameter("members");
		String cost=request.getParameter("cost");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			Statement st=con.createStatement();
			int s=st.executeUpdate("insert into customerinfo values('"+name+"','"+phone+"','"+city+"','"+nationality+"','"+birthdate+"','"+members+"','"+destination1+"','"+cost+"','"+email+"');");
			if(s==1){System.out.println("Record Inserted");		
			request.getRequestDispatcher("finalinfo.jsp").forward(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
