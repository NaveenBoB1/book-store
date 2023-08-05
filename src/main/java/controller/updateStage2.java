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
@WebServlet("/update")
public class updateStage2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		book b = new book();
		int id =Integer.parseInt(req.getParameter("id"));
		b.setId(id);
		String name =req.getParameter("name");
		b.setName(name);
		String s= req.getParameter("author");
		b.setAuthor(s);
		int price = Integer.parseInt(req.getParameter("price"));
		b.setPrice(price);
		int totalpages = Integer.parseInt(req.getParameter("totalpages"));
		b.setTotalpages(totalpages);
		
		
		 BookCRUD bc = new BookCRUD();
		 int res=bc.updatebook(id, b);
		 if(res>0) {
			 RequestDispatcher rd = req.getRequestDispatcher("view");
			 rd.forward(req, resp);
		 }else {
			 RequestDispatcher rd = req.getRequestDispatcher("Result.jsp");
			 req.setAttribute("msg", "failed to update");
			 rd.forward(req, resp);
		 }
		
		
	}

}
