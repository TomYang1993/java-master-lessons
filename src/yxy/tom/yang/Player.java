package yxy.tom.yang;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private int health;
    private String strengthLevel;
    private String weapon;

    public Player(int health, String strengthLevel, String weapon) {
        this.health = health;
        this.strengthLevel = strengthLevel;
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }

    public String getStrengthLevel() {
        return strengthLevel;
    }

    public String getWeapon() {
        return weapon;
    }

    public List<String> writeToList() {
        List<String> storeList = new ArrayList<String>();
        storeList.add("" + 100);
        storeList.add("medium");
        storeList.add("gun");
        return storeList;
    }

    public void populate(List<String> savedList){
        if(savedList.size() > 0){
            this.health = Integer.parseInt(savedList.get(0));
            this.strengthLevel = savedList.get(1);
            this.weapon = savedList.get(2);
        }
    }

}
