package fit.se.vttblog.repositories;

import fit.se.vttblog.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
