package project.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.db.domain.Post;
import project.db.respositoy.PostRepository;
import project.db.service.exception.Obj404Exception;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new Obj404Exception("Objeto não encontrado"));
	}
}