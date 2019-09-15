package com.api.external.http.clients.zakupki.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tender {

    private String organization;
    private String tillDate;
    private String signViewUrl;
    private String provider;
    private List<LotItem> lotItems;

    public Tender(String organization, String tillDate, List<LotItem> lotItems) {
        this.organization = organization;
        this.tillDate = tillDate;
        this.lotItems = lotItems;
    }

    public Tender() {
    }

    public String getOrganization() {
        return organization;
    }

    public String getTillDate() {
        return tillDate;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setTillDate(String tillDate) {
        this.tillDate = tillDate;
    }

    public List<LotItem> getLotItems() {
        return lotItems;
    }

    public void setLotItem(List<LotItem> lotItems) {
        this.lotItems = lotItems;
    }

    public String getSignViewUrl() {
        return signViewUrl;
    }

    public void setSignViewUrl(String signViewUrl) {
        this.signViewUrl = signViewUrl;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setLotItems(List<LotItem> lotItems) {
        this.lotItems = lotItems;
    }
}
