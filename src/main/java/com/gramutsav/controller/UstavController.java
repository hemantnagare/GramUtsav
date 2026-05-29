package com.gramutsav.controller;

import com.gramutsav.entity.Ustav;
import com.gramutsav.repository.UstavRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ustav")
@CrossOrigin(origins = "*")
public class UstavController {

    @Autowired
    private UstavRepository ustavRepository;

    @GetMapping("/allUstav")
    public List<Ustav> getAllUstav() {

        return ustavRepository.findAll();
    }
}