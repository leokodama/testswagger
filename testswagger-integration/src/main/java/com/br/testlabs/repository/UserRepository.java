package com.br.testlabs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.testlabs.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

    User findById(@Param("id") long id);
}
