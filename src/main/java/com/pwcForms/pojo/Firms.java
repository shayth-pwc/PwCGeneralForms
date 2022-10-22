package com.pwcForms.pojo;

import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

public class Firms {
    @Id
    @PartitionKey
    private String slugFirm;

    private String firmName;

    private String slugCountry;

    private boolean active;


    public String getSlugFirm() {
        return slugFirm;
    }

    public void setSlugFirm(String slugFirm) {
        this.slugFirm = slugFirm;
    }

    public String getFirmName() {
        return firmName;
    }


    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getSlugCountry() {
        return slugCountry;
    }


    public void setSlugCountry(String slugCountry) {
        this.slugCountry = slugCountry;
    }


    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }


}
