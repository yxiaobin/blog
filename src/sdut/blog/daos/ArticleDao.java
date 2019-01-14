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
		//��������ByCategoryId��MemberId��startIndex
		public ArrayList<Article> SearchArticleByCategoryIdAndMemberIdAndStartIndex(int category_id,int member_id,int startindex,int pagesize);
		//��������ByMemberId��startIndex
		public ArrayList<Article> SearchArticleByMemberIdAndStartIndex(int member_id,int startindex,int pagesize);
		//�������µ�����
		public int SearchArticleCount(int member_id);
		//�����������ͨ���ĸ÷��������µ�����
		public int SearchArticleCountByCategoryId(int member_id,int category_id);
		//�����û����ͨ���ĵ���������
		public int SearchMemberArticleCount(int member_id);
		//���ҵ�ǰҳ��ʾ������
		public ArrayList<Article> SearchArticleByStartIndex(int id , int startindex,int pagesize);
		//����δ���ͨ�������µ�������������ʾ��������Ա��ʾ�����б��ҳ
		public int SearchUnjudgeArticleCount();
		//���ڳ�������Ա��ʾ��ǰҳ������
		public ArrayList<Article>  SearchUnjudgeArticleByStartIndex(int startindex,int pagesize);
		
}
