package in.sal.rest.webservices.restful_web_services_new.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController 
{
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersonOfPerson()
	{
		return new PersonV1("Sandip Lokare");
	}
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersonOfPerson()
	{
		return new PersonV2(new Name("Sandip","Lokare"));
	}
	@GetMapping(path = "/person",params = "verson=1")
	public PersonV1 getFirstVersonOfPersonRequestParameter()
	{
		return new PersonV1("Sandip");
	}
	@GetMapping(path = "/person",params = "verson=2")
	public PersonV2 getSecondVersonOfPersonRequestParameter()
	{
		return new PersonV2(new Name("Sandip","Lokare"));
	}
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersonOfPersonRequestHeader()
	{
		return new PersonV1("Sandip");
	}
	@GetMapping(path = "/person/header",headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersonOfPersonRequestHeader()
	{
		return new PersonV2(new Name("Sandip","Lokare"));
	}
	@GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader()
	{
		return new PersonV1("Sandip");
	}
	@GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader()
	{
		return new PersonV2(new Name("Sandip","Lokare"));
	}
}
