package com.mistertransfer.reports.domain;

public class ReceiptData {
    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }

    public String getLocataList() {
        return locataList;
    }

    public void setLocataList(String locataList) {
        this.locataList = locataList;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    private String receiptNumber;
    private String datePaid;
    private String locataList;
    private String amount;
    private String currency;
}
