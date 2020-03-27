package com.movie.utils;

import java.util.ArrayList;
import java.util.List;

public class ListPagerUtil<T> {

	private List<T> list; // 外界传入要分页的集合
	private int curentPage; // 当前页号，外界传入
	private int pageCount; // 每页条数，外界传入
	private int totalPage; // 页数
	private List<Integer> navigatepageNums; // 导航栏集合
	private int totalRecord; // 总记录数
	private int previousPage; // 上一页序号
	private int nextPage; // 下一页序号
	private boolean hasPrePage; // 是否有上一页
	private boolean hasNextPage; // 是否有下一页
	private boolean isFirstPage; // 是否第一页
	private boolean isLastPage; // 是否最后一页
	private List<T> pageList; // 返回的分页集合

	public ListPagerUtil(List<T> list, int curentPage, int pageCount) {
		super();

		this.list = list;
		this.curentPage = curentPage;
		this.pageCount = pageCount;

		init();
		checkCurPage();
		pageSettings();
		subPageList();
	}

	/**
	 * 初始化该分页对象
	 */
	private void init() {
		if (null != list) {
			totalRecord = list.size();
			
			if (totalRecord % this.pageCount == 0) {
				this.totalPage = totalRecord / this.pageCount;
			} else {
				this.totalPage = totalRecord / this.pageCount + 1;
			}
			//System.out.println(totalRecord);
			//System.out.println(totalPage);
		}else {
			System.out.println("集合不能为空！");
		}
		
	}
	
	private void checkCurPage() {
		if(this.curentPage<1) {
			this.curentPage = 1;
		}
		if(this.curentPage>totalPage) {
			this.curentPage = totalPage;
		}
	}
	
	private void pageSettings() {
		if(curentPage==1) {
			this.hasPrePage = false;
			this.hasNextPage = true;
			// 没有上一页是就设置为1
			this.previousPage = 1;
			this.nextPage = curentPage + 1;
			
		}else if(curentPage==totalPage) {
			this.hasPrePage = true;
			this.hasNextPage = false;
			// 没有下一页是就设置为最后一页
			this.previousPage = curentPage - 1;
			this.nextPage = totalPage;
			
			this.isFirstPage = false;
			this.isLastPage = true;
		}else {
			this.hasPrePage = true;
			this.hasNextPage = true;
			// 没有下一页是就设置为最后一页
			this.previousPage = curentPage - 1;
			this.nextPage = curentPage + 1;
			
			this.isFirstPage = false;
			this.isLastPage = false;
		}
		// 1 到 17 页
		List<Integer> sublist = new ArrayList<>();
		
		for(int i=1;i<=totalPage;i++) {
			sublist.add(i);
		}
		
		if(totalPage>=5) {
				if(curentPage==1 || curentPage==2 || curentPage==3 || curentPage==4 || curentPage==5 ) {
					navigatepageNums = sublist.subList(0, 5);
				}else if(curentPage==totalPage ||  curentPage==totalPage-1 ||  curentPage==totalPage-2
						||  curentPage==totalPage-3 || curentPage==totalPage-4){
					navigatepageNums = sublist.subList(totalPage-5, totalPage);
				}else {
					navigatepageNums = sublist.subList(curentPage-3, curentPage+2);
				}
			
		}else {
			sublist.subList(0, totalPage);
		}
		
	}

	private void subPageList() {
		int fromIndex = 0;
		int toIndex = 0;
		
		if(curentPage==1 && curentPage!=totalPage) {
			this.isFirstPage = true;
			this.isLastPage = false;
			fromIndex = 0;
			toIndex = pageCount;
		}else if(curentPage!=1 && curentPage!=totalPage) {
			this.isFirstPage = false;
			this.isLastPage = false;
			toIndex = curentPage * pageCount;
			fromIndex = toIndex - pageCount;
		}else if(curentPage!=1 && curentPage==totalPage) {
			this.isFirstPage = false;
			this.isLastPage = true;
			fromIndex = (curentPage-1) * pageCount;
			toIndex = totalRecord;
		}else {
			// 当前页既是第一页又是最后一页
			this.isFirstPage = true;
			this.isLastPage = true;
			fromIndex = 0;
			toIndex = totalRecord;
		}
		
		// 截取数据包括fromIndex的数据，不包括第toIndex的数据
		this.pageList = list.subList(fromIndex, toIndex);
	}

	public int getCurentPage() {
		return curentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public List<Integer> getNavigatepageNums() {
		return navigatepageNums;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public List<T> getPageList() {
		return pageList;
	}

	@Override
	public String toString() {
		return "ListPagerUtil [curentPage=" + curentPage + ", pageCount=" + pageCount
				+ ", totalPage=" + totalPage + ", totalRecord=" + totalRecord + ", previousPage=" + previousPage
				+ ", nextPage=" + nextPage + ", hasPrePage=" + hasPrePage + ", hasNextPage=" + hasNextPage
				+ ", isFirstPage=" + isFirstPage + ", isLastPage=" + isLastPage + ", pageList=" + pageList + "]";
	}
	
}
