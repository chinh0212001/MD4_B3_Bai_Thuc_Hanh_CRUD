package rikkei.academy.service;

import org.springframework.stereotype.Service;
import rikkei.academy.model.Cho;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChoServiceIMPL implements IChoService{
    public static List<Cho> choList = new ArrayList<>();
    static {
        choList.add(new Cho(1,"Ha",20));
        choList.add(new Cho(2,"ga",18));
        choList.add(new Cho(3,"hihi",29));
    }
    @Override
    public List<Cho> findAll() {
        return choList;
    }

    @Override
    public void save(Cho cho) {
        if (cho.getId() != 0){
            Cho cho1 = findById(cho.getId());
            cho1.setName(cho.getName());
            cho1.setAge(cho.getAge());
        }else {
            choList.add(cho);
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < choList.size(); i++) {
            if (choList.get(i).getId() == id){
                choList.remove(i);
            }
        }

    }

    @Override
    public Cho findById(int id) {
        for (int i = 0; i < choList.size(); i++) {
            if (choList.get(i).getId() == id){
                return choList.get(i);
            }
        }
        return null;
    }

}
