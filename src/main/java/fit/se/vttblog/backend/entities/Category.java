package fit.se.vttblog.backend.entities;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @description
 * @author: vie
 * @date: 31/10/24
 */
@Getter
@Setter
@Document
public class Category {
   @Id
   private String id;

   private String name;

   private int status;
}
