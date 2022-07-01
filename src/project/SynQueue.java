package project;

public class SynQueue {
    protected Elem first = null;
    protected Elem last = null;

    public synchronized boolean isEmpty () {
        return (first == null);
    }

    public synchronized void insert (Women w) {
        if (isEmpty()) {
            first = last = new Elem(w);
            notifyAll();
        }
        else {
            last.next = new Elem(w);
            last = last.next;
        }
    }

    public synchronized Women extract () throws InterruptedException {

        while (isEmpty())
            wait();

        Women target = first.value;
        // System.out.println("extracting " + result);

        first = first.next;
        if (first == null) last = null;
        return target;
    }
    class Elem{
        Women value;
        Elem next;
        Elem(Women w){value=w;}
    }
}
