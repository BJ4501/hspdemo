package com.bj.hspdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 查询某个员工
     * @param id
     * @return
     */
    @GetMapping(value = "/person/{id}")
    public Person personFindOne(@PathVariable("id")Integer id){
        return personRepository.findOne(id);
    }

    /**
     * 更改某个员工信息
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping(value = "/person/{id}")
    public Person personUpdate(@PathVariable("id")Integer id,
                               @RequestParam("name")String name,
                               @RequestParam("age")String age){
        Person p = new Person();
        p.setId(id);
        p.setName(name);
        p.setAge(age);

        return personRepository.save(p);
    }

    /**
     * 删除某个员工
     * @param id
     * @return
     */
    @DeleteMapping(value = "/person/{id}")
    public String personDelete(@PathVariable("id")Integer id){
        personRepository.delete(id);
        return "Delete Success";
    }

    @GetMapping(value = "/person/age/{age}")
    public List<Person> personListByAge(@PathVariable("age")String age){
        return personRepository.findByAge(age);
    }



}
