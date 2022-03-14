package com.vipdistric.widget.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vipdistric.widget.model.Widget;

@Repository
public class WidgetDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public Widget getById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Widget widget = (Widget) session.load(Widget.class, id);
		return widget;
	}
	
	public List<Widget> getWidgetsByPortal(long idPortal){
		Session session = this.sessionFactory.getCurrentSession();
		String query = "from widget w join u.portales p where p.idportal=" +idPortal;
		List<Widget> widgetsList = session.createQuery(query).list();
		return widgetsList;
		
	}
	
	public Widget save(Widget widget) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(widget);
		return widget;
	}

	public void update(Widget widget) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(widget);
	}

	public void delete(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Widget p = (Widget) session.load(Widget.class,id);
		if (null != p) {
			session.delete(p);
		}
	}	



}
