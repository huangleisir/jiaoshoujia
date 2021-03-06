package com.jst.demo.controller;

import com.jst.demo.bean.LoginBean;
import com.jst.demo.bean.ResultBean;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/mem"})
public class StandardRestController
{
  private final Logger log = LoggerFactory.getLogger(StandardRestController.class);
  @Autowired
  private Environment config;
  //http://localhost:8866/demo/mem/login/1234/23423
  @RequestMapping(value={"/login/{v1}/{v2}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  private Object login(LoginBean loginBean, @PathVariable("v1") String value1, @PathVariable("v2") String value2)
  {
    HashMap dataMap = new HashMap();
    dataMap.put("v1", value1);
    dataMap.put("v2", value2);
    ResultBean result = new ResultBean("00", "success", dataMap);
    this.log.info(this.config.getProperty("self.company.name"));
    return result;
  }
}
