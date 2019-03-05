package com.qh.springbootredissession.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qh
 * @Date: 2019/3/5 10:10
 * @Description:
 */
@RestController
@RequestMapping(value = "/admin/v1/")
public class HomeController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public Map<String, Object> index(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("request url", request.getRequestURL());
        map.put("request url", request.getRequestURL());
        return map;
    }

    @RequestMapping(value = "sessions", method = RequestMethod.GET)
    public Object sessions(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("request url"));
        return map;
    }
}
