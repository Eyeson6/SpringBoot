package com; /**
 * @author HelloWood
 * @create 2016-11-30 22:10
 * @email hellowoodes@gmail.com
 **/

import com.mapper.UserMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class SpringController {

    private  final org.slf4j.Logger logger = LoggerFactory.getLogger(SpringController.class);

    @Value("${com.neo.title}")
    private String title;
    @Value("${com.neo.description}")
    private String description;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    @ResponseBody
    List<Integer> home() {
        System.out.println("121211123");
        logger.info("日志在这里！");
        List<Integer> list =  userMapper.getAll();
        System.out.println(list.size()+list.size());
        return list;
    }


//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(SpringController.class, args);
//    }
}

