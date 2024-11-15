package fit.se.vttblog.backend.entities;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

/**
 * @description
 * @author: vie
 * @date: 31/10/24
 */
@Getter
@Setter
@Document
public class Post {
   @Id
   private String id;

   private String title;

   private String thumbnail;

   private String summary;

   private Instant createAt;

   private Instant updateAt;

   private User author;

   private String tagSearch;

   private String slug;

   private String metaTitle;

   private Category category;
}
