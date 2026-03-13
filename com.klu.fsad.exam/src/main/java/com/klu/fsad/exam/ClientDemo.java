package com.klu.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo
{
 public static void main(String[] args)
 {

  SessionFactory sf = new Configuration().configure().buildSessionFactory();
  Session session = sf.openSession();
  Transaction tx = session.beginTransaction();

  Movie m = new Movie("RRR","2022","Released","Rajamouli",550);

  session.save(m);

  System.out.println("Movie Inserted Successfully");

  tx.commit();

  session = sf.openSession();
  tx = session.beginTransaction();

  String hql = "update Movie set name=?0, status=?1 where id=?2";

  Query query = session.createQuery(hql);

  query.setParameter(0,"RRR Updated");
  query.setParameter(1,"Super Hit");
  query.setParameter(2,1);

  int rows = query.executeUpdate();

  System.out.println("Rows Updated = "+rows);

  tx.commit();

  session.close();
  sf.close();

 }
}