package clone;

import java.util.ArrayList;
import java.util.List;

public class CloneCollection {

    public static void main(String[] args) {
        CloneCollection collection = new CloneCollection();
        List<String> list = new ArrayList<String>();
        list.add("item1");

        collection.setElements(list);

        list.remove("item1");

        System.out.println(collection.getElements().size());

        List<String> list1 = collection.getElements();
        list1.remove("item1");
        System.out.println(collection.getElements().size());

    }


    private int size;

    public List<String> getElements() {

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < elements.size(); i++) {
            list.addAll(elements);
        }

        return list;
    }

    public void setElements(List<String> elements) {

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < elements.size(); i++) {
            list.addAll(elements);
        }

        this.elements = list;
    }

    private List<String> elements;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
