package com.mistertransfer.reports.domain;

import lombok.Data;

@Data
public class ReceiptData {

    private String receiptNumber;
    private String datePaid;
    private String locataList;
    private String amount;
    private String currency;

}
