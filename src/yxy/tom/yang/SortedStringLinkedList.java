package yxy.tom.yang;

public class SortedStringLinkedList {
    ListItem head;
    ListItem current;
    int size;

    public SortedStringLinkedList() {
        this.size = 0;
    }

    public void addToList(ListItem item) {
        if(isEmpty()){
            this.head = item;
            this.current = this.head;
            size += 1;
        }else{
            boolean flag = true;
            while(flag){
                if(this.current.compareTo(item) == 0){
                    System.out.println("Item can not be added");
                    flag = false;
                }else if(this.current.compareTo(item) > 0){
                    if(this.current.next != null){
                        this.current = this.current.next;
                        flag = true;
                    }else{
                        item.setPrevious( this.current);
                        this.current.setNext(item);
                        size += 1;
                        this.current = this.head;
                        flag = false;
                    }
                }else{
                    this.current.previous.next = item;
                    this.current.previous = item.previous;
                    this.current.previous = item;
                    item.next = this.current;
                    size += 1;
                    this.current = this.head;
                    flag = false;
                }
            }
        }
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

}
