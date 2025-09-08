package in.sal.rest.webservices.restful_web_services_new.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService 
{
	
	
	private static List<User> users= new ArrayList<>();
	private static int count=0;
	
	static
	{
		users.add(new User(++count,"Sandip",LocalDate.now().minusYears(25)));
		users.add(new User(++count,"Avi",LocalDate.now().minusYears(28)));
		users.add(new User(++count,"Sagar",LocalDate.now().minusYears(30)));
	}
	
	public List<User> findAll()
	{
		return users;
		
	}
	public User findOne(int id)
	{
		Predicate<? super User> predicate= user->user.getId()==id;
		
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User addUser(User user)
	{
		user.setId(++count);
		users.add(user);
		return user;
		
	}
	public void deleteUser(int id)
	{
		Predicate<? super User> pridicate=user-> user.getId()==id;
		users.removeIf(pridicate);
	}
	
	public User changeDetailUser(User user)
	{
		//Predicate<? super User> predicate= user1->user1.getId()==id;
		//user.setId(++count);
		//users.add(user);
		return user;
		//return users.stream().filter(predicate).findFirst().get();
	}
}
