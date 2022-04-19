package com.pi.seriesservice.controller;

import com.pi.seriesservice.persistence.entity.Serie;
import com.pi.seriesservice.service.ISerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE})
@RequestMapping(path = "/serie")
public class SerieController {
    private ISerieService iSerieService;

    public SerieController(ISerieService iSerieService) {
        this.iSerieService = iSerieService;
    }

    @PostMapping(path = "")
    ResponseEntity save(@RequestBody Serie serie) {
        try{
            iSerieService.save(serie);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch (Exception e){
            throw new Error("No se pudo guradar la serie seleccionada", e);
        }
    }

    @GetMapping(path = "/{genre}")
    public ResponseEntity<List<Serie>> findAllByGenre(@PathVariable String genre){
        try{
            List<Serie> series = iSerieService.findAllByGenre(genre);
            return ResponseEntity.ok(series);
        }catch (Exception e){
            throw new Error("No se pudo obtener la lista de series", e);
        }

    }
}
