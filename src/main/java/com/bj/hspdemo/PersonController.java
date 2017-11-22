package com.bj.hspdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    /**
     * 查询所有员工信息
     * @return
     */
    @GetMapping(value = "/person")
    public List<Person> personList(){
        return personRepository.findAll();
    }

    /**
     * 添加一个员工的信息
     * @param name
     * @param age
     * @return
     */
    @PostMapping(value = "/person")
    public Person personAdd(@RequestParam("name")String name,
                            @RequestParam("age")String age){
        Person p = new Person();
        p.setName(name);
        p.setAge(age);

        return personRepository.save(p);
    }



}
