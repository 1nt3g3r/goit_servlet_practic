package net.proselyte.customer.dao;

import java.util.List;

public interface GenericDAO<T, ID> {

    void save(T t);

    void update(T t);

    void delete(T t);

    List<T> getAll();

    T getById(ID id);
}
