package in.sal.rest.webservices.restful_web_services_new.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import in.sal.rest.webservices.restful_web_services_new.jpa.PostRepository;
import in.sal.rest.webservices.restful_web_services_new.jpa.UserRepository;
import jakarta.validation.Valid;

@RestController
public class UserJpaController {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return repository.findAll();

	}

	@GetMapping("/jpa/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);

		if (user == null) {
			throw new UserNotFoundException("id: " + id);
		}
		return user.get();
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		repository.deleteById(id);
	}

	@PutMapping("/jpa/users/{id}")
	public User updateUser(@RequestBody User user, @PathVariable int id) {
		user.setId(id);
		return repository.save(user);
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);

		if (user == null) {
			throw new UserNotFoundException("id: " + id);
		}
		return user.get().getPosts();

	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id,@Valid @RequestBody Post post)
	{
		Optional<User> user = repository.findById(id);

		if (user == null) {
			throw new UserNotFoundException("id: " + id);
		}
		post.setUser(user.get());
		
		Post savedPost = postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}
