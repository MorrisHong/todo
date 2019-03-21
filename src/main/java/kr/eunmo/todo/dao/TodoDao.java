package kr.eunmo.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
			DBClose.close(conn, ps);
		}
		
		return insertCount;
	}
	
	public List<TodoDto> getTodos() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select id, title, name, sequence, type, regdate from todo";
		
		List<TodoDto> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Long id = rs.getLong(1);
				String title = rs.getString(2);
				String name = rs.getString(3);
				int sequence = rs.getInt(4);
				String type = rs.getString(5);
				String regdate = rs.getString(6);
				
				TodoDto todo = new TodoDto(id, name, regdate, sequence, title, type);
				
				list.add(todo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, ps, rs);
		}
		
		return list;
		
	}
	
	public int updateTodo(TodoDto dto) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update todo set type = ? where id = ? ";
		int updateCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getType());
			ps.setLong(2, dto.getId());
			updateCount = ps.executeUpdate();			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(conn, ps);
		}
		
		return updateCount;
	}
	
}
