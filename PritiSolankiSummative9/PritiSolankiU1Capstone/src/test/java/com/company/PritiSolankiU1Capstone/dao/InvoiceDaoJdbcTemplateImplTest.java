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

import static java.math.RoundingMode.HALF_UP;
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
    public void addGetDeleteInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("John Kapra");
        invoice.setStreet("Glory drive");
        invoice.setCity("Clifton");
        invoice.setState("NJ");
        invoice.setZipcode("07087");
        invoice.setItemType("Console");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("1.00").setScale(2, HALF_UP));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("2.00").setScale(2, HALF_UP));
        invoice.setTax(new BigDecimal("2.00").setScale(2, HALF_UP));
        invoice.setProcessingFee(new BigDecimal("3.00").setScale(2, HALF_UP));
        invoice.setTotal(new BigDecimal("7.00").setScale(2, HALF_UP));

        invoice = invoiceDao.addInvoice(invoice);
        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertEquals(invoice1,invoice);

        invoiceDao.deleteInvoice(invoice.getInvoiceId());
        invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertNull(invoice1);
        //List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        //assertEquals(1, invoiceList.size());
    }

    @After
    public void tearDown() throws Exception {

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.stream()
                .forEach(invoice -> {
                    invoiceDao.deleteInvoice(invoice.getInvoiceId());
                });
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
        invoice.setUnitPrice(new BigDecimal(12.99).setScale(2, HALF_UP));
        invoice.setQuantity(12);
        invoice.setSubtotal(new BigDecimal(149.99).setScale(2, HALF_UP));
        invoice.setTax(new BigDecimal(7.99).setScale(2, HALF_UP));
        invoice.setProcessingFee(new BigDecimal(15.49).setScale(2, HALF_UP));
        invoice.setTotal(new BigDecimal(179.99).setScale(2, HALF_UP));

        invoice = invoiceDao.addInvoice(invoice);

        invoice.setName("John Kapra");
        invoice.setStreet("Glory drive");
        invoice.setCity("Clifton");
        invoice.setState("NJ");
        invoice.setZipcode("07087");
        invoice.setItemType("Console");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal(12.99).setScale(2, HALF_UP));
        invoice.setQuantity(12);
        invoice.setSubtotal(new BigDecimal(149.99).setScale(2, HALF_UP));
        invoice.setTax(new BigDecimal(7.99).setScale(2, HALF_UP));
        invoice.setProcessingFee(new BigDecimal(15.49).setScale(2, HALF_UP));
        invoice.setTotal(new BigDecimal(179.99).setScale(2, HALF_UP));

        invoiceDao.addInvoice(invoice);

        List<Invoice> iList = invoiceDao.getAllInvoices();
        assertEquals(iList.size(),2);
    }
}