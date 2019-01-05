package sdut.blog.domain;

import sdut.blog.dao.impl.CategoryDaoImpl;

public class Category {
	int id;
	String name;
	int num;
	int show;
	public Category() {
		this.id = -1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getShow() {
		return show;
	}
	public void setShow(int show) {
		this.show = show;
	}
	public String getCategoryName() {
		CategoryDaoImpl op = new CategoryDaoImpl();
		Category p = op.SearchCategoryByID(this.id);
		
		return p.getName();
		
	}
}
