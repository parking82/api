package com.parking82.api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private Integer spot;

}
