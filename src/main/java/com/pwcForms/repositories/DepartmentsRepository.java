package com.pwcForms.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.pwcForms.pojo.Departments;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentsRepository extends CosmosRepository<Departments, String> {


}
