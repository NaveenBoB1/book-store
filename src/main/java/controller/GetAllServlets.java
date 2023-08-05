package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookCRUD;
import dto.book;
@WebServlet("/view")
public class GetAllServlets extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookCRUD bc = new BookCRUD();
		ArrayList<book> al = bc.getAllBook();
		if(al.size()>0) {
			RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
			req.setAttribute("data", al);
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("Result.jsp");
			req.setAttribute("msg","No Books available");
			rd.forward(req, resp);
		}
	}

}
