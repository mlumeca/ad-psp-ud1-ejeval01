package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.model.Place;

public record CreatePlaceDto(
        String name,
        String address,
        String coords,
        String image,
        String desc
) {
    public Place toPlace(CreatePlaceDto dto)
        return Place.builder()
                .name(this.name)
                .address()
}
