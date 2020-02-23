package com.mphase.stocksDemo.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("stocks")
@EntityListeners(AuditingEntityListener.class)
public class Stocks {

	public Date date;
	
	public Double openPrice;
	
	public Double highPrice;
	
	public Double lowPrice;
	
	public Double closePrice;
	
	public Double wap;
	
	public int shares;
	
	public int trades;
	
	public Double turnOver;
	
	public Double delQty;
	
	public Double tradedQty;
	
	public Double spreadHL;


	public Double spreadCO;

	public Stocks(){
		
	}


	public Date getDate() {
		return date;
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

	public Double getWap() {
		return wap;
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

	public Double getDelQty() {
		return delQty;
	}

	public Double getTradedQty() {
		return tradedQty;
	}


	public void setDate(Date date) {
		this.date = date;
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

	public void setWap(Double wap) {
		this.wap = wap;
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

	public void setDelQty(Double delQty) {
		this.delQty = delQty;
	}

	public void setTradedQty(Double tradedQty) {
		this.tradedQty = tradedQty;
	}


	
	public Double getSpreadHL() {
		return spreadHL;
	}


	public Double getSpreadCO() {
		return spreadCO;
	}


	public void setSpreadHL(Double spreadHL) {
		this.spreadHL = spreadHL;
	}


	public void setSpreadCO(Double spreadCO) {
		this.spreadCO = spreadCO;
	}
	
}
