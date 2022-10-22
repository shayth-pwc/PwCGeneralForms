package com.pwcForms.pojo;

import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

public class Los {

    @Id
    @PartitionKey
    private String slugLos;

    private String losName;

    private String slugCountry;

    private String slugFirm;

    private boolean active;

    public String getSlugLos() {
        return slugLos;
    }

    public void setSlugLos(String slugLos) {
        this.slugLos = slugLos;
    }


    public String getLosName() {
        return losName;
    }


    public void setLosName(String losName) {
        this.losName = losName;
    }


    public String getSlugCountry() {
        return slugCountry;
    }


    public void setSlugCountry(String slugCountry) {
        this.slugCountry = slugCountry;
    }


    public String getSlugFirm() {
        return slugFirm;
    }


    public void setSlugFirm(String slugFirm) {
        this.slugFirm = slugFirm;
    }


    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }


}
