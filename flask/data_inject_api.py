import json
from flask import Flask,request,jsonify
import pandas as pd
# from flask_cors import CORS, cross_origin

app = Flask(__name__)

# cors = CORS(app)
# app.config['CORS_HEADERS'] = 'Content-Type'
from pymongo import MongoClient


def connect_db(host='localhost',port=27017):
    try:
        conn = MongoClient(host,port)
        print("Connected successfully!!!")
    except:
        print("Could not connect to MongoDB")
    db = conn.stocks_db

    return db


def insert_documents(collection,doc):
    try:
        collection.insert_many(doc)
    except Exception as e:
        print('Failed to insert',e)
        pass


@app.route('/get_req', methods=['GET','POST'])
def get_req():
    db = connect_db()

    data = pd.read_csv('./500285.csv') #.to_dict(orient='records')
    data['Date'] =  pd.to_datetime(data['Date'])
    renamed_cols = {
    "Date":"date",
    "Open Price":"openPrice",
    "High Price":"highPrice",
    "Low Price":"lowPrice",
    "Close Price":"closePrice",
    "WAP":"wap",
    "No.of Shares":"shares",
    "No. of Trades":"trades",
    "Total Turnover (Rs.)":"turnOver",
    "Deliverable Quantity":"delQty",
    "% Deli. Qty to Traded Qty":"tradedQty",
    "Spread High-Low":"spreadHL",
    "Spread Close-Open":"spreadCO",
    }
    data.rename(columns=renamed_cols,inplace=True)
    collection = db.stocks
    # for row in data:

    insert_documents(collection,data.to_dict(orient='records'))
        # cursor = collection.find()
        # for rec in cursor:
        #     print(rec)
    return 'Inserted successfully'


if __name__ == "__main__":
    app.run(debug=True)

# get_req()
