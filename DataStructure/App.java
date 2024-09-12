package DataStructure;

public class App {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();

        // Test add
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("MyArrayList: " + list.getSize());
        assert list.getSize() == 3 : "Size should be 3";
        assert list.get(1).equals(2) : "Element at index 1 should be 'two'";

        list.remove(1);
        assert list.getSize() == 2 : "Size should be 2 after removal";
        assert list.get(1).equals(3) : "Element at index 1 should be 'three' after removal";

        list.remove(1);
        assert list.getSize() == 1 : "Size should be 1 after removing 'one'";
        assert list.get(0).equals(3) : "Element at index 0 should be 'three'";

        System.out.println("All tests passed.");


        //-----------------------------Map---------------------------------------//
        MyMap<String, Integer> map = new UsingMyMap<>();

        map.insert("one", 1);
        map.insert("two", 2);
        map.insert("three", 3);

        assert map.getSize() == 3 : "Size should be 3";
        assert map.get("one") == 1 : "Value for 'one' should be 1";
        assert map.get("two") == 2 : "Value for 'two' should be 2";
        assert map.get("three") == 3 : "Value for 'three' should be 3";
        assert map.get("four") == null : "Value for 'four' should be null";

        map.insert("one", 10);
        assert map.get("one") == 10 : "Value for 'one' should be updated to 10";

        System.out.println("All tests passed.");

    }
}
