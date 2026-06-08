package SOLID.InterfaceSegregation.Begin;

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

    @Override
    public java.util.List<Invoice> findByTitle(String title) {
        // Problem burada. Invoice nesnelerinin başlık (title) alanı yok, 
        // bu yüzden bu metodu düzgün bir şekilde uygulamak mümkün değil.
        // Geriye null döndürüyoruz.
        return null;
    }    
}
