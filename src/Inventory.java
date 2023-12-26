import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void additem(String name, int serialnumber,int piece) {
        Item item = new Item(name, serialnumber, piece);
        items.add(item);
    }

    public Item search(Item searchItem) {
        for (Item item : items) {
            if (searchItem.getSerialnumber() == item.getSerialnumber()) {
                return item;
            }
        }
        return null;
    }
}
