package br.org.acal.domain.datasource;

import java.util.List;

public interface DefaultDataSource<T> {

    List<T> findAll();
    T save(T t);

}
