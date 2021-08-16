package com.zipcoder.cryptonator_api.services;

import com.zipcoder.cryptonator_api.domain.Foo;
import com.zipcoder.cryptonator_api.repositories.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by leon on 1/22/18.
 */
@Service
public class FooService {

    @Autowired
    private FooRepository repo;

    public Foo create(Foo crypto) {
        return null;
    }
}
