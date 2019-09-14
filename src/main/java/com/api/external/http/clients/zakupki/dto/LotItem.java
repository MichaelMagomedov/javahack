package com.api.external.http.clients.zakupki.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LotItem {
    private String name;
    private String firstPrice;

    public LotItem() {
    }

    public LotItem(String name, String firstPrice) {
        this.name = name;
        this.firstPrice = firstPrice;
    }

    public String getName() {
        return name;
    }

    public String getFirstPrice() {
        return firstPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstPrice(String firstPrice) {
        this.firstPrice = firstPrice;
    }
}
