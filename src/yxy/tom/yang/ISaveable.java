package yxy.tom.yang;

import java.util.List;

public interface ISaveable {

    List<String> writeToList();
    void populate(List<String> l);

}
