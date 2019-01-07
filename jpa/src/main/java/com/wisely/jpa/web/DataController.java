package com.wisely.jpa.web;

import com.wisely.jpa.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wisely.jpa.dao.PersonRepository;


/**
  * 控制器
  *
  * @author  changzhenzhen
  * @date 2018-12-26
  */
@RestController
public class DataController {


   /* @RequestMapping("/save")
    public Person save(String name,Integer age,String address){
        Person p = personRepository.save(new Person(null,name,age,address));
        return p;
    }

    @RequestMapping("/findByAddress")
    public List<Person> findByAddress(String address){
        List<Person> people = personRepository.findByAddress(address);
        return people;
    }

    @RequestMapping("/findByNameAndAddress")
    public Person findByNameAndAddress(String name,String address){
        Person person = personRepository.findByNameAndAddress(name,address);
        return person;
    }

    @RequestMapping("/withNameAndAddressQuery")
    public Person withNameAndAddressQuery(String name,String address){
        Person person = personRepository.withNameAndAddressQuery(name,address);
        return person;
    }

    @RequestMapping("/withNameAndAddressNamedQuery")
    public Person withNameAndAddressNamedQuery(String name,String address){
        Person person = personRepository.withNameAndAddressNamedQuery(name,address);
        return person;
    }

    @RequestMapping("/sort")
    public List<Person> sort(){
        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
        return people;
    }

    @RequestMapping("/page")
    public Page<Person> page(){
        Page<Person> pagePeople = personRepository.findAll(new PageRequest(1,3));
        return pagePeople;
    }*/

    @GetMapping("/auto")
    public Page<Person> auto(Person person){
        Page<Person> pagePeople = PersonRepository.findByAuto(person,new PageRequest(0,5));
        return pagePeople;
    }

}
