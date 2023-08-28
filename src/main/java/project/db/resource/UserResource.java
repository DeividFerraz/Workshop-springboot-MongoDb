package project.db.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.db.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User use = new User("1", "deivid", "deivid@gmail.com");
		User use1 = new User("2", "ana", "ana@gamil.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(use, use1));
		return ResponseEntity.ok().body(list);
	}
}
