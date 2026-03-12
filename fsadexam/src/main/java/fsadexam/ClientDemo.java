package fsadexam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import fsadexam.Invoice;

import java.time.LocalDate;
import java.util.List;

public class ClientDemo
{
    // ---- Build SessionFactory once ----
    private static SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    // ==========================================================
    // I. INSERT RECORDS using Persistent Object
    // ==========================================================
    public static void insertRecords()
    {
        Session session = factory.openSession();
        Transaction tx  = session.beginTransaction();

        Invoice inv1 = new Invoice("Invoice-001", LocalDate.of(2024, 1, 10),
                                   "PAID",   15000.00, "Ravi Kumar");

        Invoice inv2 = new Invoice("Invoice-002", LocalDate.of(2024, 2, 15),
                                   "UNPAID", 25000.00, "Sita Devi");

        Invoice inv3 = new Invoice("Invoice-003", LocalDate.of(2024, 3, 20),
                                   "PENDING", 8500.50, "Arjun Reddy");

        Invoice inv4 = new Invoice("Invoice-004", LocalDate.of(2024, 4, 5),
                                   "PAID",   42000.00, "Meena Lakshmi");

        Invoice inv5 = new Invoice("Invoice-005", LocalDate.of(2024, 5, 18),
                                   "UNPAID", 11250.75, "Vijay Sharma");

        // save() makes object Persistent
        session.save(inv1);
        session.save(inv2);
        session.save(inv3);
        session.save(inv4);
        session.save(inv5);

        tx.commit();
        session.close();

        System.out.println("===== Records Inserted Successfully =====");
    }

    // ==========================================================
    // II. VIEW ALL RECORDS using HQL (no WHERE clause)
    // ==========================================================
    public static void viewAllRecords()
    {
        Session session = factory.openSession();

        // HQL uses class name (Invoice), NOT table name (invoice)
        String hql = "FROM Invoice";
        Query<Invoice> query = session.createQuery(hql, Invoice.class);
        List<Invoice> list  = query.list();

        System.out.println("\n===== All Invoice Records =====");
        for (Invoice inv : list)
        {
            System.out.println(inv);
        }

        session.close();
    }

    // ==========================================================
    // III. SELECT with HQL POSITIONAL PARAMETERS (WHERE clause)
    // ==========================================================
    public static void selectByStatus(String status)
    {
        Session session = factory.openSession();

        // ?1  is positional parameter index 1
        String hql = "FROM Invoice WHERE status = ?1";
        Query<Invoice> query = session.createQuery(hql, Invoice.class);
        query.setParameter(1, status);          // bind value to position 1

        List<Invoice> list = query.list();

        System.out.println("\n===== Invoices with Status: " + status + " =====");
        for (Invoice inv : list)
        {
            System.out.println(inv);
        }

        session.close();
    }

    // ==========================================================
    // MAIN METHOD — runs all operations
    // ==========================================================
    public static void main(String[] args)
    {
        // I. Insert 5 records
        insertRecords();

        // II. View all records without WHERE clause
        viewAllRecords();

        // III. Select records using HQL positional parameters
        selectByStatus("PAID");
        selectByStatus("UNPAID");

        factory.close();
        System.out.println("\n===== Program Completed =====");
    }
}
