package com.wyg.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wyg.model.Product;

//通过id获取对象
public class Test4 {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Product p = (Product) s.get(Product.class, 6);
		System.out.println("id=6的产品名称是: " + p.getName());
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
