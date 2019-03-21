package kr.eunmo.todo;

import java.util.List;

import kr.eunmo.todo.dao.TodoDao;
import kr.eunmo.todo.dto.TodoDto;

public class Test {

	public static void main(String[] args) {
//		TodoDao todoDao = new TodoDao();
//		TodoDto todoDto = new TodoDto();
//		todoDto.setTitle("서블릿, JDBC 공부하기");
//		todoDto.setName("홍은모");
//		todoDto.setSequence(1);
//		
//		int count = todoDao.addTodo(todoDto);
//		System.out.println(count);
		
//		TodoDao dao = new TodoDao();
//		List<TodoDto> list = dao.getTodos();
//		
//		for(TodoDto todo : list) {
//			System.out.println(todo.toString());
//		}
		
		TodoDto dto = new TodoDto();
		dto.setType("DONE");
		dto.setId(1L);
		
		TodoDao dao = new TodoDao();
		System.out.println(dao.updateTodo(dto));
		
		
	}

}
