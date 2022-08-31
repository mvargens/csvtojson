package com.csvtojson.csvtojson.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class History implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long account;
    private String state;
    private String type;
    private LocalDateTime dateTime;
    private String symbol;
    private Double magicNumber;
    private Double lots;
    private Double open;
    private Double close;
    private Double profit;
    private String comment;

    public History() {}

    public History(Long account, String state, String type, LocalDateTime dateTime, String symbol, Double magicNumber,
                   Double lots, Double open, Double close, Double profit, String comment) {
        super();
        this.account = account;
        this.state = state;
        this.type = type;
        this.dateTime = dateTime;
        this.symbol = symbol;
        this.magicNumber = magicNumber;
        this.lots = lots;
        this.open = open;
        this.close = close;
        this.profit = profit;
        this.comment = comment;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(Double magicNumber) {
        this.magicNumber = magicNumber;
    }

    public Double getLots() {
        return lots;
    }

    public void setLots(Double lots) {
        this.lots = lots;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "History{" +
                "account='" + account + '\'' +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                ", dateTime=" + dateTime +
                ", symbol='" + symbol + '\'' +
                ", magicNumber=" + magicNumber +
                ", lots=" + lots +
                ", open=" + open +
                ", close=" + close +
                ", profit=" + profit +
                ", comment='" + comment + '\'' +
                '}';
    }
}
