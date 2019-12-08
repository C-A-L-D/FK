package com.sc.service;

public interface ServiceBuy {
	
	public Double buy(String uname, String food, Double price, Double money);
	
	public void noBuy(String uname);
}
