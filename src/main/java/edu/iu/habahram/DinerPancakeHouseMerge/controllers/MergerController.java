package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
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
        Iterator dinerIterator = dinerRepository.createIterator();
        Iterator pancakeIterator = pancakeHouseRepository.createIterator();
        List<MenuItem> items = new ArrayList<>();
        while(pancakeIterator.hasNext()){
            items.add((MenuItem) pancakeIterator.next());
        }
        while(dinerIterator.hasNext()){
            items.add((MenuItem) dinerIterator.next());
        }
        return items;
    }
}
