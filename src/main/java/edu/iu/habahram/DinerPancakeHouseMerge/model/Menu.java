package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent{
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public MenuItem[] getItems() {
        ArrayList<MenuItem> items = new ArrayList<>();
        for (MenuComponent menuComponent : menuComponents) {
            if(menuComponent instanceof MenuItem) {
                items.add((MenuItem) menuComponent);
            }else{
                if(menuComponent instanceof Menu){
                    MenuItem[] temp = menuComponent.getItems();
                    for(MenuItem menuItem : temp){
                        items.add(menuItem);
                    }
                }
            }
        }
        return items.toArray(new MenuItem[0]);
    }
}
