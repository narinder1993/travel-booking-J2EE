

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
 * Servlet implementation class Rgstr
 */
@WebServlet("/Rgstr")
public class Rgstr extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Rgstr() {
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
		String u=request.getParameter("usernamesignup");
		String e=request.getParameter("emailsignup");
		String p=request.getParameter("passwordsignup");
		String pc=request.getParameter("passwordsignup_confirm");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			
			Statement st=con.createStatement();
			
			if(p.equals(pc)){
				
			
			int rs=st.executeUpdate("insert into signup values('"+u+"','"+e+"','"+p+"')");
			
			if(rs == 1)
			{
				System.out.println("inserted");
				response.sendRedirect("indexform.html#tologin");
				
			}
			
			/*ResultSet rs1= st.executeQuery("select * from std1");
			while(rs1.next())
			{
				System.out.println("\nname =\t "+rs1.getString(1)+"\nrollno. =\t "+rs1.getString(2)+"\nage =\t "+rs1.getString(3));
			}*/
			}
			else
				response.sendRedirect("indexform.html#toregister");

		}
		catch (ClassNotFoundException e1) {
			// TODO: handle exception
			System.out.println(e1);
		}
		
		catch(SQLException e1){
			System.out.println(e1);
			
		}
		
		
	}
	

}
