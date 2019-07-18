package com.company.PritiSolankiU1Capstone.dao;

import com.company.PritiSolankiU1Capstone.model.Game;
import com.company.PritiSolankiU1Capstone.model.Tshirt;

import java.util.List;

public interface TshirtDao {

    Tshirt addTshirt(Tshirt tshirt);

    Tshirt getTshirt(int id);

    List<Tshirt> getAllTshirts();

    void updateTshirt(Tshirt tshirt);

    void deleteTshirt(int id);

    List<Tshirt> getTshirtsByColor(String color);

    List<Tshirt> getTshirtsBySize(String size);
}
