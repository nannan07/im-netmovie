package com.allmsi.netmovie.model.vo;

import com.allmsi.netmovie.model.MoviePerson;

public class MPersonVo {

	private String name;

	private String roleName;

	public MPersonVo() {

	}

	public MPersonVo(MoviePerson mp) {
		if (mp != null) {
			this.name = mp.getName();
			this.roleName = mp.getRoleName();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}