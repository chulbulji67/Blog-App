package com.blog.blogapp.service.articleservice.impl;

import com.blog.blogapp.entity.Article;
import com.blog.blogapp.entity.User;
import com.blog.blogapp.exception.articleexception.NoArticleFoundException;
import com.blog.blogapp.exception.userexception.NoUserFoundException;
import com.blog.blogapp.repo.ArticleRepo;
import com.blog.blogapp.repo.UserRepo;
import com.blog.blogapp.service.articleservice.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepo articleRepo;

    @Autowired
    UserRepo userRepo;
    @Override
    public Article createNewArticle(Article article) {
        User user = userRepo.findById(article.getUser().getId()).orElse(null);
        if(user == null) throw new NoUserFoundException("User Not found ");
        article.setUser(user);
        return articleRepo.save(article);
    }

    @Override
    public List<Article> findAllArticles() {
        List<Article> articles = articleRepo.findAll();
        if(articles.isEmpty()) throw new NoArticleFoundException("No article Found");
        return articles;
    }

    @Override
    public Article findArticleById(long id) {
        Article article = articleRepo.findById(id).orElse(null);
        if(article == null) throw new NoArticleFoundException("No article Found with id: "+id);
        return article;
    }

    @Override
    public Article updateArticle(Article article, long id) {
        Article exArticle = articleRepo.findById(id).orElse(null);
        if(exArticle == null) throw new NoArticleFoundException("No article Found with id: "+id);
        exArticle.setTitle(article.getTitle() != null?article.getTitle() : exArticle.getTitle());
        exArticle.setContent(article.getContent()!= null? article.getContent():exArticle.getContent());
        exArticle.setLikes_count(article.getLikes_count() != 0? article.getLikes_count(): exArticle.getLikes_count());
        return articleRepo.save(exArticle);
    }

    @Override
    public Article deleteArticle(long id) {
        Article exArticle = articleRepo.findById(id).orElse(null);
        if(exArticle == null) throw new NoArticleFoundException("No article Found with id: "+id);
        articleRepo.deleteById(id);
        return exArticle;
    }
}
