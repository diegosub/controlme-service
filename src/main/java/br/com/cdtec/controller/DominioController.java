package br.com.cdtec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdtec.entity.Dominio;
import br.com.cdtec.response.Response;
import br.com.cdtec.service.DominioService;

@RestController
@RequestMapping("/api/dominio")
@CrossOrigin(origins = "*")
public class DominioController
{
   @Autowired
   DominioService service;
   
   @PostMapping(path = "/pesquisarPorCampo")
   public ResponseEntity<Response<List<Dominio>>> pesquisarPorCampo(HttpServletRequest request, @RequestBody Dominio dominio)
   {
       Response<List<Dominio>> response = new Response<List<Dominio>>();
       try
       {
           List<Dominio> lista = service.pesquisarPorCampo(dominio);
           response.setData(lista);
           return ResponseEntity.ok(response);
       }
       catch (Exception e)
       {
           response.getErrors().add(e.getMessage());
           return ResponseEntity.badRequest().body(response);
       }
   }
}
