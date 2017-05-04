package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by oleksandr.kushnir on 01.05.2017.
 */

@RestController
public class ExampleController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printServicesInfo() {
        List<ServiceInstance> instanceList = discoveryClient.getInstances("demo-service-application");
        if (instanceList != null) {
            for (int i = 0; i < instanceList.size(); i++) {
                System.out.println("Available Service Instance # "+i);
                System.out.println("Service host: "+ instanceList.get(i).getHost());
                System.out.println("Service port: "+ instanceList.get(i).getPort());
                System.out.println("Service URI:" +instanceList.get(i).getUri());
                System.out.println("Service Metadata:" +instanceList.get(i).getUri());
            }
        }
        return "success";
    }



}
