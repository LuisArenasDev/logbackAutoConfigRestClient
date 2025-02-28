package com.demo.restclient.clients;

import com.demo.restclient.dtos.Obj;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface ObjClient {

    @GetExchange("/objects")
    @Retryable(maxAttempts = 10, backoff = @Backoff(delay = 1000))
    public List<Obj> getObjs();

}
