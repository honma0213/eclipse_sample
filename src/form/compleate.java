package form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import database.DataBase;
/**
 * Servlet implementation class compleate
 */
@WebServlet("/compleate")
@MultipartConfig(maxFileSize=1000000000)
public class compleate extends HttpServlet {
	  @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				request.setCharacterEncoding("UTF-8");
				String name = request.getParameter("name");
				String mail = request.getParameter("mail");
				String comment = request.getParameter("comment");

				request.setCharacterEncoding("UTF8");
		    	Part part = request.getPart("file");
		    	System.out.println(part);
		        String file = this.getFileName(part);
		        part.write("C:\\pleiades\\pleiades\\workspace\\Bulletin_Board\\WebContent\\upload\\" + file);


		        name = name.replace("<", "/");
				name =name.replace(">", "/");
				mail = mail.replace("<", "/");
				mail = mail.replace(">", "/");
				comment = comment.replace("<", "/");
				comment = comment.replace(">", "/");

				System.out.println(name);
				System.out.println(mail);
				System.out.println(comment);
				System.out.println(file);

				DataBase DB = new database.DataBase();
				String time = DataBase.insert(name,mail,comment,file);
			    response.sendRedirect("http://localhost:7093/Bulletin_Board/form");

	}
	 private String getFileName(Part part) {
	        String name = null;
	        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
	            if (dispotion.trim().startsWith("filename")) {
	                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
	                name = name.substring(name.lastIndexOf("\\") + 1);
	                break;
	            }
	        }
	        return name;
	    }

}
