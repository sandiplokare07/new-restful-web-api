package in.sal.rest.webservices.restful_web_services_new.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SpringSecurityConfiguration 
{
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		//1. All request should be authenticated
		http.authorizeHttpRequests(auth->auth.requestMatchers(HttpMethod.OPTIONS, "/**")
				.permitAll().anyRequest().authenticated());
		//http.authorizeHttpRequests(auth->auth.anyRequest().permitAll()).cors();
		
		//2. If a request is not authenticated, a web page is show
		http.httpBasic(withDefaults());
		
		//3. CSRF -> POST,PUT
		http.csrf().disable();
		
		http.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		return http.build();
	}
}
