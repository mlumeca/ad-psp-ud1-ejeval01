package com.salesianostriana.dam.resteval.service;

import com.salesianostriana.dam.resteval.error.PlaceNotFoundException;
import com.salesianostriana.dam.resteval.model.Place;
import com.salesianostriana.dam.resteval.model.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // inyección de dependencias del repositorio
public class PlaceService {

    private final PlaceRepository Repository;

    public List<Place> getAll() {
        List<Place> result = Repository.getAll();
        if(result.isEmpty())
        throw new PlaceNotFoundException("No hay");
    return result;
}

public Place getById(Long id) {

    return repository.get(id)
            .orElseThrow PlaceNotFoundException("No se ha podido encontrar el id %d");
}