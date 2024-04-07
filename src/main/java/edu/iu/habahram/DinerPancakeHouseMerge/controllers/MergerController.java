package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CafeRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
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
    MergerRepository mergerRepository;
    public MergerController(MergerRepository mergerRepository){
        this.mergerRepository = mergerRepository;
    }
    @GetMapping
    public List<MenuItem> get(){
        Iterator mergerIterator = mergerRepository.getTheMenus().iterator();
        List<MenuItem> items = new ArrayList<>();
        while(mergerIterator.hasNext()){
            Menu temp = (Menu) mergerIterator.next();
            Iterator tempIterator = temp.createIterator();
            while(tempIterator.hasNext()){
                items.add((MenuItem) tempIterator.next());
            }
        }
        return items;
    }
}
