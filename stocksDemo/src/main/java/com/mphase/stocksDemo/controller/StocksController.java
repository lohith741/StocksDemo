package com.mphase.stocksDemo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphase.stocksDemo.model.AggregatedData;
import com.mphase.stocksDemo.model.RequestData;
import com.mphase.stocksDemo.model.Stocks;
import com.mphase.stocksDemo.repository.StocksRepository;
import com.mphase.stocksDemo.service.StockService;


@RestController
@RequestMapping("/stocks")
public class StocksController {

	@Autowired
	StockService stockService;
	
	@Autowired
	StocksRepository stocksRepository;
	
	@RequestMapping("/getAll")
	public List<Stocks> getAll(){
		List<Stocks> stocks=stockService.getAll();
		return stocks;
	}

	@RequestMapping(value = "/timeRange", method = RequestMethod.POST)
	public List<Stocks> getByDate(@Valid @RequestBody RequestData data) throws ParseException{
		if(data.getDay()==null && data.getFrom()==null ){	
	        return null;
		}
		return stockService.getByDates(data);
	}
	
	
	@RequestMapping(value = "/aggregate", method = RequestMethod.POST)
	public Map<String,AggregatedData> getAggregateByMonth(@Valid @RequestBody RequestData data) throws ParseException{
		return stockService.getAggregateByMonth(data);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public AggregatedData updateStock(@Valid @RequestBody RequestData data) throws ParseException{
		
		List<Stocks> stockdb = stockService.getByDates(data);
		Stocks stock = new Stocks();
		if(stockdb != null){
			stock = stockdb.get(0);
		}
		else{
			Date date=new SimpleDateFormat("MM/dd/yyyy").parse(data.getDay());
			stock.setDate(date);
		}
		if(data.getClosePrice()!=null){
			stock.setClosePrice(data.getClosePrice());
		}
		if(data.getHighPrice()!=null){
			stock.setHighPrice(data.getHighPrice());
				}
		if(data.getLowPrice()!=null){
			stock.setLowPrice(data.getLowPrice());
		}
		if(data.getOpenPrice()!=null){
			stock.setOpenPrice(data.getOpenPrice());
		}
		if(data.getShares() != 0){
			stock.setShares(data.getShares());
		}
		if(data.getTrades()!=0){
			stock.setTrades(data.getTrades());
		}
		if(data.getTurnOver()!=null){
			stock.setTurnOver(data.getTurnOver());
		}
		
		stocksRepository.save(stock);
		AggregatedData responseData = stockService.setResponse(stock);
		return responseData;
	}
	
}
