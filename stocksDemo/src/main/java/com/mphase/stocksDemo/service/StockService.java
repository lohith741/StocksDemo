package com.mphase.stocksDemo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mphase.stocksDemo.model.AggregatedData;
import com.mphase.stocksDemo.model.RequestData;
import com.mphase.stocksDemo.model.Stocks;
import com.mphase.stocksDemo.repository.StocksRepository;

@Service
public class StockService {

	@Autowired
	StocksRepository stocksRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	//Retrieve operation
	public List<Stocks> getAll(){
		return stocksRepository.findAll();
	}


	public List<Stocks> getByDates(RequestData data) throws ParseException{
			Date date1;
			Date date2;
			
			if(data.getDay()!=null){
				 date1=new SimpleDateFormat("MM/dd/yyyy").parse(data.getDay());
					Calendar c = Calendar.getInstance(); 
					c.setTime(date1); 
					c.add(Calendar.DATE, 1);
					date2 = c.getTime();
			}
			else if (data.getTo()== null){
			 date1=new SimpleDateFormat("MM/dd/yyyy").parse(data.getFrom());
			 Calendar  cal = Calendar.getInstance();
			 date2 = cal.getTime();
			}
			else{
				date1=new SimpleDateFormat("MM/dd/yyyy").parse(data.getFrom());
				date2=new SimpleDateFormat("MM/dd/yyyy").parse(data.getTo());
			}
			Query query = new Query();
			query.addCriteria(Criteria.where("date").lt(date2).gt(date1));
			List<Stocks> stocks = mongoTemplate.find(query, Stocks.class);

			return stocks;
	}
	
	
	
	public  Map<String,AggregatedData> getAggregateByMonth(RequestData date) throws ParseException{
		
		List<Stocks> stocks = getByDates(date);
		Map<String,AggregatedData> map= aggregate(stocks,date.getAggregateType());
		return map;
}
	
	public Map<String,AggregatedData> aggregate(List<Stocks> stocks,String aggregateType){
		Map<String,AggregatedData> map=new HashMap<String,AggregatedData>();
		String key= "";
		for(Stocks stock :stocks){
			String valueKey=getByType(aggregateType, stock.getDate());
			if(key.equals(valueKey)){
				AggregatedData stockValue=map.get(key);
				stockValue.setHighPrice(Math.max(stockValue.getHighPrice(),stock.getHighPrice()));
				stockValue.setLowPrice(Math.min(stockValue.getLowPrice(),stock.getLowPrice()));
				stockValue.setClosePrice(stock.getClosePrice());
				stockValue.setShares(stockValue.getShares()+stock.getShares());
				map.put(key, stockValue);
			}
			else{
//				if(key != null){
//					AggregatedData stockValue=map.get(key);
//					map.put(key, stockValue);
//				}
				key = valueKey;
				AggregatedData aggregatedData=new AggregatedData(stock);
				map.put(key, aggregatedData);
			}
			
		}
		
		return map;	
	}
	
	public String getByType(String type,Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week = cal.get(Calendar.WEEK_OF_MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		
		switch(type){
			case "week":
				return "week-"+Integer.toString(week)+":"+Integer.toString(month +1)+"-"+Integer.toString(year);
			case "month":
				return "month-" + Integer.toString(month +1)+":"+Integer.toString(year);
		}
		return Integer.toString(day)+"-"+Integer.toString(month +1)+"-"+Integer.toString(year);

			
	}
	
	public AggregatedData setResponse(Stocks stock){
		AggregatedData data = new AggregatedData();
		data.setClosePrice(stock .getClosePrice());
		data.setOpenPrice(stock.getOpenPrice());
		data.setHighPrice(stock.getHighPrice());
		data.setLowPrice(stock.getLowPrice());
		data.setShares(stock.getShares());
		data.setTrades(stock.getTrades());
		data.setTurnOver(stock.getTurnOver());
		return data;
	}
}
