package com.pxample.pemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PemoController {

    @GetMapping("")
    public String pemodefault(@RequestParam(value = "customdefaultstr", defaultValue = "PefaultPage") String customdefaultstr) {
        return String.format("This is %s~", customdefaultstr);
    }

    @GetMapping("/pemohello")
    public String pemohello(@RequestParam(value = "name", defaultValue = "PemoWorld") String name) {
        return String.format("Hello %s~", name);
    }

}
