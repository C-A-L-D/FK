package com.sc.print;

import com.sc.ink.Ink;
import com.sc.paper.Paper;

public class Printer {

	//依赖黑盒,纸张
	Ink ink;
	Paper paper;
	
	public Ink getInk() {
		return ink;
	}

	public void setInk(Ink ink) {
		this.ink = ink;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}



	public void print() {
		System.out.println("我正在使用" + ink.color() + "的墨盒，和" + paper.size() + "的纸张打印文件");
	}
}
