package yxy.tom.yang;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {

    private int health;
    private String strengthLevel;

    public Monster(int health, String strengthLevel) {
        this.health = health;
        this.strengthLevel = strengthLevel;
    }

    public int getHealth() {
        return health;
    }

    public String getStrengthLevel() {
        return strengthLevel;
    }

    public List<String> writeToList() {
        List<String> storeList = new ArrayList<String>();
        storeList.add("" + 100);
        storeList.add("medium");
        return storeList;
    }

    public void populate(List<String> savedList){
        if(savedList.size() > 0){
            this.health = Integer.parseInt(savedList.get(0));
            this.strengthLevel = savedList.get(1);
        }
    }
}
