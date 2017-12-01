package com;

import com.mapper.UserMapper;
import com.mq.HelloSender;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by blues on 2017/12/1.
 */
@RestController
public class HelloWorldController {

    private  final org.slf4j.Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private HelloSender helloSender;

    @RequestMapping("/getUser")
    public Map<String,Object> getUser() {
        System.out.println("11");
        logger.info("日志不在这里！");
        List<Integer> list =  userMapper.getAll();
        System.out.println(list.size()+list.size());
        Map<String,Object> resultModel = new HashMap<String,Object>();
        resultModel.put("test",list);
        redisTemplate.opsForValue().increment("zj",2);
        System.out.println(redisTemplate.opsForValue().get("zj"));
        helloSender.send();
        return resultModel;
    }
}
