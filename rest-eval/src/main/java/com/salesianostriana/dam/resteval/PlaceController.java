package com.salesianostriana.dam.resteval;

import com.salesianostriana.dam.resteval.dto.CreatePlaceDto;
import com.salesianostriana.dam.resteval.dto.ListPlaceDto;
import com.salesianostriana.dam.resteval.error.PlaceNotFoundException;
import com.salesianostriana.dam.resteval.model.Place;
import com.salesianostriana.dam.resteval.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@RequestMapping("/place/")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService service;

    @GetMapping
    public ListPlaceDto getAll() {
        return ListPlaceDto.of(
                service.getAll()
        );
    }

    @GetMapping("/id")
    // ...

    @PostMapping
    public ResponseEntity<Place> create(
            @RequestBody CreatePlaceDto dto
    ) {
        return ResponseEntity.status(201)
                .body(
                        service.create(dto.toPlace())
                );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RestControllerAdvice
    public class GlobalErrorController extends ResponseEntityExceptionHandler {

        @ExceptionHandler(PlaceNotFoundException.class)
            public ProblemDetail notFound(PlaceNotFoundException ex) {
            var result = ProblemDetail
                    .forStatusAndDetail(
                            HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
        }
    }
}