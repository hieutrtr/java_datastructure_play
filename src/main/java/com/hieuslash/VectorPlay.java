import java.util.Vector;

public class VectorPlay {
  public static void main(String[] args) {
    Vector v = new Vector(3,4);
    System.out.println("initial size: " + v.size());
    System.out.println("capacity: " + v.capacity());
    v.addElement(new Integer(1));
    v.addElement(new Integer(1));
    v.addElement(new Integer(1));
    v.addElement(new Integer(1));
    System.out.println("Capacity after four editions: " + v.capacity());
    v.addElement("hello");
    System.out.println("Vector can contain various data: " + v);
  }
}
