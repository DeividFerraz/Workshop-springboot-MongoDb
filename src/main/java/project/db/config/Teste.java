package project.db.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import project.db.domain.User;
import project.db.respositoy.UserRepository;

@Configuration
@Profile("test")
public class Teste implements CommandLineRunner{

	@Autowired
	public UserRepository userRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User use = new User(null, "deivid ferraz", "deivid@gmail.com");
		User use1 = new User(null, "ana rubya", "ana@gmail.com");

		userRepository.saveAll(Arrays.asList(use, use1));
	}

}
