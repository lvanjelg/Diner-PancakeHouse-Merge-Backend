package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {
    PancakeHouseRepository pancakeHouseRepository;
    DinerRepository dinerRepository;
    public MergerController(PancakeHouseRepository pancakeHouseRepository, DinerRepository dinerRepository){
        this.pancakeHouseRepository = pancakeHouseRepository;
        this.dinerRepository = dinerRepository;
    }
    @GetMapping
    public List<MenuItem> get(){
        List<MenuItem> ret = pancakeHouseRepository.getTheMenu();
        MenuItem[] items = dinerRepository.getTheMenu();
        ret.addAll(List.of(items));
        return ret;
    }
}
