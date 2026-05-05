import java.util.*;
import java.io.*;
class Stock {
    private String symbol;
    private double price;
    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
public String getSymbol() {
        return symbol;
    } public double getPrice() {
        return price;
    } public void setPrice(double price){
        this.price = price;
    }
} class Transaction {
    private String type;
    private String symbol;
    private int quantity;
    private double price;
public Transaction(String type, String symbol, int quantity, double price){
    this.type=type; 
    this.symbol=symbol; 
    this.quantity=quantity; 
    this.price=price;
    } 
 @Override 
public String toString() {
    return type + "." + symbol + ". Quantity: " + quantity + ". Price: " +price;
    }
} class Portfolio{
    private HashMap <String, Integer> holdings;
    public Portfolio(){
        holdings = new HashMap<>();}

public void addStock(String symbol, int quantity){
    holdings.put(symbol,
        holdings.getOrDefault(symbol,0)+quantity); 

} public void removeStock(String symbol, int quantity){
    int current = holdings.get(symbol);
    if(current == quantity) {
        holdings.remove(symbol);
    } else {
        holdings.put(symbol, current - quantity);
    }
} public HashMap <String, Integer> getHoldings(){
    return holdings;
} public void displayPortfolio(HashMap<String, Stock> market) {
    System.out.println(" PORTFOLIO ");
    double total = 0; 
    for (String symbol: holdings.keySet()) {
        int quantity = holdings.get(symbol);
        double stockPrice = market.get(symbol).getPrice();
        double value = quantity * stockPrice;
        total += value;
    System.out.println(symbol + ". Shares: " + quantity + 
              "Current Price: " + stockPrice + "Value: " + value);
} System.out.println("Total Portfolio Value: " +total);
    }
} 
