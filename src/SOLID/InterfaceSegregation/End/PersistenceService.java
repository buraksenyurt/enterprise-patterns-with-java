package SOLID.InterfaceSegregation.End;

import SOLID.InterfaceSegregation.Common.Entity;

public interface PersistenceService<T extends Entity> {

    public void save(T entity);

    public void delete(T entity);

    public T findById(Long id);
}
