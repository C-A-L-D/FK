package com.sc.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class TestMD5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��һ�ַ�ʽ
									//���룬�Σ���������
		Md5Hash md5 = new Md5Hash("123", "qwerty", 3);
		System.out.println("����123���ܺ�����룺" + md5.toString());
		
		//�ڶ��ַ�ʽ
		SimpleHash sh = new SimpleHash("md5", "123", "qwerty", 3);
		System.out.println(sh.toString());
	}

}
