package com.salesianostriana.dam.resteval.dto;

import java.util.List;

public record ListPlaceDto(
        long count,
        List<PlaceDto> items
) {
    public static ListPlaceDto fromPlaceDto(final PlaceDto placeDto) {
        return new ListPlaceDto(
                list.size(),
                list.stream() // metodo stream transforma la lista en stream? o String?
                        .map(PlaceDto::of) // Cada elemento es transformado, recibe un objeto tipo function
                        // a -> CLase.funcion(a) } clase::funcion --> lambda
                        .toList()
        );
    }
}
