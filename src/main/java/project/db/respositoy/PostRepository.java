package project.db.respositoy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import project.db.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
