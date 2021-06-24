package yxy.tom.yang;

import java.util.List;

public class mainJava {

    public static void main(){

    }

    public void saveObject(ISaveable object) {
        object.writeToList();
    }

    public void loadObject(ISaveable object){
        List<String> values = readValues();
        object.populate(values);

    }
}
