package sdut.blog.domain;

import java.util.List;

public class Page {
		//��ҳ��¼��
		private List records;
		//��ҳ��С
		private int pagesize = 4;
		//��ǰҳ
		private int pagenum;
		//��ҳ��
		private int totalpage;
		//��ǰҳ�ļ�¼������ʼ
		private int startindex;
		//�ܼ�¼��
		private int totalrecords;
		//Ҫ��ʾ��ҳ��
		private int startPage;
		private int endPage;
		//��ѯ���ݵ��Ǹ�Servlet
		private String servletUrl;
		public List getRecords() {
			return records;
		}
		public void setRecords(List records) {
			this.records = records;
		}
		public int getPagesize() {
			return pagesize;
		}
		public void setPagesize(int pagesize) {
			this.pagesize = pagesize;
		}
		public int getPagenum() {
			return pagenum;
		}
		public void setPagenum(int pagenum) {
			this.pagenum = pagenum;
		}
		public int getTotalpage() {
			return totalpage;
		}
		public void setTotalpage(int totalpage) {
			this.totalpage = totalpage;
		}
		public int getStartindex() {
			return startindex;
		}
		public void setStartindex(int startindex) {
			this.startindex = startindex;
		}
		public int getTotalrecords() {
			return totalrecords;
		}
		public void setTotalrecords(int totalrecords) {
			this.totalrecords = totalrecords;
		}
		public int getStartPage() {
			return startPage;
		}
		public void setStartPage(int startPage) {
			this.startPage = startPage;
		}
		public int getEndPage() {
			return endPage;
		}
		public void setEndPage(int endPage) {
			this.endPage = endPage;
		}
		public String getServletUrl() {
			return servletUrl;
		}
		public void setServletUrl(String servletUrl) {
			this.servletUrl = servletUrl;
		}
		//��֤��ҳ�����м�*****
		//��ǰҳ���ܼ�¼��
		public Page(int pagenum,int totalrecords) {
			this.pagenum = pagenum;//��ǰҳ
			if(totalrecords/pagesize < pagenum && totalrecords%pagesize == 0) {
				pagenum = totalrecords/pagesize; 
			}
			this.totalrecords = totalrecords;//�ܼ�¼��
			//����ÿһҳ������
			this.startindex = (pagenum-1)*pagesize;
			//������ҳ��
			//����Ŀ���ʽ���ж�
			//this.totalpage  = totalrecords%pagesize == 0?totalrecords/pagesize:(totalrecords/pagesize+1);
			if(totalrecords % pagesize == 0) {
				totalpage = totalrecords/pagesize;
			}else {
				totalpage = totalrecords/pagesize+1;
			}
			//Ҫ��ʾ��ҳ��
			if(totalpage<=5) {
				startPage = 1;
				endPage = totalpage;
			}else {
				startPage = pagenum -2;
				endPage = pagenum+2;
				if(startPage<1) {
					startPage = 1;
					endPage = 5;
				}
				if(endPage>totalpage) {
					endPage = totalpage;
					startPage = totalpage-4;
				}
			}
		}
		//���Ըı��ҳ��С�Ĺ��캯��
		public Page(int pagesize ,int pagenum,int totalrecords) {
			this.pagesize = pagesize;
			this.pagenum = pagenum;//��ǰҳ
			this.totalrecords = totalrecords;//�ܼ�¼��
			//����ÿһҳ������
			this.startindex = (pagenum-1)*pagesize;
			//������ҳ��
			//����Ŀ���ʽ���ж�
			//this.totalpage  = totalrecords%pagesize == 0?totalrecords/pagesize:(totalrecords/pagesize+1);
			if(totalrecords % pagesize == 0) {
				totalpage = totalrecords/pagesize;
			}else {
				totalpage = totalrecords/pagesize+1;
			}
			//Ҫ��ʾ��ҳ��
			if(totalpage<=5) {
				startPage = 1;
				endPage = totalpage;
			}else {
				startPage = pagenum -2;
				endPage = pagenum+2;
				if(startPage<1) {
					startPage = 1;
					endPage = 5;
				}
				if(endPage>totalpage) {
					endPage = totalpage;
					startPage = totalpage-4;
				}
			}
		}
}
