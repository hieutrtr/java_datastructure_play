import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.Random;

class ArrayListHeapSort {
  public static void main(String[] args) {
    ArrayList<Integer> l = new ArrayList();
    addRandom100(l);
    addMore10k(l);
    long startTime = System.currentTimeMillis();
    heapIT(l);
    long heapTime = System.currentTimeMillis();
    System.out.println("Current size of list: " + l.size());
    System.out.format("Heap Sort elements from %d to %d: %d milis\n",startTime, heapTime, (heapTime - startTime));
  }

  public static void addRandom100(ArrayList<Integer> list) {
    Random rand = new Random();
    for(int i = 0; i < 100; i++) {
      list.add(rand.nextInt(9000) + 1);
    }
  }

  public static void addMore10k(ArrayList<Integer> list) {
    Random rand = new Random();
    for(int i = 0; i < 10000; i++) {
      list.add(rand.nextInt(9000) + 1);
    }
  }

  public static void heapIT(ArrayList<Integer> list) {
    int n = list.size();
    for (int i = n/2; i >=0; i--) {
      heapify(list,i,n-1);
    }

    for(int i = n-1; i >=0 ; ){
      swap(list,0,i);
      i--;
      heapify(list,0,i);
    }
  }

  public static void swap(ArrayList<Integer> list, int x, int y) {
    int temp = list.get(x);
    list.set(x, list.get(y));
    list.set(y, temp);
  }

  public static void heapify(ArrayList<Integer> list, int i, int n) {
    int left = i*2+1;
    int right = left+1;
    int max = i;
    if (left <= n && list.get(max) < list.get(left)) {
      max = left;
    }
    if (right <= n && list.get(max) < list.get(right)) {
      max = right;
    }

    if (max != i) {
      swap(list,i,max);
      heapify(list,max,n);
    }
  }
}
