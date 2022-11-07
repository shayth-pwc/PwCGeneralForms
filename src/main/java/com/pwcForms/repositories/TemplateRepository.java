package com.pwcForms.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.pwcForms.pojo.Template;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends CosmosRepository<Template, String> {


}
