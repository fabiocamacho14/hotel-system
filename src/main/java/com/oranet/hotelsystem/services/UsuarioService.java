package com.oranet.hotelsystem.services;

import com.oranet.hotelsystem.exceptions.EntidadeNaoEncontradaException;
import com.oranet.hotelsystem.model.Usuario;
import com.oranet.hotelsystem.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer usuarioId) {
        return usuarioRepository.findById(usuarioId).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Usuário de id " + usuarioId + " não encontrado"));
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Integer usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}
