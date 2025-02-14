package com.oranet.hotelsystem.controller;

import com.oranet.hotelsystem.assembler.QuartoModelAssembler;
import com.oranet.hotelsystem.assembler.disassembler.QuartoInputModelDisassembler;
import com.oranet.hotelsystem.model.Quarto;
import com.oranet.hotelsystem.model.dto.QuartoModel;
import com.oranet.hotelsystem.model.dto.input.QuartoInputModel;
import com.oranet.hotelsystem.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/quarto")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @Autowired
    private QuartoModelAssembler quartoModelAssembler;

    @Autowired
    private QuartoInputModelDisassembler quartoInputModelDisassembler;

    @GetMapping
    public List<QuartoModel> listarQuartos() {
        return quartoModelAssembler.toCollectionModel(quartoService.listarQuartos());
    }

    @GetMapping("/{quartoId}")
    public QuartoModel buscarQuarto(@PathVariable Integer quartoId) {
        return quartoModelAssembler.toModel(quartoService.buscarPorId(quartoId));
    }

    @PostMapping
    public QuartoModel salvarQuarto(@RequestBody QuartoInputModel quartoInputModel) {
        Quarto quarto = quartoInputModelDisassembler.toDomainObject(quartoInputModel);
        return quartoModelAssembler.toModel(quartoService.salvarQuarto(quarto));
    }

    @PutMapping("/{quartoId}")
    public QuartoModel atualizarQuarto(@PathVariable Integer quartoId, @RequestBody QuartoInputModel quartoInputModel) {
        Quarto quarto = quartoService.buscarPorId(quartoId);
        quartoInputModelDisassembler.copyToDomainObject(quartoInputModel, quarto);
        return quartoModelAssembler.toModel(quartoService.salvarQuarto(quarto));
    }

    @DeleteMapping("/{quartoId}")
    public void excluirQuarto(@PathVariable Integer quartoId) {
        quartoService.excluirQuarto(quartoId);
    }

    @GetMapping("/{codigoQuarto}/disponibilidade/{mes}/{ano}/{hotelId}")
    public List<LocalDate> buscarDatasDisponiveisNoMes(@PathVariable Integer hotelId, @PathVariable String codigoQuarto, @PathVariable Integer mes, @PathVariable Integer ano) {
        return quartoService.buscarDatasDisponiveisNoMes(hotelId, codigoQuarto, mes, ano);
    }
}
