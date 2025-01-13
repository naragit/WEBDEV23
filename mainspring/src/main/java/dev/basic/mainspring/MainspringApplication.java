package dev.basic.mainspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;

@RestController
@SpringBootApplication
public class MainspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainspringApplication.class, args);
	}

	@RequestMapping(value = "/spring")
	public String mainTest()
	{
		try
		{
			String hostName = Inet4Address.getLocalHost().getHostName();
			String appName = System.getenv("APP_NAME");
			String dt = new java.util.Date().toString();
			String str = "<br>Host: "+hostName + "<br> "+"Name: "+appName+"<br>Date: "+dt;

			return "<h2>" + str+ "</h2>\n";
		}catch ( Exception ee) {
			ee.printStackTrace();
		}
		return " Error in App ";
	}
}
