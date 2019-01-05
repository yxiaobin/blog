package sdut.blog.services;

import java.util.ArrayList;

import sdut.blog.domain.Article;

public interface ArticleService {
	ArrayList<Article> SearchArticleByCount();
	ArrayList<Article> SearchArticleByCategoryId(int categoryid);
	ArrayList<Article> SearchArticles();
}
