package fit.se.vttblog.repositories;

import fit.se.vttblog.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
