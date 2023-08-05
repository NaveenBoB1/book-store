package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookCRUD;
@WebServlet("/author")
public class DeleteByAuthorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String author = req.getParameter("author");
		BookCRUD bc = new BookCRUD();
		int res =bc.deleteByBookauthor(author);
		if(res>0) {
			RequestDispatcher rd = req.getRequestDispatcher("view");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("Result.jsp");
			req.setAttribute("msg", "failed to delete book");
			rd.forward(req, resp);
			
		}
	}

}
