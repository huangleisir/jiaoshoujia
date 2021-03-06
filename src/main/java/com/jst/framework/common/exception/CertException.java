package com.jst.framework.common.exception;

public class CertException
  extends BusinessException
{
  private static final long serialVersionUID = 4712034900235857634L;
  
  public CertException(String msg)
  {
    super(msg);
  }
  
  public CertException(String msg, Throwable t)
  {
    super(msg, t);
    
    setStackTrace(t.getStackTrace());
  }
}
