package com.sc.print;

import com.sc.ink.Ink;
import com.sc.paper.Paper;

public class Printer {

	//�����ں�,ֽ��
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
		System.out.println("������ʹ��" + ink.color() + "��ī�У���" + paper.size() + "��ֽ�Ŵ�ӡ�ļ�");
	}
}
