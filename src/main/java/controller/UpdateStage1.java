package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookCRUD;
import dto.book;
@WebServlet("/edit")
public class UpdateStage1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("id"));
		BookCRUD bc = new BookCRUD();
		book b = bc.GetbyID(id);
		if(b!=null) {
			RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
			req.setAttribute("bro", b);
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("Result.jsp");
			req.setAttribute("msg", "No book available");
			rd.forward(req, resp);
		}
	}
	

}
