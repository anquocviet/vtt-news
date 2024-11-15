package fit.se.vttblog.backend.repositories;

import fit.se.vttblog.backend.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
