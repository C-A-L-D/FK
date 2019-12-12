package com.sc.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class TestMD5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//第一种方式
									//密码，盐，迭代次数
		Md5Hash md5 = new Md5Hash("123", "qwerty", 3);
		System.out.println("密码123加密后的密码：" + md5.toString());
		
		//第二种方式
		SimpleHash sh = new SimpleHash("md5", "123", "qwerty", 3);
		System.out.println(sh.toString());
	}

}
