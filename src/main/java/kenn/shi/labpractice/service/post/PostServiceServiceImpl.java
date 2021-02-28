package kenn.shi.labpractice.service.post;

import kenn.shi.labpractice.model.dto.request.PostDto;
import kenn.shi.labpractice.model.entity.Post;
import kenn.shi.labpractice.model.entity.User;
import kenn.shi.labpractice.repository.post.PostRepository;
import kenn.shi.labpractice.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceServiceImpl implements PostService {

    private final UserService userService;
    private final PostRepository postRepository;


    @Autowired
    public PostServiceServiceImpl(UserService userService, PostRepository postRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public ResponseEntity<?> addPost(PostDto request) {
        Post post = new Post();
        User user = userService.getById(request.getUserId());
        if (user==null){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    ""
            );
        }
        post.setPostDate(LocalDateTime.now());
        post.setDetails(request.getDetails());
        post.setUser(user);
        save(post);
        return new ResponseEntity<>("Added" , HttpStatus.OK);
    }

    @Override
    public Post findById(Long id) {
        Post post = postRepository.getById(id);
        if (post==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    ""
            );
        }
        return post;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    @Override
    public ResponseEntity<?> deletePost(Long id) {
        Post post = findById(id);
        postRepository.delete(post);
        return new ResponseEntity<>("Deleted"  ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updatePost(PostDto postDto) {
        Post post = findById(postDto.getId());
        post.setPostDate(LocalDateTime.now());
        post.setDetails(post.getDetails());
        post.setUser(post.getUser());
        save(post);
        return new ResponseEntity<>("Updated"  , HttpStatus.OK);
    }
}
