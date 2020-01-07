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
	Object value= sess.getAttribute("username");

	
	 %>
    
     <!-- database code ends here -->
     
     
        <form action="destinfortrv" class="register">
            <h1>Registration</h1>
            <fieldset class="row1">
                <legend>Account Details
                </legend>
                <p>
                    <label>Email *
                    </label>
                    <input type="text" value="<%=value %>" name="email"/>
                   
            
            </fieldset>
            <fieldset class="row2">
                <legend>Personal Details
                </legend>
                <p>
                    <label>Name *
                    </label>
                    <input type="text" class="long" name="name"/>
                </p>
                <p>
                    <label>Phone *
                    </label>
                    <input type="text" maxlength="10" name="phone"/>
                </p>
              
                <p>
                    <label>City *
                    </label>
                    <input type="text" class="long" name="city"/>
                </p>
                <p>
                    <label>Country *
                    </label>
                    <select name="nationality">
                        <option>
                        </option>
                        <option value="India">India
                        </option>
                    </select>
                </p>
                 <p>
                    <label>Gender *</label>
                    <input type="radio" value="radio"/>
                    <label class="gender">Male</label>
                    <input type="radio" value="radio"/>
                    <label class="gender">Female</label>
                </p>
            </fieldset>
            <fieldset class="row3">
                <legend>Further Information
                </legend>
                
                <p>
                    <label>Birthdate *
                    </label>
                    
                   <input type="date" name="birthdate" />
                </p>
                <p>
                    <label>Members going: 
                    </label>
                   <input type="text" name="members"/>
                </p>
                 <p>
                    <label>Adults *
                    </label>
                    <input type="text" name="adults" />
                </p>
                <p>
                    <label>Children *
                    </label>
                    <input type="text" name="children" />
                </p>
                    <%
   
    String place=null;
    String cost=null;
   
   
   
	String s1=request.getParameter("imagevalue");
	
	
			
	
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
	
	
	
	
    
    
    
    
    
    
    %>
    <p>
                    <label>Trip From: *</label>
                   <input type="text" name="from" value="Delhi"/>
                </p>
                 <p>
                    <label>Trip to: *</label>
                <input type="text" name="tto" value="<%=place %>"/>
                </p>
                
                <p>
                Cost per menmber: <input type="text" name="cost" value="<%=cost %>"/>
                            </p>
                            
                <div class="infobox"><h4>Helpful Information</h4>
                    <p>Here comes some explaining text, sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                </div>
            </fieldset>
            <fieldset class="row4">
                <legend>Terms and Mailing
                </legend>
                <p class="agreement">
                    <input type="checkbox" value=""/>
                    <label>*  I accept the <a href="#">Terms and Conditions</a></label>
                </p>
            
            </fieldset>
            <div>
            <input type="submit" value="Register" class="button" />
           <!--   <button class="button">Register &raquo;</button>--></div>
        </form>
    </body>
</html>





