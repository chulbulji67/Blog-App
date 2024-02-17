package com.blog.blogapp.service.articleservice;

import com.blog.blogapp.entity.Article;

import java.util.List;

public interface ArticleService {
    //Create an new Article
    Article createNewArticle(Article article);

    //Find All articles
    List<Article> findAllArticles();

    //Get Article by Id
    Article findArticleById(long id);

    //Update the Article based on Id
    Article updateArticle(Article article,long id);

    //Delete Article by Id
    Article deleteArticle(long id);
}
