package org.kamal.hibernate.jpa;


import org.apache.derby.jdbc.EmbeddedDataSource;
import org.apache.naming.java.javaURLContextFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.junit.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 * User: kmuralidharan
 * Date: 12/3/12
 * Time: 10:19 PM
 *
 */


public class TestCustomer {

    @BeforeClass
    public static void setUpClass() throws Exception {

        /* Create the Data Source and set the Initial Context */
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, javaURLContextFactory.class.getName());
        System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
        InitialContext ic = new InitialContext();
        ic.createSubcontext("java:");
        ic.createSubcontext("java:comp");
        ic.createSubcontext("java:comp/env");
        ic.createSubcontext("java:comp/env/jdbc");

        /* Create an Embedded Data Source and Create the database */
        EmbeddedDataSource ds = new EmbeddedDataSource();
        ds.setDatabaseName("derbyDS");
        ds.setCreateDatabase("create");

        ic.bind("java:comp/env/jdbc/derbyDS", ds);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {

        InitialContext ic = new InitialContext();
        ic.unbind("java:comp/env/jdbc/derbyDS");
    }


    @Test
    public void testNewUser() {

        EntityManager entityManager = Persistence.createEntityManagerFactory("derbyUnit").createEntityManager();

        /* Begin Transaction */
        entityManager.getTransaction().begin();

        Customer customer = new Customer();
        customer.setCustomerName("Amazon");
        entityManager.persist(customer);

        entityManager.getTransaction().commit();
        /* End Transaction by Committing */

        /* Verification of the test whether record is properly inserted */

        System.out.println("Customer =" + customer + ", Customer Id=" + customer.getCustomerId());
        Customer searchedCustomer = entityManager.find(Customer.class, customer.getCustomerId());
        // customer instance is the mapped instance of the entity
        System.out.println("Customer =" + customer);
        assertEquals(customer.getCustomerName(), searchedCustomer.getCustomerName());

        entityManager.close();
    }
}
