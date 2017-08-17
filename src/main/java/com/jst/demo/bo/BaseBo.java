package com.jst.demo.bo;import io.swagger.annotations.ApiModelProperty;import java.io.Serializable;public class BaseBo  implements Serializable, Cloneable{  private static final long serialVersionUID = 1L;  @ApiModelProperty(value="App版本号", required=true)  private int appVersion;  @ApiModelProperty(value="设备类型, 1-安卓，2-ios", required=true)  private int deviceType;  @ApiModelProperty(value="个推clientId  设备id", required=true)  private String clientId;  private String userId;  private int pageNo = 1;  private int pageSize = 10;    public int getAppVersion()  {    return this.appVersion;  }    public void setAppVersion(int appVersion)  {    this.appVersion = appVersion;  }    public int getDeviceType()  {    return this.deviceType;  }    public void setDeviceType(int deviceType)  {    this.deviceType = deviceType;  }    public String getClientId()  {    return this.clientId;  }    public void setClientId(String clientId)  {    this.clientId = clientId;  }    public String getUserId()  {    return this.userId;  }    public void setUserId(String userId)  {    this.userId = userId;  }    public int getPageNo()  {    return this.pageNo;  }    public void setPageNo(int pageNo)  {    this.pageNo = pageNo;  }    public int getPageSize()  {    return this.pageSize;  }    public void setPageSize(int pageSize)  {    this.pageSize = pageSize;  }}