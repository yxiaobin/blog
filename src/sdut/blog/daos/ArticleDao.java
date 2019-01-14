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
		//查找文章ByCategoryId和MemberId和startIndex
		public ArrayList<Article> SearchArticleByCategoryIdAndMemberIdAndStartIndex(int category_id,int member_id,int startindex,int pagesize);
		//查找文章ByMemberId和startIndex
		public ArrayList<Article> SearchArticleByMemberIdAndStartIndex(int member_id,int startindex,int pagesize);
		//查找文章的数量
		public int SearchArticleCount(int member_id);
		//查找文章审核通过的该分类文章下的数量
		public int SearchArticleCountByCategoryId(int member_id,int category_id);
		//查找用户审核通过的的文章数量
		public int SearchMemberArticleCount(int member_id);
		//查找当前页显示的文章
		public ArrayList<Article> SearchArticleByStartIndex(int id , int startindex,int pagesize);
		//查找未审核通过的文章的数量，用于显示超级管理员显示文章列表分页
		public int SearchUnjudgeArticleCount();
		//用于超级管理员显示当前页的文章
		public ArrayList<Article>  SearchUnjudgeArticleByStartIndex(int startindex,int pagesize);
		
}
