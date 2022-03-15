package model;

import java.util.ArrayList;

public class BeerExpert {
    public ArrayList<String> getBrands(String color){
        ArrayList<String> res = new ArrayList<String>();
        if (color.equals("amber")){
            res.add("Jack Amber");
            res.add("Red Moose");
        }else {
            res.add("Jail Pale Ale");
            res.add("Gout Stout");
        }
        return res;
    }
}
