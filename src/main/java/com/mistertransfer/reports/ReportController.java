package com.mistertransfer.reports;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.engine.TemplateData;

import java.util.Map;

@RestController
public class ReportController {

    @PostMapping("/generate/html")
    public String generateTemplate(@RequestBody TemplateData templateData) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> model = mapper.convertValue(templateData, new TypeReference<>() {});

        WebContext context = new WebContext(null, null, null);
        context.setVariables(model);
        String html = new TemplateEngine().process("receipt-mailEN.html", context);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        return html;
    }

}
