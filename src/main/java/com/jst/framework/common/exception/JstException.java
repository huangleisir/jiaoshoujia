package com.jst.framework.common.exception;

import com.jst.framework.common.enums.ReturnCodeEnum;

public class JstException
  extends Exception
{
  private static final long serialVersionUID = 4712034900235857634L;
  protected String code;
  
  public JstException(String msg)
  {
    super(msg);
    this.code = ReturnCodeEnum.SYSTEM_UNKNOWN_ERROR.getCode();
  }
  
  public JstException(String code, String msg)
  {
    super(msg);
    this.code = code;
  }
  
  public JstException(String msg, Throwable t)
  {
    super(msg, t);
    this.code = ReturnCodeEnum.SYSTEM_UNKNOWN_ERROR.getCode();
    setStackTrace(t.getStackTrace());
  }
  
  public JstException(String code, String msg, Throwable t)
  {
    super(msg, t);
    this.code = code;
    setStackTrace(t.getStackTrace());
  }
  
  public String getCode()
  {
    return this.code;
  }
}
