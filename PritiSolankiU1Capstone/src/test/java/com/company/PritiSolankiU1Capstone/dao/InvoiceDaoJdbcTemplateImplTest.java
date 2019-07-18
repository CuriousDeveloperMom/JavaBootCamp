package com.company.PritiSolankiU1Capstone.dao;

import com.company.PritiSolankiU1Capstone.model.Invoice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoJdbcTemplateImplTest {

    @Autowired
    InvoiceDao invoiceDao;


    @Before
    public void setUp() throws Exception {
        List<Invoice> invoices = invoiceDao.getAllInvoices();
        System.out.println("SIZE" + invoices.size());

        for (Invoice it : invoices) {
            System.out.println("DELETING BEFORE");
            invoiceDao.deleteInvoice(it.getInvoiceId());
            System.out.println("DELETING AFTER");
        }
    }

    @Test
    public void addInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("John Kapra");
        invoice.setStreet("Glory drive");
        invoice.setCity("Clifton");
        invoice.setState("NJ");
        invoice.setZipcode("07087");
        invoice.setItemType("Console");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("1.00"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("2.00"));
        invoice.setTax(new BigDecimal("2.00"));
        invoice.setProcessingFee(new BigDecimal("3.00"));
        invoice.setTotal(new BigDecimal("7.00"));

        invoice = invoiceDao.addInvoice(invoice);


        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        assertEquals(1, invoiceList.size());

    }

       /*
       System.out.println("INVOICE" + invoice);
        System.out.println("1111" + invoice1);
        assertEquals(invoice1,invoice);
         Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());
        invoiceDao.deleteInvoice(invoice.getInvoiceId());
        invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertNull(invoice1);*?
    */


    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void getInvoice() {
    }

    @Test
    public void getAllInvoices() {

        Invoice invoice = new Invoice();
        invoice.setName("John Kapra");
        invoice.setStreet("Glory drive");
        invoice.setCity("Clifton");
        invoice.setState("NJ");
        invoice.setZipcode("07087");
        invoice.setItemType("Console");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal(12.99));
        invoice.setQuantity(12);
        invoice.setSubtotal(new BigDecimal(149.99));
        invoice.setTax(new BigDecimal(7.99));
        invoice.setProcessingFee(new BigDecimal(15.49));
        invoice.setTotal(new BigDecimal(179.99));

        invoice = invoiceDao.addInvoice(invoice);

        invoice.setName("John Kapra");
        invoice.setStreet("Glory drive");
        invoice.setCity("Clifton");
        invoice.setState("NJ");
        invoice.setZipcode("07087");
        invoice.setItemType("Console");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal(12.99));
        invoice.setQuantity(12);
        invoice.setSubtotal(new BigDecimal(149.99));
        invoice.setTax(new BigDecimal(7.99));
        invoice.setProcessingFee(new BigDecimal(15.49));
        invoice.setTotal(new BigDecimal(179.99));

        invoiceDao.addInvoice(invoice);

        List<Invoice> iList = invoiceDao.getAllInvoices();
        assertEquals(2, iList.size());
    }
}