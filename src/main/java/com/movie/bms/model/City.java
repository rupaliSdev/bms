package com.movie.bms.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class City extends BaseModel{
    String name;
    List<Theatre> theatres;

}
