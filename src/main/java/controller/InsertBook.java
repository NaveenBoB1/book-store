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
@WebServlet("/addbook")
public class InsertBook extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		int price = Integer.parseInt(req.getParameter("price"));
		int totalpages = Integer.parseInt(req.getParameter("totalpages"));
		
		book b = new book(id, name, author, price, totalpages);
		
		int res = BookCRUD.insertbook(b);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("Result.jsp");
		if(res>0) {
			req.setAttribute("msg", "inserted successfully");
			rd.forward(req, resp);
		}else {
			req.setAttribute("msg", "inserted failed");
			rd.forward(req, resp);
		}
	}
}
