package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import dto.book;

public class BookCRUD {

	public static final String URL = "jdbc:mysql://localhost:3306/book_store";
	public static final String USER = "root";
	public static final String PSWD = "karthik";
	public static final String PATH = "com.mysql.cj.jdbc.Driver";

	public static int insertbook(book b) {
		String query = "insert into book values(?,?,?,?,?)";
		Connection con = null;

		try {
			Class.forName(PATH);
			con = DriverManager.getConnection(URL, USER, PSWD);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, b.getId());
			ps.setString(2, b.getName());
			ps.setString(3, b.getAuthor());
			ps.setInt(4, b.getPrice());
			ps.setInt(5, b.getTotalpages());

			return ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	
	public ArrayList<book> getAllBook(){
		ArrayList<book> al = new ArrayList<book>();
		String query = "select * from book";
		Connection con = null;
		try {
			Class.forName(PATH);
			con = DriverManager.getConnection(URL, USER, PSWD);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				book b =new book();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getInt(4));
				b.setTotalpages(rs.getInt(5));
				al.add(b);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
		
	}
	
	public int deleteByBookauthor(String author) {
		String query ="delete from book where author=?";
		Connection con = null;
		try {
			Class.forName(PATH);
			con = DriverManager.getConnection(URL, USER, PSWD);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, author);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int deleteByBookID(int id) {
		String query ="delete from book where id=?";
		Connection con = null;
		try {
			Class.forName(PATH);
			con = DriverManager.getConnection(URL, USER, PSWD);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int updatebook(int id,book b) {
		Connection c = null;
		String query = "update book set name=?,author=?,price=?,totalpages=? where id=?";
		try {
			Class.forName(PATH);
			c = DriverManager.getConnection(URL,USER,PSWD);
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, b.getName());
			ps.setString(2, b.getAuthor());
			ps.setDouble(3, b.getPrice());
			ps.setInt(4, b.getTotalpages());
			ps.setInt(5, id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public book GetbyID(int id) {
		String query = "select * from book where id = ?";
		Connection c = null;
		try {
			Class.forName(PATH);
			c = DriverManager.getConnection(URL, USER, PSWD);
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				book b = new book();
				b.setId(res.getInt(1));
				b.setName(res.getString(2));
				b.setAuthor(res.getString(3));
				b.setPrice(res.getInt(4));
				b.setTotalpages(res.getInt(5));
				return b;	
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
