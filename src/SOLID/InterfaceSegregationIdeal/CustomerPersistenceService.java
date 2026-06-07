package SOLID.InterfaceSegregationIdeal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import SOLID.InterfaceSegregationCommon.Customer;

public class CustomerPersistenceService implements PersistenceService<Customer> {

    private static final Map<Long, Customer> CustomersData = new HashMap<>();

    @Override
    public void save(Customer entity) {
        synchronized (CustomersData) {
            CustomersData.put(entity.getId(), entity);
        }
    }

    @Override
    public void delete(Customer entity) {
        synchronized (CustomersData) {
            CustomersData.remove(entity.getId());
        }
    }

    @Override
    public Customer findById(Long id) {
        synchronized (CustomersData) {
            return CustomersData.get(id);
        }
    }

    public List<Customer> findByTitle(String title) {
        synchronized (CustomersData) {
            return CustomersData.values().stream().filter(c -> c.getTitle().equalsIgnoreCase(title))
                    .collect(Collectors.toList());
        }
    }
}