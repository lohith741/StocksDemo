package com.mphase.stocksDemo.model;

public class RequestData {
	
	private String day;
		
	private String from;
	
	private String to;
	
	private String aggregateType;
	
	public Double openPrice;
	
	public Double highPrice;
	
	public Double lowPrice;
	
	public Double closePrice;
	
	public int shares;
	
	public int trades;
	
	public Double turnOver;
	
	public Double getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(Double turnOver) {
		this.turnOver = turnOver;
	}

	public int getShares() {
		return shares;
	}

	public int getTrades() {
		return trades;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public void setTrades(int trades) {
		this.trades = trades;
	}

	public Double getOpenPrice() {
		return openPrice;
	}

	public Double getHighPrice() {
		return highPrice;
	}

	public Double getLowPrice() {
		return lowPrice;
	}

	public Double getClosePrice() {
		return closePrice;
	}

	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}

	public void setHighPrice(Double highPrice) {
		this.highPrice = highPrice;
	}

	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getAggregateType() {
		return aggregateType;
	}

	public void setAggregateType(String aggregateType) {
		this.aggregateType = aggregateType;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
