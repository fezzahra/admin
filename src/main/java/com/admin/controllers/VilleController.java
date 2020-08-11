package com.admin.controllers;


import com.admin.Repository.VilleRepository;
import com.admin.models.Agence;
import com.admin.models.Ville;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VilleController {
    @Autowired
    private VilleRepository repository;

    @RequestMapping("/villesAsc")
    public List<Ville> findAllOrderByNomVilleAsc() {

        Sort sort = Sort.by(Sort.Direction.ASC, "nom_ville");
        return repository.findAllOrderByNomVilleAsc(sort);
    }
}
