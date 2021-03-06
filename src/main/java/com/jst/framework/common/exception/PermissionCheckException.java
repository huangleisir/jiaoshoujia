package com.jst.framework.common.exception;

public class PermissionCheckException
  extends BusinessException
{
  private static final long serialVersionUID = 4712034900235857634L;
  
  public PermissionCheckException(String msg)
  {
    super(msg);
  }
  
  public PermissionCheckException(String code, String msg)
  {
    super(msg);
    this.code = code;
  }
  
  public PermissionCheckException(String msg, Throwable t)
  {
    super(msg, t);
    setStackTrace(t.getStackTrace());
  }
  
  public PermissionCheckException(String code, String msg, Throwable t)
  {
    super(msg, t);
    this.code = code;
    setStackTrace(t.getStackTrace());
  }
}
