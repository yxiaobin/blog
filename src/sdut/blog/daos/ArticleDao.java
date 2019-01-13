package sdut.blog.daos;

import java.util.ArrayList;

import sdut.blog.domain.Article;
import sdut.blog.domain.Category;

public interface ArticleDao {
		//添加文章
		public int AddArticle(Article p);
		//修改文章
		public int UpdateArticle(Article p);
		//删除文章
		public int DelArticle(Article p) ;
		//查找所有文章
		public ArrayList<Article> SearchArticles();
		//查找文章ByID
		public Article SearchArticleByID(int id);
		//查找文章ByTitle
		public ArrayList<Article> SearchArticleByTitle(String title);
		//查找文章ByCategoryId
		public ArrayList<Article> SearchArticleByCategoryID(Category p);
		//查找文章数量
		public int SearchArticleCount();
		//查找用户文章的文章数量
		public int SearchMemberArticleCount(int member_id);
		//查找当前页显示的文章
		public ArrayList<Article> SearchArticleByStartIndex(int id , int startindex,int pagesize);
		
}
