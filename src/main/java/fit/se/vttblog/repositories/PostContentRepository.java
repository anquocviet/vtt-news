package fit.se.vttblog.repositories;

import fit.se.vttblog.entities.PostContent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostContentRepository extends MongoRepository<PostContent, String> {
}
