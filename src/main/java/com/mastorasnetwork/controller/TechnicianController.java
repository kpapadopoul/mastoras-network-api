package com.mastorasnetwork.controller;

import com.mastorasnetwork.model.Technician;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TechnicianController {

    @GetMapping("technicians")
    public List<Technician> list() {
        return new ArrayList<>();
    }

    @PostMapping("technicians")
    public Technician create(@RequestBody Technician technician) {
        return technician;
    }

    @GetMapping("technicians/{id}")
    public Technician get(@PathVariable Long id) {
        return new Technician();
    }

    @PutMapping("technicians/{id}")
    public Technician update(@PathVariable Long id, @RequestBody Technician technician) {
        return technician;
    }

    @DeleteMapping("technicians/{id}")
    public Technician delete(@PathVariable Long id) {
        return new Technician();
    }

}
