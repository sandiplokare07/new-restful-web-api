package in.sal.rest.webservices.restful_web_services_new.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResorce 
{
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers()
	{
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id)
	{
		User user = service.findOne(id);
		
		if(user==null)
		{
			throw new UserNotFoundException("id: "+id);
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user)
	{
		User savedUser = service.addUser(user);
		
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		
		return ResponseEntity.created(location ).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id)
	{
		service.deleteUser(id);
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User user,@PathVariable int id)
	{
		user.setId(id);
		return service.changeDetailUser(user);
	}
}
