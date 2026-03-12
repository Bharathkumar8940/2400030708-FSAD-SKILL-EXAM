package fsadexam;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int id;

    @Column(name = "invoice_name")
    private String name;

    @Column(name = "invoice_date")
    private LocalDate date;

    @Column(name = "invoice_status")
    private String status;

    @Column(name = "invoice_amount")
    private double amount;

    @Column(name = "customer_name")
    private String customerName;

    // ---- Default Constructor ----
    public Invoice() {}

    // ---- Parameterized Constructor ----
    public Invoice(String name, LocalDate date, String status, double amount, String customerName)
    {
        this.name         = name;
        this.date         = date;
        this.status       = status;
        this.amount       = amount;
        this.customerName = customerName;
    }

    // ---- Getters and Setters ----
    public int getId()                        { return id; }
    public void setId(int id)                 { this.id = id; }

    public String getName()                   { return name; }
    public void setName(String name)          { this.name = name; }

    public LocalDate getDate()                { return date; }
    public void setDate(LocalDate date)       { this.date = date; }

    public String getStatus()                 { return status; }
    public void setStatus(String status)      { this.status = status; }

    public double getAmount()                 { return amount; }
    public void setAmount(double amount)      { this.amount = amount; }

    public String getCustomerName()                       { return customerName; }
    public void setCustomerName(String customerName)      { this.customerName = customerName; }

    @Override
    public String toString()
    {
        return "Invoice [ID=" + id +
               ", Name=" + name +
               ", Date=" + date +
               ", Status=" + status +
               ", Amount=" + amount +
               ", Customer=" + customerName + "]";
    }
}
