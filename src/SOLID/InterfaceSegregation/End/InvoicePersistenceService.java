package SOLID.InterfaceSegregation.End;

import SOLID.InterfaceSegregation.Common.Invoice;

public class InvoicePersistenceService implements PersistenceService<Invoice> {

    private static final java.util.Map<Long, Invoice> InvoicesData = new java.util.HashMap<>();

    @Override
    public void save(Invoice entity) {
        synchronized (InvoicesData) {
            InvoicesData.put(entity.getId(), entity);
        }
    }

    @Override
    public void delete(Invoice entity) {
        synchronized (InvoicesData) {
            InvoicesData.remove(entity.getId());
        }
    }

    @Override
    public Invoice findById(Long id) {
        synchronized (InvoicesData) {
            return InvoicesData.get(id);
        }
    }  
}
