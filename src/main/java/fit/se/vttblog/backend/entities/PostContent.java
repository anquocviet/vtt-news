package fit.se.vttblog.backend.entities;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @description
 * @author: vie
 * @date: 31/10/24
 */
@Getter
@Setter
@Document
public class PostContent {
   @Id
   private String id;

   private Post post;

   private List<Section> sections;
}
