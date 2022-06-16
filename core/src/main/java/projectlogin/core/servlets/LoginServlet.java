package projectlogin.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Login Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
        "sling.servlet.paths="+ "/bin/user/login"
})
public class LoginServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUid = 1L;
	@Override
	protected void doPost(SlingHttpServletRequest request,SlingHttpServletResponse response) throws ServletException,IOException {  
		java.util.logging.Logger.getLogger(getServletName()+"LoginServlet");

		String fname;
		String password;
	    String osgiService="";
		 try {
		    	fname = request.getParameter("fname");
				password = request.getParameter("password");

				boolean isValid= fname.equals("Abhishek")&&password.equals("123");
				
		    	JSONObject obj=new JSONObject();
		        obj.put("status",isValid);
		        
		    	String jsonData = obj.toString();
		    	response.setCharacterEncoding("UTF-8");
		    	response.setContentType("application/json");
		    	
		    	response.getWriter().write(jsonData);
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		    }         
	}
}
