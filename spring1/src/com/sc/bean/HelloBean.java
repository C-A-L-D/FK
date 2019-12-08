package com.sc.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HelloBean {

	private String helloWorld;

	public String getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(String helloWorld) {
		this.helloWorld = helloWorld;
	}
	
	
	
	private List<String> myList = new ArrayList<String>();
	private Set<String> mySet = new HashSet<String>();
	private Map<String, String> myMap = new HashMap<String, String>();
	private Properties myPro = new Properties();

	public List<String> getMyList() {
		return myList;
	}

	public void setMyList(List<String> myList) {
		this.myList = myList;
	}

	public Set<String> getMySet() {
		return mySet;
	}

	public void setMySet(Set<String> mySet) {
		this.mySet = mySet;
	}

	public Map<String, String> getMyMap() {
		return myMap;
	}

	public void setMyMap(Map<String, String> myMap) {
		this.myMap = myMap;
	}

	public Properties getMyPro() {
		return myPro;
	}

	public void setMyPro(Properties myPro) {
		this.myPro = myPro;
	}
	
}
