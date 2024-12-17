package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.model.Place;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

// Mejor llamarlo GetPlaceDto
public class PlaceDto {
    public Long id;
    public String name;
    public String coords;
    public String image;

    //metodo de transformacion
    public static PlaceDto fromPlace(Place place) {
        return new PlaceDto(
                place.getId();
                place.getName();
                place.getCoords();
                place.getImage();
        )
    }

}