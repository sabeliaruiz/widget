package com.vipdistric.widget.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipdistric.widget.dao.WidgetDAO;
import com.vipdistric.widget.model.Widget;


@Service("widgetService")
public class WidgetService {
	
	@Autowired
	WidgetDAO widgetDAO;
	

	public Widget getWidget(long id) {
		return widgetDAO.getById(id);
	}
	
	public List<Widget> getWidgetsByPortal(long idPortal) {
		return widgetDAO.getWidgetsByPortal(idPortal);
	}

}
