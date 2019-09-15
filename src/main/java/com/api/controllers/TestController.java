package com.api.controllers;

import com.api.services.TenderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@CrossOrigin
public class TestController {

    private TenderService tenderService;

    private ObjectMapper objectMapper;

    @Autowired
    public TestController(TenderService tenderService, ObjectMapper objectMapper) {
        this.tenderService = tenderService;
        this.objectMapper = objectMapper;
    }

    @RequestMapping("/")
    @ResponseBody
    public String getTenders(@RequestParam(value = "okpdId") String okpdId) throws IOException {
        return objectMapper.writeValueAsString(tenderService.getTenders(okpdId));
    }
}
