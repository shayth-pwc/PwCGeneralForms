package com.pwcForms.pojo;

import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

public class Countries {
    @Id
    @PartitionKey
    private String slugCountry;

    private String countryName;

    private String countryCode;

   private boolean active;

    public String getSlugCountry() {
        return slugCountry;
    }

    public void setSlugCountry(String slugCountry) {
        this.slugCountry = slugCountry;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }



}
