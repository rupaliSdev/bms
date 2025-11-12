package com.movie.bms.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Language extends BaseModel {
    String value;
}
