package com.api.services.impl;

import com.api.external.http.clients.zakupki.ZakupkiHttpClient;
import com.api.external.http.clients.zakupki.dto.Tender;
import com.api.services.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TenderServiceImpl implements TenderService {

    private ZakupkiHttpClient zakupkiHttpClient;

    @Autowired
    public TenderServiceImpl(ZakupkiHttpClient zakupkiHttpClient) {
        this.zakupkiHttpClient = zakupkiHttpClient;
    }

    @Override
    public List<Tender> getTenders() throws IOException {
        return this.zakupkiHttpClient.getTenders();
    }
}
