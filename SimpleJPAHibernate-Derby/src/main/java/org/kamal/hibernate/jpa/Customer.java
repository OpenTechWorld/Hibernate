package org.kamal.hibernate.jpa;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JPA Entity mapped to the table in the database
 *
 *
 *
 */

@Entity
@Table(name = "Customer")
public class Customer
{
    @Id
    @GeneratedValue
    private long customerId;

    private String customerName;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
