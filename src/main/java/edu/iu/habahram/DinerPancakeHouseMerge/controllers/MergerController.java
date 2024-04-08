package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.util.CompositeIterator;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {
    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }
    @GetMapping
    public List<MenuItemRecord> get() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        return items;
    }
    @RequestMapping("/vegetarian")
    @GetMapping
    public List<MenuItemRecord> getVeg(){
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        CompositeIterator<MenuItemRecord> it = new CompositeIterator<>();
        it.add(items.stream().iterator());
        List<MenuItemRecord> veg = new ArrayList<>();
        while(it.hasNext()){
            MenuItemRecord temp = it.next();
            if(temp.vegetarian()){
                veg.add(temp);
            }
        }
        return veg;
    }
    @RequestMapping("/breakfast")
    @GetMapping
    public List<MenuItemRecord> getBreakfast(){
        PancakeHouseMenu m = new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast");
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        CompositeIterator<MenuItemRecord> it = new CompositeIterator<>();
        it.add(items.iterator());
        List<MenuItemRecord> breakfast = new ArrayList<>();
        List<String> names = new ArrayList<>();
        Iterator<MenuItem> i = m.createIterator();
        while(i.hasNext()){
            names.add(i.next().getName());
        }
        while(it.hasNext()){
            MenuItemRecord temp = it.next();
            if(names.contains(temp.name())){
                breakfast.add(temp);
            }
        }
        return breakfast;
    }
    @RequestMapping("/lunch")
    @GetMapping
    public List<MenuItemRecord> getLunch(){
        DinerMenu m = new DinerMenu("DINER MENU", "Lunch");
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        CompositeIterator<MenuItemRecord> it = new CompositeIterator<>();
        it.add(items.iterator());
        List<MenuItemRecord> lunch = new ArrayList<>();
        List<String> names = new ArrayList<>();
        Iterator<MenuItem> i = m.createIterator();
        while(i.hasNext()){
            names.add(i.next().getName());
        }
        while(it.hasNext()){
            MenuItemRecord temp = it.next();
            if(names.contains(temp.name())){
                lunch.add(temp);
            }
        }
        return lunch;
    }
    @RequestMapping("/supper")
    @GetMapping
    public List<MenuItemRecord> getSupper(){
        CafeMenu m = new CafeMenu("CAFE MENU", "Dinner");
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        CompositeIterator<MenuItemRecord> it = new CompositeIterator<>();
        it.add(items.iterator());
        List<MenuItemRecord> supper = new ArrayList<>();
        List<String> names = new ArrayList<>();
        Iterator<MenuItem> i = m.createIterator();
        while(i.hasNext()){
            names.add(i.next().getName());
        }
        while(it.hasNext()){
            MenuItemRecord temp = it.next();
            if(names.contains(temp.name())){
                supper.add(temp);
            }
        }
        return supper;
    }
}
