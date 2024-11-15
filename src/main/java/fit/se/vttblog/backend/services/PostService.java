package fit.se.vttblog.backend.services;

import fit.se.vttblog.backend.dtos.PostDto;
import fit.se.vttblog.backend.mappers.PostMapper;
import fit.se.vttblog.backend.repositories.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: vie
 * @date: 15/11/24
 */
@Service
public class PostService {
   private final PostRepository postRepository;
   private final PostMapper postMapper;

   public PostService(PostRepository postRepository,
                      PostMapper postMapper) {
      this.postRepository = postRepository;
      this.postMapper = postMapper;
   }

   public Page<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
      Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
      Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
      return postRepository.findAll(pageable)
                   .map(postMapper::toDto);
   }
}
