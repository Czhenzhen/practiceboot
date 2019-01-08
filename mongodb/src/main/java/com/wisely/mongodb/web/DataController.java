package com.wisely.mongodb.web;


import com.wisely.mongodb.dao.PersonRepository;
import com.wisely.mongodb.domain.Location;
import com.wisely.mongodb.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;


/**
  * /控制器
  *
  * @author  changzhenzhen
  * @date 2019-01-07
  */
@RestController
public class DataController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(){
        Person person = new Person("changzhenzhen",18);
        Collection<Location> locations = new LinkedHashSet<Location>();
        Location loc1 = new Location("天津","2016");
        Location loc2 = new Location("北京","2017");
        Location loc3 = new Location("上海","2018");
        Location loc4 = new Location("河北","2019");
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
        person.setLocations(locations);
        return personRepository.save(person);
    }

    @RequestMapping("/findByName")
    public Person findByName(String name){
        return personRepository.findByName(name);
    }

    @RequestMapping("/query")
    public List<Person> query(Integer age){
        return personRepository.withQueryFindByAge(age);
    }
}
