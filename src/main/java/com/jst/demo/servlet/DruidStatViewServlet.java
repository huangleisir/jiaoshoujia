package com.jst.demo.servlet;

import com.alibaba.druid.support.http.StatViewServlet;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/druid/*"}, initParams={@javax.servlet.annotation.WebInitParam(name="allow", value="10.101.90.47,127.0.0.1,10.101.130.8,10.101.130.9,10.101.130.32,10.101.130.36"), @javax.servlet.annotation.WebInitParam(name="deny", value="10.101.130.5"), @javax.servlet.annotation.WebInitParam(name="loginUsername", value="root"), @javax.servlet.annotation.WebInitParam(name="loginPassword", value="root"), @javax.servlet.annotation.WebInitParam(name="resetEnable", value="false")})
public class DruidStatViewServlet
  extends StatViewServlet
{
  private static final long serialVersionUID = 1L;
}
