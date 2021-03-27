package com.sugarbeach.repository;

import java.util.List;

/**
 * @author Lakitha Prabudh on 3/26/21
 */
public interface SuperRepository <T>{

    boolean save(T t);

    List<T> findAll();

    List<T> findAllById(int id);
}
