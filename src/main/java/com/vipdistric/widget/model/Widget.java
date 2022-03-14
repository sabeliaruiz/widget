package com.vipdistric.widget.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.vipdistric.widget.convert.TypeWidgetAttributeConverter;

@Entity
@Table(name = "WIDGET")
public class Widget {

	@Id
	@Column(name = "IDWIDGET")
	private long id;
	
	@Convert(converter = TypeWidgetAttributeConverter.class)
	@Column(name = "TYPE")
	private int type;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "Style")
	private String style;
		

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PORTAL_WIDGET", joinColumns = { @JoinColumn(name = "ID_WIDGET") }, inverseJoinColumns = {
			@JoinColumn(name = "ID_PORTAL") })
	private Set<Portal> portales = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Portal> getPortales() {
		return portales;
	}

	public void setPortales(Set<Portal> portales) {
		this.portales = portales;
	}

}
