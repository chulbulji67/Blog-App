package com.blog.blogapp.controller;

import com.blog.blogapp.entity.Tag;
import com.blog.blogapp.service.tagservice.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    TagService tagService;

    //    POST /tags: Create a new tag.
    @PostMapping()
    public ResponseEntity<?> AddATag(@RequestBody Tag tag){
        return ResponseEntity.status(HttpStatus.CREATED).body(tagService.createNewTag(tag));
    }

    //    GET /tags: Get a list of all tags.
    @GetMapping()
    public ResponseEntity<?> getAllTags(){
        return ResponseEntity.status(HttpStatus.OK).body(tagService.findAllTags());
    }

    //    GET /tags/{id}: Get a specific tag by ID.
    @GetMapping("/{id}")
    public ResponseEntity<?> findTagById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(tagService.findTagById(id));
    }

    //            PUT /tags/{id}: Update an existing tag.
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTagById(@RequestBody Tag tag, @PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(tagService.updateTagById(tag, id));
    }

//    DELETE /tags/{id}: Delete a tag.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMapping(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(tagService.deleteTagById(id));
    }



}
