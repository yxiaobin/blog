package sdut.blog.daos;

import java.util.ArrayList;

import sdut.blog.domain.Article;
import sdut.blog.domain.Category;

public interface ArticleDao {
		//�������
		public int AddArticle(Article p);
		//�޸�����
		public int UpdateArticle(Article p);
		//ɾ������
		public int DelArticle(Article p) ;
		//������������
		public ArrayList<Article> SearchArticles();
		//��������ByID
		public Article SearchArticleByID(int id);
		//��������ByTitle
		public ArrayList<Article> SearchArticleByTitle(String title);
		//��������ByCategoryId
		public ArrayList<Article> SearchArticleByCategoryID(Category p);
		
}
