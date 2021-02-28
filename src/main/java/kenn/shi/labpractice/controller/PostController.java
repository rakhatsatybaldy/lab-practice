package kenn.shi.labpractice.controller;

import kenn.shi.labpractice.model.dto.request.PostDto;
import kenn.shi.labpractice.model.entity.Post;
import kenn.shi.labpractice.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@Valid @RequestBody PostDto postDto){
        return postService.addPost(postDto);
    }

    @GetMapping(value = "/id/{id}")
    public Post post(@PathVariable(name = "id")Long id){
        return postService.findById(id);
    }

    @GetMapping(value = "/list")
    public List<Post> list(){
        return postService.getAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id")Long id){
        return postService.deletePost(id);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody PostDto postDto){
        return postService.updatePost(postDto);
    }
}
