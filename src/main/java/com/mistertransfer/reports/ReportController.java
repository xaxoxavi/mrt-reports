package com.mistertransfer.reports;

import com.mistertransfer.reports.domain.ReceiptData;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Controller
public class ReportController {

    @GetMapping("/generate-receipt")
    public ModelAndView generateReceipt(@RequestBody ReceiptData receiptData) {

        ModelAndView modelAndView = new ModelAndView("receipt-template");
        modelAndView.addObject("receiptNumber", receiptData.getReceiptNumber());
        modelAndView.addObject("datePaid", receiptData.getDatePaid());
        modelAndView.addObject("locataList", receiptData.getLocataList());
        modelAndView.addObject("amount", receiptData.getAmount());
        modelAndView.addObject("currency", receiptData.getCurrency());

        return modelAndView;
    }
}
