import java.util.Stack;

class RunnableDemo implements Runnable {

    private Thread t;

    Stack stack;
    String name;

    public void run() {
        while(!stack.isEmpty()){
            System.out.println(name + " " +stack.pop());
        }
    }

    public RunnableDemo(Stack stack, String name){
       this.stack = stack;
        this.name = name;
    }
}


class TestThread {

    public static void main(String args[]) {

        Stack stack = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);
        stack.add(7);
        stack.add(8);
        stack.add(9);

        RunnableDemo R1 = new RunnableDemo(stack,"");

        Thread t1 = new Thread(R1,"T1");
        Thread t2 = new Thread(R1,"T2");

        t1.run();
        t2.run();

    }
}