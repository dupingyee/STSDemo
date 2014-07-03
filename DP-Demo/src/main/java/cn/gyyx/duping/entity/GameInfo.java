package cn.gyyx.duping.entity;

import java.io.Serializable;

/*
 * 游戏实体
 */
public class GameInfo implements Serializable {
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int code;
	private String name;
}
