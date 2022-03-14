package com.vipdistric.widget.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vipdistric.widget.model.Widget;
import com.vipdistric.widget.service.WidgetService;

@Controller
@RequestMapping("/")
public class WidgetController {
	
	@Autowired
	WidgetService widgetService;
	
	@GetMapping("/widget/")
	public Widget getWidget(@RequestParam Long idPortal, Model model) {
		List<Widget> widgets = widgetService.getWidgetsByPortal(idPortal);
		return widgets.get(0);
	}


}
