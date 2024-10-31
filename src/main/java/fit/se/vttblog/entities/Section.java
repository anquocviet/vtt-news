package fit.se.vttblog.entities;

import fit.se.vttblog.enums.SectionType;
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
public class Section {
   private SectionType type;

   private String content;

   private String desc;

   private String alt;
}
