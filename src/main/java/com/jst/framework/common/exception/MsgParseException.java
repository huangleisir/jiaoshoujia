package com.jst.framework.common.exception;public class MsgParseException  extends BusinessException{  private static final long serialVersionUID = 4712034900235857634L;    public MsgParseException(String msg)  {    super(msg);  }    public MsgParseException(String code, String msg)  {    super(msg);    this.code = code;  }    public MsgParseException(String msg, Throwable t)  {    super(msg, t);    setStackTrace(t.getStackTrace());  }    public MsgParseException(String code, String msg, Throwable t)  {    super(msg, t);    this.code = code;    setStackTrace(t.getStackTrace());  }}