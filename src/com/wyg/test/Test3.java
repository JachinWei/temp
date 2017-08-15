package com.wyg.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wyg.model.Product;

public class Test3 {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();
		s.beginTransaction();
		Product p = new Product();
		p.setName("p1");
		System.out.println("此时p是瞬时状态");
		s.save(p);
		System.out.println("此时p是持久状态");
		s.getTransaction().commit();
		s.close();
		System.out.println("此时p是脱管状态");
		sf.close();
	}
}
