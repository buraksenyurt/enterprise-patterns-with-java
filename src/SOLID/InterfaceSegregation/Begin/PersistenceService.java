package SOLID.InterfaceSegregation.Begin;

import java.util.List;

import SOLID.InterfaceSegregation.Common.Entity;

public interface PersistenceService<T extends Entity> {

    public void save(T entity);

    public void delete(T entity);

    public T findById(Long id);

    // Bu metot her Entity türevi için anlamlı değildir.
    // Title içermeye meyen Entity türleri için bu metot anlamsız olur ve
    // implementasyon zorluğu yaratır.
    // Burada Interface Segregation Principle ihlal edilmektedir.
    public List<T> findByTitle(String title);
}
