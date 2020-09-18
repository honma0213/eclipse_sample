package form;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataBase;
import database.data;

/**
 * Servlet implementation class update_result
 */
@WebServlet("/update_result")
public class update_result extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("id");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String comment = request.getParameter("comment");

		name = name.replace("<", "/");
		name =name.replace(">", "/");
		mail = mail.replace("<", "/");
		mail = mail.replace(">", "/");
		comment = comment.replace("<", "/");
		comment = comment.replace(">", "/");

		System.out.println(name);
		System.out.println(mail);
		System.out.println(comment);


		LocalDateTime date1 = LocalDateTime.now();
		DateTimeFormatter dtformat1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS E");
		String fdate1 = dtformat1.format(date1);

		String sql = null;

		if( name == "" && mail == ""){
			 sql = "UPDATE snsdata SET comment = '"+comment+"',updatetime = '"+fdate1+"' WHERE id = '"+Integer.parseInt(num)+"';";
		}else if(name == "" && comment == ""){
			 sql = "UPDATE snsdata SET mail = '"+mail+"',updatetime = '"+fdate1+"' WHERE id = '"+Integer.parseInt(num)+"';";
		}else if(comment == "" && mail == ""){
			 sql = "UPDATE snsdata SET name = '"+name+"',updatetime = '"+fdate1+"' WHERE id = '"+Integer.parseInt(num)+"';";
		}else if(name == ""){
			 sql = "UPDATE snsdata SET mail = '"+mail+"',comment = '"+comment+"',updatetime = '"+fdate1+"' WHERE id = '"+Integer.parseInt(num)+"';";
		}else if(mail == ""){
			 sql = "UPDATE snsdata SET name = '"+name+"',comment = '"+comment+"',updatetime = '"+fdate1+"' WHERE id = '"+Integer.parseInt(num)+"';";
		}else if(comment == ""){
			 sql = "UPDATE snsdata SET name = '"+name+"',mail = '"+mail+"',updatetime = '"+fdate1+"' WHERE id = '"+Integer.parseInt(num)+"';";
		}else{
			 sql = "UPDATE snsdata SET name = '"+name+"',mail = '"+mail+"',comment = '"+comment+"',updatetime = '"+fdate1+"' WHERE id = '"+Integer.parseInt(num)+"';";
		}
		DataBase.change(sql);

		DataBase db = new database.DataBase();
		ArrayList<data> data = db.select();
		request.setAttribute("list", data);

		String view = "/WEB-INF/view/select.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
