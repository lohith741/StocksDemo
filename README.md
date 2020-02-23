# stocks Spring-boot mongodb CRUD-Operations

## Database Schema

DataBase Name : stocks_db
csv: 500285.csv

### Table:
stocks:
```
Date date          
Double openPrice
Double highPrice;
Double lowPrice;
Double closePrice;
Double wap;
int shares;
Double turnOver;
Double delQty;
Double tradedQty;
Double spreadHL;
Double spreadCO;

```
Stocks Database is generated using flask.(data_inject_api.py)

## BackEnd

### API Methods Executed:
Here are few api calls executed in the back end.

1. To get all the Stocks in DataBase


> URI: localhost:8080/stocks/getAll

> Method: GET

2. To get all the stocks with time range

> URI: localhost:8080/stocks/timeRange

> Method : POST

> Body-type: JSON 
```
{
	"from" : "1/1/2019",
	"to": "1/1/2020"
}
```

3. To get all the stocks with aggregation time range

> URI: localhost:8080/stocks/aggregate

> Method: POST

> Body-type: JSON 
```
{
	"from" : "1/1/2019",
	"to":"1/1/2020",
	"aggregateType" :"month"
}
```

4. To Update Stock prices of a day

> URI: localhost:8080/stocks/update

> Method: PUT

> Body-type: JSON 
```
{
	"day":"2/1/2020",
	"openPrice" :100,
	"highPrice" :100,
	"lowPrice" :100,
	"closePrice" :100
}
```
Added all postman calls in collections file.



