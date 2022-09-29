package com.suf.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/userServiceFallback")
    public String userServiceFallback(){
        return "[CIRCUIT BREAKER - FALLBACK] User service is taking too long to respond";
    }

    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallback(){
        return "[CIRCUIT BREAKER - FALLBACK] Department service is taking too long to respond";
    }

}
