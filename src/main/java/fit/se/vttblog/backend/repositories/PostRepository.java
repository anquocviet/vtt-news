package fit.se.vttblog.backend.repositories;

import fit.se.vttblog.backend.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
