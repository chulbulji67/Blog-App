package com.blog.blogapp.service.tagservice;

import com.blog.blogapp.entity.Tag;

import java.util.List;

public interface TagService {

    //POST /tags: Create a new tag.
    Tag createNewTag(Tag tag);

    //GET /tags: Get a list of all tags.
    List<Tag> findAllTags();

    //GET /tags/{id}: Get a specific tag by ID.
    Tag findTagById(long id);

    //PUT /tags/{id}: Update an existing tag.
    Tag updateTagById(Tag tag,long id);

    //DELETE /tags/{id}: Delete a tag.
    Tag deleteTagById(long id);


}
