package com.jst.framework.common.exception;

public class NetworkException
  extends SystemException
{
  private static final long serialVersionUID = 4712034900235857634L;
  
  public NetworkException(String msg)
  {
    super(msg);
  }
  
  public NetworkException(String code, String msg)
  {
    super(msg);
    this.code = code;
  }
  
  public NetworkException(String msg, Throwable t)
  {
    super(msg, t);
    setStackTrace(t.getStackTrace());
  }
  
  public NetworkException(String code, String msg, Throwable t)
  {
    super(msg, t);
    this.code = code;
    setStackTrace(t.getStackTrace());
  }
}
