package cn.gyyx.duping.entity;

import java.io.Serializable;

public class ServerInfo implements Serializable {

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int code;
	private int gameId;
	private String name;
}
