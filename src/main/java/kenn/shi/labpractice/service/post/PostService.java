package kenn.shi.labpractice.service.post;

import kenn.shi.labpractice.model.dto.request.PostDto;
import kenn.shi.labpractice.model.entity.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    void save(Post post);
    ResponseEntity<?> addPost(PostDto request);
    Post findById(Long id);
    List<Post> getAll();
    ResponseEntity<?> deletePost(Long id);
    ResponseEntity<?> updatePost(PostDto postDto);
}
