package in.sal.rest.webservices.restful_web_services_new.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sal.rest.webservices.restful_web_services_new.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer>
{
	
}
