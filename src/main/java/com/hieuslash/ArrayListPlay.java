import java.util.ArrayList;
import java.lang.reflect.Field;

class ArrayListPlay {
  public static final int X = 100000;
  public static void main(String[] args) throws Exception {
    ArrayList<String> l1 = new ArrayList(5); // list 1 with 5 elements
    ArrayList<String> l2 = new ArrayList(X); // list 2 with x elements
    System.out.println("\nTest with list 1");
    testCapacityLoad(l1);
    System.out.println("\nTest with list 2");
    testCapacityLoad(l2);
  }

  static void testCapacityLoad(ArrayList<String> l) throws Exception {
    System.out.println("Default capacity: " + getCapacity(l));
    long startTime = System.currentTimeMillis();
    addingEle(l,X);
    long addingTime = System.currentTimeMillis();
    System.out.format("Adding elements from %d to %d: %d milis\n",startTime, addingTime, (addingTime - startTime));
    System.out.println("Overhead capacity: " + (getCapacity(l) - l.size()));
    System.out.println("After trimming capacity: " + getCapacity(l));
  }

  static int getCapacity(ArrayList<?> l) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
  }

  static void addingEle(ArrayList<String> list, int x) {
    for(int i = 0; i < x; i++) {
      list.add("something to test");
    }
  }
}
