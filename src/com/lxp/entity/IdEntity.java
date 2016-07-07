package com.lxp.entity;

import java.io.Serializable;

public abstract class IdEntity implements Serializable {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
