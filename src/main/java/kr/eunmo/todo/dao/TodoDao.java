package kr.eunmo.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import kr.eunmo.todo.dto.TodoDto;

public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public int addTodo(TodoDto dto) {
		int insertCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into todo(title, name, sequence) values(?,?,?)";
		

		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getSequence());
			
			insertCount = ps.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBClose dbClose = new DBClose();
			dbClose.close(conn, ps);
		}
		
		return insertCount;
		
		
		
	}
	
	public List getTodos() {
		
		
		return null;
		
	}
	
	public int updateTodo(TodoDto dto) {
		
		return 0;
	}
	
	

}
