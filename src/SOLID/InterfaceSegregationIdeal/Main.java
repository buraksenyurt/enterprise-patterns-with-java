package SOLID.InterfaceSegregationIdeal;

import java.time.LocalDateTime;

import SOLID.InterfaceSegregationCommon.Customer;
import SOLID.InterfaceSegregationCommon.Invoice;

public class Main {
    public static void main(String[] args) {
        System.out.println("Interface Segregation Principle (ISP) ile uyumlu örnek:");
        System.out.println("Lütfen kodları inceleyin");

        InvoicePersistenceService invoiceService = new InvoicePersistenceService();

        invoiceService.save(new Invoice(1L, LocalDateTime.now(), 100.0));
        invoiceService.save(new Invoice(2L, LocalDateTime.now(), 200.0));

        System.out.println("Invoice with ID 1: " + invoiceService.findById(1L));
        // System.out.println("Invoice with ID 2: " +
        // invoiceService.findByTitle("Anlamsız"));

        CustomerPersistenceService customerService = new CustomerPersistenceService();
        customerService.save(new Customer(1L, "John Doe", 1023L));
        customerService.save(new Customer(2L, "Jane Smith", 2048L));
        System.out.println("Customer with ID 1: " + customerService.findById(1L));
        System.out.println("Customer with title 'John Doe': " + customerService.findByTitle("John Doe"));
    }
}
