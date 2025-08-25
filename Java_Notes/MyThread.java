import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sun.source.doctree.SeeTree;

public class MyThread extends Thread{
    private static Random random = new Random();


    public MyThread(String threadName)
    {   super(threadName);   }
    
    @Override
    public void run(){
        try{
            for(int i = 0; i < 8; i++)
            {
                System.out.printf("Thread: %s(%d) | i= %d \n", getName(), threadId(), i);
                Thread.sleep(random.nextInt(10));
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {

        MyThreadFactory threadFactory = new MyThreadFactory();
        List<Thread> threads = new ArrayList<>();
        threads.add(threadFactory.startThread("Thread 1"));
        threads.add(threadFactory.startThread("Thread 2"));
        threads.add(threadFactory.startThread("Thread 3"));
        // Thread t2 = Thread.ofPlatform()
        //                 .name("Thread 2")
        //                 .start(() -> System.out.println("Thread from ThreadFactory."));
        // threads.add(t1);
        // threads.add(new MyThread("Thread 2"));
        // threads.add(new MyThread("Thread 3"));
        // threads.add(new MyThread("Thread 4"));

        for(Thread t : threads)
        {
            try {
                t.join();
                // System.out.println("Thread Completed: " + t.getName() + "\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        System.out.println("Main Thread");
    }
}


class MyThreadFactory{
    public Thread startThread(String threadName){
        MyThread t = new MyThread(threadName);
        t.start();
        return t;
    }
}