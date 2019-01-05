package sdut.blog.services;

import java.util.ArrayList;

import sdut.blog.domain.Article;
import sdut.blog.domain.Page;

public interface ArticleService {
	ArrayList<Article> SearchArticleByCount();
	ArrayList<Article> SearchArticleByCategoryId(int categoryid);
	ArrayList<Article> SearchArticles();
	ArrayList<Article> SearchArticlesByCategoryIdandPage(int id, Page page);
	ArrayList<Article> SearchArticlesandPage(Page page);
}
