package fit.se.vttblog.backend.repositories;

import fit.se.vttblog.backend.entities.PostContent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostContentRepository extends MongoRepository<PostContent, String> {
}
