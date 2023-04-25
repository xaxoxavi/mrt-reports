package com.mistertransfer.reports;

import com.fasterxml.jackson.core.JsonParser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
public class ReportController {

    @PostMapping("/generate")
    public String generateTemplate(@RequestBody String json) {
        JsonObject data = JsonParser.parse(json).getAsJsonObject();
        String title = data.get("title").getAsString();
        String message = data.get("message").getAsString();

        Context context = new Context();
        context.setVariable("title", title);
        context.setVariable("message", message);

        String html = new TemplateEngine().process("template", context);

        return html;
    }

}
