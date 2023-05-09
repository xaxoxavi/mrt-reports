package com.mistertransfer.reports;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mistertransfer.reports.domain.ReceiptData;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;

import java.util.Map;

@RestController
public class ReportController {

    @PostMapping("/generate/html")
    public String generateTemplate(@RequestBody ReceiptData receiptData) {
        Context context = new Context();
        context.setVariable("receiptNumber", receiptData.getReceiptNumber());
        context.setVariable("datePaid", receiptData.getDatePaid());
        context.setVariable("locataList", receiptData.getLocataList());
        context.setVariable("amount", receiptData.getAmount());
        context.setVariable("currency", receiptData.getCurrency());
        String html = new TemplateEngine().process("receipt-mailEN.html", context);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        return html;
    }

}
