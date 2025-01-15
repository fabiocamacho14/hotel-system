package com.oranet.hotelsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dado-hotel/{hotelId}")
public class DadosHotel {

    @GetMapping
    public String mensagem() {
        return "Boa tarde";
    }
}
