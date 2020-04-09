package cn.bdqn.gph.entity;

import java.util.List;



/*
 * ��ҳ ������
 */
public class Page {
	private int totalPageCount; // ��ҳ��
	private int totalCount; // ��¼����
	private int pageSize; // ÿҳ��ʾ��¼��
	private int currPageNo; // ��ǰҳ��
	private List<Product> prolist; // ÿҳ��Ʒ����
	public Page(int totalCount, int pageSize, int currPageNo) {
		super();
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currPageNo = currPageNo;
		if(this.totalCount%this.pageSize==0){
			this.totalPageCount=this.totalCount/pageSize;
		}else if(this.totalCount%this.pageSize>0){
			this.totalPageCount=this.totalCount/pageSize+1;
		}else{
			this.totalPageCount=0;
		}
	}
	public Page(){}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if (currPageNo > 0) {
			this.totalCount = totalCount;
			totalPageCount = this.totalCount % pageSize == 0 ? (this.totalCount / pageSize)
					: (this.totalCount / pageSize + 1);
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}
	public List<Product> getProlist() {
		return prolist;
	}
	public void setProlist(List<Product> prolist) {
		this.prolist = prolist;
	}
	
	
}
