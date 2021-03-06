package com.jst.framework.common.exception;

public class SendRefuseException
  extends SystemException
{
  public SendRefuseException(String msg)
  {
    super(msg);
  }
  
  public SendRefuseException(String code, String msg)
  {
    super(msg);
    this.code = code;
  }
  
  public SendRefuseException(String msg, Throwable t)
  {
    super(msg, t);
    setStackTrace(t.getStackTrace());
  }
  
  public SendRefuseException(String code, String msg, Throwable t)
  {
    super(msg, t);
    this.code = code;
    setStackTrace(t.getStackTrace());
  }
}
