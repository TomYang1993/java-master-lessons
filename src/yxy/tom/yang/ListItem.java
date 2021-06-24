package yxy.tom.yang;

public abstract class ListItem {
    String value;
    ListItem previous;
    ListItem next;


    public abstract String getValue();

    public abstract ListItem getPrevious();
    public abstract ListItem getNext();

    public abstract void setPrevious(ListItem item);
    public abstract void setNext(ListItem item);

    public abstract int compareTo(ListItem item);

}
