package com.pwcForms.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.pwcForms.pojo.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CosmosRepository<Users, String> {

}

