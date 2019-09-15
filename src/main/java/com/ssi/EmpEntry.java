package com.ssi;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpEntry {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Press 1 for insert /n Press 2 for delete / press 3 for update");
		int option = sc.nextInt();
		Configuration config=new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		if(option ==1){
			Emp e1=new Emp(111,"AAA",50000);
			Emp e2=new Emp(112,"BBB",60000);
			Emp e3=new Emp(113,"CCC",70000);
			Emp e4=new Emp(114,"DDD",80000);
			Emp e5=new Emp(115,"EEE",90000);
			
			Transaction tr=session.beginTransaction();
			session.save(e1); session.save(e2);
			session.save(e3); session.save(e4);
			session.save(e5);
			tr.commit();
			System.out.println("Data Added");
		}
		else if(option==2){
			Emp e1= new Emp();
			e1.setEno(111);
			Transaction tr=session.beginTransaction();
			session.delete(e1);
			tr.commit();
			System.out.println("Data deleted");
			
		}
		else if(option==3){
			Emp e1= new Emp(111,"AAA",55000);
			Transaction tr=session.beginTransaction();
			session.update(e1);
			tr.commit();
			System.out.println("Data Updated");
			
		}
		
		
		session.close();
		
	}

}
