package rikkei.academy.service;

import rikkei.academy.model.Cho;

import java.util.List;

public interface IChoService {
    List<Cho> findAll();
    void save(Cho cho);
    void delete(int id);
    Cho findById(int id);

}
