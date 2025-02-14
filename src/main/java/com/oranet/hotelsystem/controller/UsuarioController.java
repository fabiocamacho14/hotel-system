package com.oranet.hotelsystem.controller;

import com.oranet.hotelsystem.assembler.UsuarioModelAssembler;
import com.oranet.hotelsystem.assembler.disassembler.UsuarioInputModelDisassembler;
import com.oranet.hotelsystem.model.Usuario;
import com.oranet.hotelsystem.model.dto.UsuarioModel;
import com.oranet.hotelsystem.model.dto.input.UsuarioInputModel;
import com.oranet.hotelsystem.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioModelAssembler usuarioModelAssembler;

    @Autowired
    private UsuarioInputModelDisassembler usuarioInputModelDisassembler;

    @GetMapping
    public List<UsuarioModel> listarUsuarios() {
        return usuarioModelAssembler.toCollectionModel(usuarioService.listarUsuarios());
    }

    @GetMapping("/{usuarioId}")
    public UsuarioModel buscarUsuario(@PathVariable Integer usuarioId) {
        return usuarioModelAssembler.toModel(usuarioService.buscarPorId(usuarioId));
    }

    @PostMapping
    public UsuarioModel salvarUsuario(@RequestBody UsuarioInputModel usuarioInput) {
        Usuario usuario = usuarioInputModelDisassembler.toDomainObject(usuarioInput);
        return usuarioModelAssembler.toModel(usuarioService.salvarUsuario(usuario));
    }

    @PutMapping("/{usuarioId}")
    public UsuarioModel atualizarUsuario(@PathVariable Integer usuarioId, @RequestBody UsuarioInputModel usuarioInput) {
        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        usuarioInputModelDisassembler.copyToDomainObject(usuarioInput, usuario);
        return usuarioModelAssembler.toModel(usuarioService.salvarUsuario(usuario));
    }

    @DeleteMapping("/{usuarioId}")
    public void excluirUsuario(@PathVariable Integer usuarioId) {
        usuarioService.excluirUsuario(usuarioId);
    }
}
