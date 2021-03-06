package com.jst.framework.common.exception;

public class MsgCheckClassCaseException
  extends MsgCheckException
{
  private static final long serialVersionUID = 4712034900235857634L;
  
  public MsgCheckClassCaseException(String msg)
  {
    super(msg);
  }
  
  public MsgCheckClassCaseException(String code, String msg)
  {
    super(msg);
    this.code = code;
  }
  
  public MsgCheckClassCaseException(String msg, Throwable t)
  {
    super(msg, t);
    setStackTrace(t.getStackTrace());
  }
  
  public MsgCheckClassCaseException(String code, String msg, Throwable t)
  {
    super(msg, t);
    this.code = code;
    setStackTrace(t.getStackTrace());
  }
}
