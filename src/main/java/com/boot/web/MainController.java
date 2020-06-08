package com.boot.web;

import com.boot.service.impl.BrokerLinkService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MainController {
    @Resource
    BrokerLinkService brokerLinkService;

    @RequestMapping(value = "/")
    String home() {
    return "Hello World!";
    }

    @RequestMapping(value = "/broker/link")
    String brokerlink() {
        brokerLinkService.getBrokerLink();
        return "Hello World!";
    }
}