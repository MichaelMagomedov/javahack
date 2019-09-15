package com.api.external.http.clients.zakupki;

import com.api.external.http.clients.zakupki.dto.LotItem;
import com.api.external.http.clients.zakupki.dto.Tender;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static org.apache.http.HttpHeaders.USER_AGENT;

@Component
public class ZakupkiHttpClient {

    private ObjectMapper objectMapper;

    private static final String ZAKUPKI_BASE_URL = "http://zakupki.gov.ru/api/mobile/proxy/epz/order/extendedsearch/results.html";
    @Autowired
    public ZakupkiHttpClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Tender> getTenders(String okpdId) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(
                ZAKUPKI_BASE_URL +
                        "?morphology=on" +
                        "&pageNumber=1" +
                        "&sortBy=PUBLISH_DATE" +
                        "&sortDirection=false&" +
                        "fz44=on&" +
                        "fz223=on" +
                        "&placingWaysList=KESMBO%2CAESMBO%2CZKESMBO%2CZPESMBO%2CZK504&" +
                        "regions=5277335&" +
                        "currencyId=-1&" +
                        "okpd2Ids=" + okpdId +
                        "&okpd2IdsWithNested=on"
        );
        request.addHeader("User-Agent", USER_AGENT);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return transformJsonResponseToList(result.toString());
    }

    public Tender findById(String id) {

        return null;
    }
    private List<Tender> transformJsonResponseToList(String json) throws IOException {
        JsonNode root = objectMapper.readTree(json).path("list");
        return objectMapper.readValue(root.toString(), new TypeReference<List<Tender>>(){});
    }
}
