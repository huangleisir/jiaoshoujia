package com.jst.demo.bean;

public class LoginBean
{
  private String userAccount;
  private String password;
  private String verifyCode;
  private String requestTimeStamp;
  private String version;
  private String sign;
  
  public String getUserAccount()
  {
    return this.userAccount;
  }
  
  public void setUserAccount(String userAccount)
  {
    this.userAccount = userAccount;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public String getVerifyCode()
  {
    return this.verifyCode;
  }
  
  public void setVerifyCode(String verifyCode)
  {
    this.verifyCode = verifyCode;
  }
  
  public String getRequestTimeStamp()
  {
    return this.requestTimeStamp;
  }
  
  public void setRequestTimeStamp(String requestTimeStamp)
  {
    this.requestTimeStamp = requestTimeStamp;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public void setVersion(String version)
  {
    this.version = version;
  }
  
  public String getSign()
  {
    return this.sign;
  }
  
  public void setSign(String sign)
  {
    this.sign = sign;
  }
}
