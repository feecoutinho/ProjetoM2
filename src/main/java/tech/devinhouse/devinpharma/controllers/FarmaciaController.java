package tech.devinhouse.devinpharma.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.devinpharma.model.Farmacia;
import tech.devinhouse.devinpharma.services.FarmaciaService;

@RestController
@RequestMapping("/farmacias")

public class FarmaciaController {

    @Autowired
    private FarmaciaService farmaciaService;

    @Autowired
    private ModelMapper mapper;

    }