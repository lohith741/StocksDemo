package com.mphase.stocksDemo.model;

public class AggregatedData {

	public Double openPrice;
	
	public Double highPrice;
	
	public Double lowPrice;
	
	public Double closePrice;
	
	public int shares;
	
	public int trades;
	
	public Double turnOver;
	
	
	public AggregatedData(){
		
	}
	
	public AggregatedData(Stocks stock){
		this.openPrice=stock.getOpenPrice();
		this.lowPrice=stock.getLowPrice();
		this.highPrice=stock.getHighPrice();
		this.closePrice=stock.getClosePrice();
		this.shares=stock.getShares();
		this.trades=stock.getTrades();
		this.turnOver=stock.getTurnOver();
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

	public int getShares() {
		return shares;
	}

	public int getTrades() {
		return trades;
	}

	public Double getTurnOver() {
		return turnOver;
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

	public void setShares(int shares) {
		this.shares = shares;
	}

	public void setTrades(int trades) {
		this.trades = trades;
	}

	public void setTurnOver(Double turnOver) {
		this.turnOver = turnOver;
	}
}
