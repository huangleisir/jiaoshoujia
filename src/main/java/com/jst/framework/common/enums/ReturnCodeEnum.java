package com.jst.framework.common.enums;

public enum ReturnCodeEnum {
	SUCCESS(

			"200", "成功"), FAIL("201", "系统繁忙"), SYSTEM_UNKNOWN_ERROR("0000", "系统未知错误"), SYSTEM_DATA_NOTFUND("16001",
					"请求数据错误"), SYSTEM_TIMEOUT("16002", "处理超时"), SYSTEM_CONFIG_ERROR("16003",
							"未成功加载配置文件"), DATABASE_CONNECT_TIMEOUT("16004", "连接数据库超时"), SQL_EXCEPTION("16005",
									"Sql异常"), PARAM_NULL("160100", "接口输入参数为空串或者null"), PARAM_INVALID("160101",
											"接口输入参数不合法"), SING_ERROR("160102", "报文校验失败"), APPKEY_ERROR("160103",
													"appkey错误"), MSG_PARSE_ERROR("160104", "报文解析错误");

	private String code;
	private String desc;

	private ReturnCodeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
