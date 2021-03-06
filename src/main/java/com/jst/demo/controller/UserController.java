package com.jst.demo.controller;

import com.jst.demo.bo.UserBo;
import com.jst.framework.common.bean.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api("首页信息接口")
@RestController
@RequestMapping({"/user"})
public class UserController
  extends BaseController
{
  private static final Logger log = LoggerFactory.getLogger(UserController.class);
  @Resource
  private com.jst.demo.dao.test.UserDao userDao;
  @Resource
  private com.jst.demo.dao.test1.UserDao userDao1;
  
  @ApiOperation(value="用户登录", notes="http://127.0.0.1:8866/demo/swagger-ui.html")
  @ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name="SESSIONNO", value="登录的SESSIONNO", required=true, paramType="header", dataType="String")})
  @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Result info(@ApiParam(name="UserBo", value="登录bean", required=true) @RequestBody UserBo userBo)
  {
    Result result = new Result();
    return result;
  }
  
  @RequestMapping(value={"/test"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public Result test(HttpServletRequest request, HttpServletResponse response)
  {
    Result result = new Result();
    log.info("=================操作接口开始，【入参={}】");
    result.setData(this.userDao.selectAll());
    return result;
  }
  
  @RequestMapping(value={"/test1"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public Result test1(HttpServletRequest request, HttpServletResponse response)
  {
    Result result = new Result();
    log.info("=================操作接口开始，【入参={}】");
    result.setData(this.userDao1.selectAll());
    return result;
  }
}
