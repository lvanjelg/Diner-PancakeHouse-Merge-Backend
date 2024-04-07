package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CafeRepository;
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
    CafeRepository cafeRepository;
    public MergerController(PancakeHouseRepository pancakeHouseRepository, DinerRepository dinerRepository, CafeRepository cafeRepository){
        this.pancakeHouseRepository = pancakeHouseRepository;
        this.dinerRepository = dinerRepository;
        this.cafeRepository = cafeRepository;
    }
    @GetMapping
    public List<MenuItem> get(){
        Iterator dinerIterator = dinerRepository.createIterator();
        Iterator pancakeIterator = pancakeHouseRepository.createIterator();
        Iterator cafeIterator = cafeRepository.createIterator();
        List<MenuItem> items = new ArrayList<>();
        while(pancakeIterator.hasNext()){
            items.add((MenuItem) pancakeIterator.next());
        }
        while(dinerIterator.hasNext()){
            items.add((MenuItem) dinerIterator.next());
        }
        while(cafeIterator.hasNext()){
            items.add((MenuItem) cafeIterator.next());
        }
        return items;
    }
}
