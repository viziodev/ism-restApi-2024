package com.ism.ecom.web.controllers;

import com.ism.ecom.web.dto.request.PanierDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface CommandeRestController {
    @GetMapping("commandes/client/{id}")
    ResponseEntity<Map<Object, Object>> listerCommandeUnClient(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int size);
    @GetMapping("/commandes")
    ResponseEntity<Map<Object, Object>>  listerAllCommandes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size);
    @PostMapping("/commandes")
    public ResponseEntity<Map<Object, Object>>  saveCommande(@RequestBody PanierDto panier);
}
