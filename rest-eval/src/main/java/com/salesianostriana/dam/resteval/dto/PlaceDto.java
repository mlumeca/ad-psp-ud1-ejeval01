package com.salesianostriana.dam.resteval.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PlaceDto {
    public String name;
    public String address;
    public String coords;
    public String description;
    public String image;

    //metodo de transformacion

    @Override
    public String toString() {
        return "PlaceDto{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", coords='" + coords + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

}