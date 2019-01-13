package sdut.blog.services;

import java.util.ArrayList;

import sdut.blog.domain.Article;
import sdut.blog.domain.Page;

public interface ArticleService {
	//ͨ����Ա��ѯ���£�������ͨ��Ա��̨��ʾ�����б����ʾ��ҳ����
	ArrayList<Article> SearchArticleByCount(int member_id);
	//ͨ�������ѯ���£�������ʾ��ҳ��������
	ArrayList<Article> SearchArticleByCategoryId(int categoryid);
	//��ѯ�������£����ڳ�������Ա������������
	ArrayList<Article> SearchArticles();
	//ͨ��ҳ���ͷ����ѯ����
	ArrayList<Article> SearchArticlesByCategoryIdandPage(int id, Page page);
	ArrayList<Article> SearchArticlesandPage(Page page);
}
