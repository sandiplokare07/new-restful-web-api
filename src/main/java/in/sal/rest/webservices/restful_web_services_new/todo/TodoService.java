package in.sal.rest.webservices.restful_web_services_new.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService
{
	private static List<Todo> todos=new ArrayList<>();
	
	private static int countTodo=0;
	
	static
	{
		todos.add(new Todo(++countTodo,"sandip","Learn Java",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++countTodo,"sandip","Learn Spring",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++countTodo,"sandip","Learn Spring Boot",LocalDate.now().plusYears(1),false));		
	}
	
	public List<Todo> findByUsername(String username)
	{
		Predicate<? super Todo> predicate= todo -> todo.getUsername().equals(username);
		return todos.stream().filter(predicate).toList();
	}
	public Todo addTodo(String username,String description,LocalDate targetDate,boolean done)
	{
		Todo todo=new Todo(++countTodo,username,description,targetDate,done);
		todos.add(todo);
		return todo;	
	}
	public void deleteById(int id)
	{
		Predicate<? super Todo> predicate=todo -> todo.getId()==id;
		todos.removeIf(predicate);
	}
	public Todo findById(int id)
	{
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	public Todo updateTodo(Todo todo)
	{
		deleteById(todo.getId());
		todos.add(todo);
		return todo;
	}
}
