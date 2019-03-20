package kr.eunmo.todo;

import kr.eunmo.todo.dao.TodoDao;
import kr.eunmo.todo.dto.TodoDto;

public class Main {

	public static void main(String[] args) {
		TodoDao todoDao = new TodoDao();
		TodoDto todoDto = new TodoDto();
		todoDto.setTitle("서블릿, JDBC 공부하기");
		todoDto.setName("홍은모");
		todoDto.setSequence(1);
		
		int count = todoDao.addTodo(todoDto);
		System.out.println(count);
	}

}
