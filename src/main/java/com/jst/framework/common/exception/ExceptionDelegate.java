package com.jst.framework.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionDelegate
{
  private static final Logger log = LoggerFactory.getLogger(ExceptionDelegate.class);
  private ExceptionHandler eh;
  
  public ExceptionDelegate(ExceptionHandler eh)
  {
    this.eh = eh;
  }
  
  public void handle(Throwable e)
  {
    if ((e instanceof Exception)) {
      handleBizException((Exception)e);
    } else {
      log.error("系统捕获到一个未知异常", e);
    }
  }
  
  private void handleBizException(Exception e)
  {
    if ((e instanceof JstException)) {
      this.eh.handle((JstException)e);
    } else {
      log.error("系统发生异常", e);
    }
  }
}
