package sdut.blog.services;

import java.util.ArrayList;

import sdut.blog.domain.Article;
import sdut.blog.domain.Page;

public interface ArticleService {
	//通过成员查询文章，用于普通成员后台显示文章列表和显示首页文章
	ArrayList<Article> SearchArticleByCount(int member_id);
	//通过分类查询文章，用于显示首页分类文章
	ArrayList<Article> SearchArticleByCategoryId(int categoryid);
	//查询所有文章，用于超级管理员管理所有文章
	ArrayList<Article> SearchArticles();
	//通过页数和分类查询文章
	ArrayList<Article> SearchArticlesByCategoryIdandPage(int id, Page page);
	ArrayList<Article> SearchArticlesandPage(Page page);
}
