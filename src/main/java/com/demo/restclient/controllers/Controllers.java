package com.demo.restclient.controllers;

import com.demo.restclient.clients.ObjClient;
import com.demo.restclient.dtos.Obj;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class Controllers {

    Gson gson = new Gson();

    @Resource
    ObjClient client;

    Integer attemps = 0;

    @GetMapping("/objects")
    public List<Obj> listObjects() throws Exception {
        if(attemps < 2){
            attemps++;
            throw new Exception("custom");
        }
        Obj o = new Obj("Luis", "Arenas");
        return List.of(o);
    }


    @GetMapping("/execute")
    public List<Obj> execute(){
        List<Obj> result = client.getObjs();
        return result;
    }

    @PostMapping("/api/v3/checkout/authorize")
    public List<Obj> authorize() throws InterruptedException {
//        Thread.sleep(10000);

        return Collections.emptyList();
    }

    @PostMapping("/api/mcm/products/synchronization")
    public void execute(@RequestBody Object body){
        log.debug("request: {}", gson.toJson(body));
    }
}

