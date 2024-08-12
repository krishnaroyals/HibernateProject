package com.techpalle;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Query;
import com.techpalle.com.Employee;

public class MyProgram {

	public static void main(String[] args) {
		create();
		read();
		update(3,"esal","40000");
		delete(2);

	}
	public static void read() {
		SessionFactory fac=new Configuration().configure().buildSessionFactory();
		Session s=fac.openSession();

		Criteria c=s.createCriteria(Employee.class);
		List<Employee> list=(List<Employee>)c.list();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getEno());
			System.out.println(list.get(i).getEname());
			System.out.println(list.get(i).getEsal());
			System.out.println(list.get(i).getEdesg());
		}
		 s.close();
		 fac.close();
	}
	public static void create() {
		SessionFactory fac=new Configuration().configure().buildSessionFactory();
		Session s=fac.openSession();
		Transaction t=s.beginTransaction();
		Employee e1=new Employee(1,"steve",50000,"developer");
		Employee e2=new Employee(2,"bill",20000,"developer");
		Employee e3=new Employee(3,"lanie",30000,"HR");
		s.save(e1);
		s.save(e2);
		s.save(e3);
		t.commit();
		s.close();
		fac.close();
	}
	public static void update(int no,String parameter,String value) {
		SessionFactory fac=new Configuration().configure().buildSessionFactory();
		Session s=fac.openSession();
		Transaction t=s.beginTransaction();
		Employee e=s.get(Employee.class, no);
		switch(parameter) {
		case "eno":
			e.setEno(Integer.parseInt(value));
			break;
		case "ename":
			e.setEname(value);;
			break;
		case "esal":
			e.setEsal(Integer.parseInt(value));
			break;
		case "edesg":
			e.setEdesg(value);
			break;
		}
		
		t.commit();
		s.close();
		fac.close();
	}
	public static void delete(int no) {
		SessionFactory fac=new Configuration().configure().buildSessionFactory();
		Session s=fac.openSession();
		Transaction t=s.beginTransaction();
		Employee e=s.get(Employee.class, no);
		s.delete(e);
		t.commit();
		s.close();
		fac.close();
	}

}
