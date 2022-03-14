package com.vipdistric.widget.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PORTAL")
public class Portal {
	@Id
	@Column(name = "IDPORTAL")
	private long id;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PORTAL_WIDGET", joinColumns = { @JoinColumn(name = "ID_PORTAL") }, inverseJoinColumns = {
			@JoinColumn(name = "ID_WIDGET") })
	private Set<Widget> widgets = new HashSet<>();

	public Portal() {
		super();
	}

	public Portal(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
