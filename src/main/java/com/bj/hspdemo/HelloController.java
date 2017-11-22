package com.bj.hspdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    //自定义配置方法1
    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;

    @Value("${content}")
    private String content;

    //自定义配置方法2
    @Autowired
    private PersonProperties personProperties;

    @GetMapping("/hello")
    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String say(@RequestParam(value = "id",required = false, defaultValue = "0") Integer id) {
        //方法1
        //return name+"--"+age+"--"+content;
        //方法2
        return personProperties.getName()+"=="+personProperties.getAge()+"ID:"+id;
    }


}
