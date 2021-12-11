package com.dime.thema;

import org.springframework.data.repository.CrudRepository;

public interface IdentityRepository extends CrudRepository<Theme, String> {

    Theme findThemaIdentityById(Long id);

    Theme findThemaIdentityByName(String name);
}
