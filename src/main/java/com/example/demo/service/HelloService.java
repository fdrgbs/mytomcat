package com.example.demo.service;


import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import com.example.demo.domain.Greeting;

@Service(timeout = 6000)
@Slf4j
public class HelloService implements IHelloService{

    @Override
    public void hello(String name) {
        log.info("have entener!");
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Greeting(1,name).toString();


        log.info("+++++++++++++++++++++++++");
    }
}
