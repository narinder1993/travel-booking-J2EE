<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <title>CSS Registration Form</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <link rel="stylesheet" type="text/css" href="css/default.css"/>
    </head>
    <body>   
    <!-- database code -->
     <%@page import="java.sql.*" %>
    <%@page import="java.io.*" %>
     <%@page import="javax.servlet.*" %>
    <%
   HttpSession sess = request.getSession();
	String value= (String)sess.getAttribute("username");

	
	 %>
	               <%
	               int totalcost=0;
	               int m;
	               int c;
    String tto=null;
    String cost=null;
    String name=null;
    String phone=null;
    String country=null;
    String dob =null;
    String members=null;
    String email1=value;
    
   
	String s1=request.getParameter("imagevalue");
	
	
			
	
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
		
		Statement st=con.createStatement();
		
		
		ResultSet rs=st.executeQuery("select * from customerinfo where email='"+email1+"'");
	   
		while(rs.next())
		{
		
			name=rs.getString(1);
			phone=rs.getString(2);
				country=rs.getString(4);
				dob=rs.getString(5);
			members=rs.getString(6);
			tto=rs.getString(7);
			cost=rs.getString(8);
			
			
		
	
		}
	  m=Integer.parseInt(members);
	     c=Integer.parseInt(cost);
	    totalcost=m*c;
	   
	}
	catch (ClassNotFoundException e) {
		// TODO: handle exception
		System.out.println(e);
	}
	
	catch(SQLException e){
		System.out.println(e);
		
	}
	
	
	
	
    
    
    
    
    
    
    %>
    
     <!-- database code ends here -->
     
     <!-- form starts here -->
        <form action="finalinfo.java" class="register">
            <h1>Final Information</h1>
            <fieldset class="row1">
                <legend>Account Details
                </legend>
                <p>
                    <label>Email *
                    </label>
                    <input type="text" value="<%=value %>"/>
                   
            
            </fieldset>
            <fieldset class="row2">
                <legend>Personal Details
                </legend>
                <p>
                    <label>Name *
                    </label>
                   <p><%=name %></p>
                </p>
                <p>
                    <label>Phone *
                    </label>
                     <p><%=phone %></p>
                </p>
              
                
                <p>
                    <label>Country *
                    </label>
                   <p> <p><%=country %></p>
                </p>
                
            </fieldset>
            <fieldset class="row3">
                <legend>Further Information
                </legend>
                
                <p>
                    <label>Birthdate *
                    </label>
                    
                    <p><%=dob %></p>
                </p>
                <p>
                    <label>Members going: 
                    </label>
                    <p><%=members %></p>
                </p>
                
      
    <p>
                    <label>Trip From: *</label>
                   <p><b>Delhi</b></p>
                </p>
                 <p>
                    <label>Trip to: *</label>
               <p> <b><%=tto%> </b></p>
                </p>
                
                <p>
                Total Cost:<b><%= totalcost %></b>
                            </p>
                            
                <div class="infobox"><h4>Helpful Information</h4>
                    <p>Here comes some explaining text, sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                </div>
            </fieldset>
            <fieldset class="row4">
                <legend>Terms and Mailing
                </legend>
                
            
            </fieldset>
            <div>
           <!--   <input type="submit" value="Register" class="button" />-->
           <!--   <button class="button">Register &raquo;</button>--></div>
        </form>
    </body>
</html>





