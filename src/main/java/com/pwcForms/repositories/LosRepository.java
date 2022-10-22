package com.pwcForms.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.pwcForms.pojo.Los;
import org.springframework.stereotype.Repository;

@Repository
public interface LosRepository extends CosmosRepository<Los, String> {

}

