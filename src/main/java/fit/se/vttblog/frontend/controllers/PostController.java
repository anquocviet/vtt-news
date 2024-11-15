package fit.se.vttblog.frontend.controllers;

import fit.se.vttblog.backend.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * @description
 * @author: vie
 * @date: 15/11/24
 */
@Controller
@RequestMapping("/posts")
public class PostController {
   private final PostService postService;

   public PostController(PostService postService) {
      this.postService = postService;
   }

   @GetMapping(value = {"", "/"})
   public ModelAndView showPosts(Optional<Integer> page, Optional<Integer> size) {
      int currentPage = page.orElse(1);
      int pageSize = size.orElse(10);
      ModelAndView mav = new ModelAndView("posts/index");
      mav.addObject("posts", postService.getAllPosts(
            currentPage - 1, pageSize, "createAt", "desc"));
      return mav;
   }
}
