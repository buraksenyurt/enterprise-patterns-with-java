package SOLID.InterfaceSegregationCommon;

import java.time.LocalDateTime;

public class Invoice extends Entity {

    private LocalDateTime invoiceDate;

    private double totalAmount;

    public Invoice() {
    }

    public Invoice(Long id, LocalDateTime invoiceDate, double totalAmount) {
        this.setId(id);
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
