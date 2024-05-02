package br.unit.forge.controller;

import br.unit.forge.model.Empresa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @PostMapping("/cadastro")
    public ResponseEntity<Empresa> cadastrarEmpresa(@RequestBody Empresa empresa) {

        return new ResponseEntity<>(empresa, HttpStatus.CREATED);
    }
}