package in.sal.rest.webservices.restful_web_services_new.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController 
{
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/basicauth")
	public String basicAuthCheck()
	{
		return "Success";
	}
	@GetMapping("/hello-world")
	public String helloWorld()
	{
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World Bean");
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean("Hello World "+name);
	}
	@GetMapping("/hello-world-i18n")
	public String helloWorldI18n()
	{
		Locale locale= LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Defalut Message", locale);
		
	}
}
