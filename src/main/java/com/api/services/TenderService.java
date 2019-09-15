package com.api.services;

import com.api.external.http.clients.zakupki.dto.Tender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface TenderService {
    public List<Tender> getTenders(String okpdId) throws IOException;
}
