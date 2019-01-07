package com.wisely.jpa.dao;

import com.wisely.jpa.domain.Person;
import com.wisely.jpa.util.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
  * 定义数据访问层
  *
  * @author  作者信息
  * @date 2018-12-26
  */
@Repository
public interface PersonRepository extends CustomRepository<Person,Long> {

    //使用方法名查询
    List<Person> findByAddress(String address);

    //使用方法名查询
    Person findByNameAndAddress(String name,String address);

    //使用@Query查询，参数按照名称绑定
    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name")String name,
                                   @Param("address")String address);

    //使用@NamedQuery查询，在实体类中做的@NamedQuery定义
    Person withNameAndAddressNamedQuery(String name,String address);
}
