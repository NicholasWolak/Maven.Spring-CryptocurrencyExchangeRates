package com.zipcoder.cryptonator_api.services;

import com.zipcoder.cryptonator_api.domain.Foo;
import com.zipcoder.cryptonator_api.repositories.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 1/22/18.
 */
@Service
public class FooService {

    @Autowired
    private FooRepository repo;

    public Foo create(Foo crypto) {
        return repo.save(crypto);
    }

    public Foo read(String ticker) {
        return repo.findOne(ticker);
    }

    public List<Foo> readAll() {
        Iterable<Foo> fooIterable = repo.findAll();
        List<Foo> fooList = new ArrayList<>();
        fooIterable.forEach(fooList::add);
        return fooList;
    }

    public List<Foo> findAllByTarget(String target) {
        return null;
    }

    public Foo uniqueUpdate(String currentTicker, String newTicker) {
        Foo fooInDb = read(currentTicker);
        fooInDb.setBase(newTicker);
        fooInDb = repo.save(fooInDb);
        return fooInDb;
    }

    public Foo delete(String ticker) {
        Foo inDb = read(ticker);
        repo.delete(inDb);
        return inDb;
    }
}
