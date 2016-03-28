package com.mmsp.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Алексей
 */

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	static {
		Configuration cfg = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		sessionFactory = cfg.buildSessionFactory(builder.build());
		if (sessionFactory == null) {
			System.err.println("AHTUNG!!");
		}
	}

	public static void closeSessionFactory() {
		sessionFactory.close();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
