package com.opticores.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * A utility class to configure hibernate session factory and to retrieve
 * hibernate current session.
 * 
 * Make sure that hibernate.cfg.xml file is on the classpath. Currently it's
 * located inside src/main/resources
 * 
 * @author anubhav
 *
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static void init() {

		Configuration config = new Configuration();
		config.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();

		sessionFactory = config.buildSessionFactory(serviceRegistry);

	}

	public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
