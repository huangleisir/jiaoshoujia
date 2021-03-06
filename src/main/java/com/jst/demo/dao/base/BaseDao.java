package com.jst.demo.dao.base;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jst.demo.bean.BaseBean;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDao
  extends SqlSessionDaoSupport
{
  private static Logger log = LoggerFactory.getLogger(BaseDao.class);
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
  {
    super.setSqlSessionFactory(sqlSessionFactory);
  }
  
  public <T> T getById(String key, Serializable id)
  {
    long beginTime = System.currentTimeMillis();
    log.info("=================开始请求执行数据库，【入参={}】", new Object[] { "key = " + key + " , id = " + id });
    T t = getSqlSession().selectOne(key, id);
    log.info("=================结束请求执行数据库，【耗时={}】，【返回数据={}】", new Object[] { Long.valueOf(System.currentTimeMillis() - beginTime), 
      JSON.toJSONString(t) });
    return t;
  }
  
  public int insert(String key, Object params)
  {
    long beginTime = System.currentTimeMillis();
    log.info("=================开始请求执行数据库，【入参={}】", new Object[] { "key = " + key + " , params = " + JSON.toJSONString(params) });
    int t = getSqlSession().insert(key, params);
    log.info("=================结束请求执行数据库，【耗时={}】，【返回数据={}】", new Object[] { Long.valueOf(System.currentTimeMillis() - beginTime), Integer.valueOf(t) });
    return t;
  }
  
  public int update(String key, Object params)
  {
    long beginTime = System.currentTimeMillis();
    log.info("=================开始请求执行数据库，【入参={}】", new Object[] { "key = " + key + " , params = " + JSON.toJSONString(params) });
    int t = getSqlSession().update(key, params);
    log.info("=================结束请求执行数据库，【耗时={}】，【返回数据={}】", new Object[] { Long.valueOf(System.currentTimeMillis() - beginTime), Integer.valueOf(t) });
    return t;
  }
  
  public <T> T getOne(String key, Object params)
  {
    long beginTime = System.currentTimeMillis();
    log.info("=================开始请求执行数据库，【入参={}】", new Object[] { "key = " + key + " , params = " + JSON.toJSONString(params) });
    T t = getSqlSession().selectOne(key, params);
    log.info("=================结束请求执行数据库，【耗时={}】，【返回数据={}】", new Object[] { Long.valueOf(System.currentTimeMillis() - beginTime), 
      JSON.toJSONString(t) });
    return t;
  }
  
  public <T> List<T> getList(String key, Object params)
  {
    long beginTime = System.currentTimeMillis();
    log.info("=================开始请求执行数据库，【入参={}】", new Object[] { "key = " + key + " , params = " + JSON.toJSONString(params) });
    List<T> t = getSqlSession().selectList(key, params);
    log.info("=================结束请求执行数据库，【耗时={}】，【返回数据={}】", new Object[] { Long.valueOf(System.currentTimeMillis() - beginTime), 
      JSON.toJSONString(t) });
    return t;
  }
  
  public <T> List<T> getList(String key)
  {
    long beginTime = System.currentTimeMillis();
    log.info("=================开始请求执行数据库，【入参={}】", new Object[] { "key = " + key });
    List<T> t = getSqlSession().selectList(key);
    log.info("=================结束请求执行数据库，【耗时={}】，【返回数据={}】", new Object[] { Long.valueOf(System.currentTimeMillis() - beginTime), 
      JSON.toJSONString(t) });
    return t;
  }
  
  public int delete(String key, Serializable id)
  {
    long beginTime = System.currentTimeMillis();
    log.info("=================开始请求执行数据库，【入参={}】", new Object[] { "key = " + key + " , id = " + id });
    int t = getSqlSession().delete(key, id);
    log.info("=================结束请求执行数据库，【耗时={}】，【返回数据={}】", new Object[] { Long.valueOf(System.currentTimeMillis() - beginTime), Integer.valueOf(t) });
    return t;
  }
  
  public int deleteByParams(String key, Object params)
  {
    long beginTime = System.currentTimeMillis();
    log.info("=================开始请求执行数据库，【入参={}】", new Object[] { "key = " + key + " , params = " + JSON.toJSONString(params) });
    int t = getSqlSession().delete(key, params);
    log.info("=================结束请求执行数据库，【耗时={}】，【返回数据={}】", new Object[] { Long.valueOf(System.currentTimeMillis() - beginTime), Integer.valueOf(t) });
    return t;
  }
  
  public <T> PageInfo<T> getPage(String statementId, Page pageInfo, Object param)
  {
    long beginTime = System.currentTimeMillis();
    log.info("=================开始请求执行数据库，【入参={}】", new Object[] { "statementId = " + statementId + " , pageInfo = " + JSON.toJSONString(pageInfo) + " , param = " + JSON.toJSONString(param) });
    PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
    PageInfo<T> page = new PageInfo(getSqlSession().selectList(statementId, param));
    log.info("=================结束请求执行数据库，【耗时={}】，【返回数据={}】", new Object[] { Long.valueOf(System.currentTimeMillis() - beginTime), 
      JSON.toJSONString(page) });
    return page;
  }
  
  public <T> PageInfo<T> getPage(String statementId, BaseBean baseBean)
  {
    long beginTime = System.currentTimeMillis();
    log.info("=================开始请求执行数据库，【入参={}】", new Object[] { "statementId = " + statementId + " , baseBean = " + JSON.toJSONString(baseBean) });
    PageHelper.startPage(baseBean.getCurrentPage().intValue(), baseBean.getPageSize());
    PageInfo<T> page = new PageInfo(getSqlSession().selectList(statementId, baseBean));
    log.info("=================结束请求执行数据库，【耗时={}】，【返回数据={}】", new Object[] { Long.valueOf(System.currentTimeMillis() - beginTime), 
      JSON.toJSONString(page) });
    return page;
  }
}
