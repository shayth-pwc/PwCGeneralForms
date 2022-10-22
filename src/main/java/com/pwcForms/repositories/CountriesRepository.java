package com.pwcForms.repositories;

import com.pwcForms.pojo.Countries;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface CountriesRepository extends CosmosRepository <Countries, String> {


}
