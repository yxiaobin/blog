package sdut.blog.domain;

import java.util.List;

public class Page {
		//分页记录集
		private List records;
		//分页大小
		private int pagesize = 4;
		//当前页
		private int pagenum;
		//总页数
		private int totalpage;
		//当前页的记录索引起始
		private int startindex;
		//总记录数
		private int totalrecords;
		//要显示的页码
		private int startPage;
		private int endPage;
		//查询数据的那个Servlet
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
		//保证当页码在中间*****
		//当前页和总记录数
		public Page(int pagenum,int totalrecords) {
			this.pagenum = pagenum;//当前页
			if(totalrecords/pagesize < pagenum && totalrecords%pagesize == 0) {
				pagenum = totalrecords/pagesize; 
			}
			this.totalrecords = totalrecords;//总记录数
			//计算每一页的索引
			this.startindex = (pagenum-1)*pagesize;
			//计算总页数
			//用三目表达式表判断
			//this.totalpage  = totalrecords%pagesize == 0?totalrecords/pagesize:(totalrecords/pagesize+1);
			if(totalrecords % pagesize == 0) {
				totalpage = totalrecords/pagesize;
			}else {
				totalpage = totalrecords/pagesize+1;
			}
			//要显示的页码
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
		//可以改变分页大小的构造函数
		public Page(int pagesize ,int pagenum,int totalrecords) {
			this.pagesize = pagesize;
			this.pagenum = pagenum;//当前页
			this.totalrecords = totalrecords;//总记录数
			//计算每一页的索引
			this.startindex = (pagenum-1)*pagesize;
			//计算总页数
			//用三目表达式表判断
			//this.totalpage  = totalrecords%pagesize == 0?totalrecords/pagesize:(totalrecords/pagesize+1);
			if(totalrecords % pagesize == 0) {
				totalpage = totalrecords/pagesize;
			}else {
				totalpage = totalrecords/pagesize+1;
			}
			//要显示的页码
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
