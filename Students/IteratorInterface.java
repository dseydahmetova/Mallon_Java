package Students;

import java.util.Iterator;
import java.util.Random;

public class IteratorInterface {
        public static void main(String[] args) {
            MyGenerator g = new MyGenerator();
            for(Integer i : g) {
                System.out.println(i);
            }
        }
    }

    class MyGenerator implements Iterable<Integer> {

        @Override
        public Iterator<Integer> iterator() {
            return new Generator();
        }
        private class Generator implements Iterator<Integer> {
            Random r = new Random();
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return r.nextInt();
            }
        }
    }

