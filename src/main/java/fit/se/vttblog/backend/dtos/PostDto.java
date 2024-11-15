package fit.se.vttblog.backend.dtos;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link fit.se.vttblog.backend.entities.Post}
 */
public record PostDto(
      String id,
      String title,
      String thumbnail,
      String summary,
      Instant createAt,
      Instant updateAt,
      String tagSearch,
      String slug,
      String metaTitle
) implements Serializable {
}