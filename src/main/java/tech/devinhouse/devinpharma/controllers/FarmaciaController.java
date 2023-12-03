package tech.devinhouse.devinpharma.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.devinpharma.services.FarmaciaService;

@RestController
@RequestMapping("/farmacias")

public class FarmaciaController {

    @Autowired
    private FarmaciaService service;

    @Autowired
    private ModelMapper mapper;

}
