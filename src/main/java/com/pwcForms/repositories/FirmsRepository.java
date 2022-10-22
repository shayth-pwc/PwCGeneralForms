package com.pwcForms.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.pwcForms.pojo.Firms;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmsRepository extends CosmosRepository<Firms, String> {

}

