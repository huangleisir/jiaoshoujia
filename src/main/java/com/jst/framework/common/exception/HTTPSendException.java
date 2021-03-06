package com.jst.framework.common.exception;

public class HTTPSendException
  extends SystemException
{
  private static final long serialVersionUID = 4712034900235857634L;
  
  public HTTPSendException(String msg)
  {
    super(msg);
  }
  
  public HTTPSendException(String code, String msg)
  {
    super(msg);
    this.code = code;
  }
  
  public HTTPSendException(String msg, Throwable t)
  {
    super(msg, t);
    setStackTrace(t.getStackTrace());
  }
  
  public HTTPSendException(String code, String msg, Throwable t)
  {
    super(msg, t);
    this.code = code;
    setStackTrace(t.getStackTrace());
  }
}
