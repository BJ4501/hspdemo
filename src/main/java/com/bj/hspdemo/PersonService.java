package com.bj.hspdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonService {


    @Autowired
    private PersonRepository personRepository;

    //事务
    //保证要么两个都能插入，要么两个都不能插入
    @Transactional
    public void insertTwo(){
        Person p1 = new Person();
        p1.setName("ABCD");
        p1.setAge("20");
        personRepository.save(p1);

        Person p2 = new Person();
        p2.setName("DCBA");
        p2.setAge("12");
        personRepository.save(p2);


    }




}
