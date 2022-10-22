package com.pwcForms.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.pwcForms.pojo.Form;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends CosmosRepository<Form, String> {


}
