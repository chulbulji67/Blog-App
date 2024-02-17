package com.blog.blogapp.service.tagservice.impl;

import com.blog.blogapp.entity.Article;
import com.blog.blogapp.entity.Tag;
import com.blog.blogapp.exception.articleexception.NoArticleFoundException;
import com.blog.blogapp.exception.tagException.NoTagFoundException;
import com.blog.blogapp.repo.ArticleRepo;
import com.blog.blogapp.repo.TagRepo;
import com.blog.blogapp.service.tagservice.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepo tagRepo;

   @Autowired
    ArticleRepo articleRepo;
    @Override
    public Tag createNewTag(Tag tag) {
       List<Article> articles =  tag.getArticles();
        List<Article> existingArticles =  new ArrayList<>();
        for(int i = 0; i<articles.size(); i++){
            Article article = articleRepo.findById(articles.get(i).getId()).orElse(null);
            if(article == null) throw new NoArticleFoundException("No Article Found with this id");
            existingArticles.add(article);
        }
       tag.setArticles(existingArticles);
        return tagRepo.save(tag);
    }

    @Override
    public List<Tag> findAllTags() {
        List<Tag> tags = tagRepo.findAll();

        if(tags.isEmpty()) throw new NoTagFoundException("No tag found");
        return tags;
    }

    @Override
    public Tag findTagById(long id) {
        Tag tag = tagRepo.findById(id).orElse(null);
        if(tag == null) throw new NoTagFoundException("No tag foudn with id: "+id);

        return tag;
    }

    @Override
    public Tag updateTagById(Tag tag,long id) {
        Tag existingTag = tagRepo.findById(id).orElse(null);
        if(existingTag == null) throw new NoTagFoundException("No tag foudn with id: "+id);
        //Find article
        List<Article> articles =  tag.getArticles();
        List<Article> existingArticles =  new ArrayList<>();


        for(int i = 0; i<articles.size(); i++){
            Article article = articleRepo.findById(articles.get(i).getId()).orElse(null);
            if(article == null) throw new NoArticleFoundException("No Article Found with this id");
            existingArticles.add(article);
        }

        existingTag.setTag_name(tag.getTag_name());

//        existingTag.setArticles(existingArticles);
        return tagRepo.save(existingTag);
    }

    @Override
    public Tag deleteTagById(long id) {
        Tag tag = tagRepo.findById(id).orElse(null);
        if(tag == null) throw new NoTagFoundException("No tag foudn with id: "+id);
        tagRepo.deleteById(id);
        return tag;
    }
}
