package com.jst.framework.common.exception;

public class SystemException
  extends JstException
{
  private static final long serialVersionUID = 4712034900235857634L;
  
  public SystemException(String msg)
  {
    super(msg);
  }
  
  public SystemException(String code, String msg)
  {
    super(msg);
    this.code = code;
  }
  
  public SystemException(String msg, Throwable t)
  {
    super(msg, t);
    setStackTrace(t.getStackTrace());
  }
  
  public SystemException(String code, String msg, Throwable t)
  {
    super(msg, t);
    this.code = code;
    setStackTrace(t.getStackTrace());
  }
}
