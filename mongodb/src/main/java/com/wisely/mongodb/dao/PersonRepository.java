package com.wisely.mongodb.dao;
import com.wisely.mongodb.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
  * //TODO 添加类/接口功能描述
  *
  * @author  作者信息
  * @date 2019-01-07
  */
public interface PersonRepository extends MongoRepository<Person,String> {

    Person findByName(String name);

    //支持@Query查询，查询参数构造json字符串即可
    @Query("{'age':?0}")
    List<Person> withQueryFindByAge(Integer age);
}
