package com.salesianostriana.dam.resteval.model;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PlaceRepository {

    private HashMap<Long, Place> places = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    public void init() {
        // Añadir aquí datos de ejemplo
        Place p1 = Place.builder()
                .name("El Rinconcillo")
                .address("Calle 1")
                .coords("aaa")
                .desc("Buen bar")
                .image("https//foto1.jpeg")
                .build();
        add(p1);

        Place p2 = Place.builder()
                .name("Otro rincón")
                .address("Calle 2")
                .coords("bbb")
                .desc("Bar regulín")
                .image("https//foto2.jpeg")
                .build();
        add(p2);

        Place p3 = Place.builder()
                .name("El Rincon de Paco")
                .address("Calle 3")
                .coords("ccc")
                .desc("Bar malo")
                .image("https//foto3.jpeg")
                .build();
        add(p3);
    }

    public Place add(Place place) {
        var id = counter.incrementAndGet();
        place.setId(id);
        places.put(id, place);
        return place;
    }

    public Optional<Place> get(Long id) {
        return Optional.ofNullable(places.get(id));
    }

    public List<Place> getAll() {
        return List.copyOf(places.values());
    }

    public Optional<Place> edit(Long id, Place place) {
        return Optional.ofNullable(places.computeIfPresent(id, (k,v) -> {
            v.setName(place.getName());
            v.setDesc(place.getDesc());
            v.setImage(place.getImage());
            v.setCoords(place.getCoords());
            v.setAddress(place.getAddress());
            return v;
        }));
    }

    public void delete(Long id) {
        places.remove(id);
    }
}