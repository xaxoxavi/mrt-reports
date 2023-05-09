package com.mistertransfer.reports.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReceiptData {

    private String receiptNumber;
    private String datePaid;
    private String locataList;
    private String amount;
    private String currency;

}
