package com.movie.bms.model;

import java.util.List;

public class Theatre extends BaseModel{

    String name;
    String address;
    List<Screen> screens;
    City city;
}
