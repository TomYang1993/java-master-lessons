package yxy.tom.yang;

public class StringListItem extends ListItem {

    public StringListItem(String value) {
        this.value = value;
        this.previous = null;
        this.next = null;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public ListItem getPrevious() {
        return this.previous;
    }

    @Override
    public ListItem getNext() {
        return this.next;
    }

    @Override
    public void setPrevious(ListItem item) {
        this.previous = item;
    }

    @Override
    public void setNext(ListItem item) {
        this.next = item;
    }

    @Override
    public int compareTo(ListItem item) {
        return this.getValue().compareTo(item.getValue());
    }
}
