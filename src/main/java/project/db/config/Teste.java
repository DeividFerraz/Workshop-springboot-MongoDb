package project.db.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import project.db.domain.Post;
import project.db.domain.User;
import project.db.dto.AuthorDTO;
import project.db.dto.CommentDTO;
import project.db.respositoy.PostRepository;
import project.db.respositoy.UserRepository;

@Configuration
@Profile("test")
public class Teste implements CommandLineRunner{

	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User use = new User(null, "deivid ferraz", "deivid@gmail.com");
		User use1 = new User(null, "ana rubya", "ana@gmail.com");

		userRepository.saveAll(Arrays.asList(use, use1));
		
		Post post1 = new Post(null, sdf.parse("21/08/2023"), "viagem", "Para grecia", new AuthorDTO(use));
		Post post2 = new Post(null, sdf.parse("22/08/2023"), "Casa", "Para italia",  new AuthorDTO(use1));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(use));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(use1));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(use));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	
		use.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(use);
		
	}

}
