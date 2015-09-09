package com.lavineoluoch.myapplication.listviewapp.Model;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 9/8/2015.
 */
public class Cow {

    /**
     * cow_breed : Ayrshire
     * cow_id : 1
     * cow_adtitle : Good Jersey for breeding
     * cow_price : $39.08
     * cow_county : Samburu
     */
    private String cow_breed;
    private int cow_id;
    private String cow_adtitle;
    private String cow_price;
    private String cow_county;

    public Cow() {
    }

    public Cow(String cow_breed,String cow_adtitle, String cow_price, String cow_county) {
        this.cow_breed = cow_breed;
        this.cow_adtitle = cow_adtitle;
        this.cow_price = cow_price;
        this.cow_county = cow_county;
    }

    public void setCow_breed(String cow_breed) {
        this.cow_breed = cow_breed;
    }

    public void setCow_id(int cow_id) {
        this.cow_id = cow_id;
    }

    public void setCow_adtitle(String cow_adtitle) {
        this.cow_adtitle = cow_adtitle;
    }

    public void setCow_price(String cow_price) {
        this.cow_price = cow_price;
    }

    public void setCow_county(String cow_county) {
        this.cow_county = cow_county;
    }

    public String getCow_breed() {
        return cow_breed;
    }

    public int getCow_id() {
        return cow_id;
    }

    public String getCow_adtitle() {
        return cow_adtitle;
    }

    public String getCow_price() {
        return cow_price;
    }

    public String getCow_county() {
        return cow_county;
    }
}
