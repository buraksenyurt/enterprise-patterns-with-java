package SOLID.InterfaceSegregation.Begin;

import java.time.LocalDateTime;

import SOLID.InterfaceSegregation.Common.Customer;
import SOLID.InterfaceSegregation.Common.Invoice;

/*
    Interface Segregation Principle (ISP) ihlal içeren örnek:

    PersistenceService arayüzü, Entity türleri için ortak bir arayüz olarak tasarlanmıştır. 
    Ancak, findByTitle metodu her Entity türü için anlamlı değildir. 
    Örneğin, Invoice türü için findByTitle metodu anlamsızdır çünkü Invoice'ların bir "title" özelliği yoktur.
    Bu durum, InvoicePersistenceService sınıfının findByTitle metodunu implement etmek zorunda kalmasıyla sonuçlanır, 
    bu da gereksiz ve anlamsız bir implementasyon yaratır.

    Dolayısıyla arayüzleri kullanacak sınıfların sadece ihtiyaç duydukları metotları implement etmeleri gerektiği 
    prensibi ihlal edilmektedir.
*/

public class Main {
    public static void main(String[] args) {

        System.out.println("Interface Segregation Principle (ISP) için ihlal içeren örnek:");
        System.out.println("Lütfen kodları inceleyin");

        InvoicePersistenceService invoiceService = new InvoicePersistenceService();

        invoiceService.save(new Invoice(1L, LocalDateTime.now(), 100.0));
        invoiceService.save(new Invoice(2L, LocalDateTime.now(), 200.0));

        System.out.println("Invoice with ID 1: " + invoiceService.findById(1L));
        System.out.println("Invoice with ID 2: " + invoiceService.findByTitle("Anlamsız"));

        CustomerPersistenceService customerService = new CustomerPersistenceService();
        customerService.save(new Customer(1L, "John Doe", 1023L));
        customerService.save(new Customer(2L, "Jane Smith", 2048L));
        System.out.println("Customer with ID 1: " + customerService.findById(1L));
        System.out.println("Customer with title 'John Doe': " + customerService.findByTitle("John Doe"));
    }
}
