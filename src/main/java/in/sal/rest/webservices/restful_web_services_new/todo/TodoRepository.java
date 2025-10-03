package in.sal.rest.webservices.restful_web_services_new.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>
{
	List<Todo> findByUsername(String username);
}
