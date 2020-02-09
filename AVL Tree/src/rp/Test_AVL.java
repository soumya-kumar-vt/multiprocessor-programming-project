package rp;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test_AVL{

    private static int THREADS=16;
    static AVL_Tree tree = new AVL_Tree();
    public static int n=1000;
    static float percPut = 50;      //Percentage of Add/Remove Operations
    static float percRemove = 50;// Percentage of Contains operations
    private static final int PER_THREAD = 10000;
    static int NoofPutthreads = (int) ((percPut / 100) * THREADS);
    static int NoofRemoveThreads = (int) ((percRemove / 100) * THREADS);
    static int NoofSearchThreads=THREADS-(NoofPutthreads+NoofRemoveThreads);

   // static Thread[] testInsertion = new insertion[NoofPutthreads];
   // static Thread[] testDeletion = new remove[NoofRemoveThreads];
   // static Thread[] testSearch = new  search[NoofSearchThreads];
    public static void main(String[] args) {

        Thread[] threads = new Thread[THREADS];

        for (int i=0;i<NoofPutthreads;i++){
            threads[i] = new insertion();
        }
        for (int i=NoofPutthreads;i<NoofRemoveThreads+NoofPutthreads;i++){
            threads[i] = new remove();
        }

        for (int i=THREADS-NoofSearchThreads;i<THREADS;i++){
            threads[i] = new search();
        }


        for (int i = 0; i < THREADS; i++) {
            threads[i].start();

        }




        for (int i = 0; i < THREADS; i++) {
            try {
                threads[i].join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("Throughput: "+tree.root.Throughput);

    }



static class insertion extends Thread{
    Random rand = new Random();

    private static final int PER_THREAD =100;
   // public int value = rand.nextInt(n);

    public void run() {
        synchronized(tree){
        for (int i = 0; i < PER_THREAD; i++){
            int RandInt = ThreadLocalRandom.current().nextInt(1, n);
            if(tree.root!=null){ try {

                tree.root.getLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
            tree.root = tree.insert(tree.root, RandInt);
         //   System.out.println("insertion");
         //   tree.preOrder(tree.root);


            if(tree.root!=null)
            tree.root.ReleaseLock();
        }
    }
    }
  }

static class remove extends Thread{
    private static final int PER_THREAD =100;
    // public int value = rand.nextInt(n);

    public void run() throws NullPointerException{
        synchronized (tree) {
            for (int i = 0; i < PER_THREAD; i++) {
                int RandInt = ThreadLocalRandom.current().nextInt(1, n);
                try {
                    if (tree != null && tree.root != null)
                        tree.root.getLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tree.root = tree.deleteNode(tree.root, RandInt);
             //   System.out.println("deletion");
            //    tree.preOrder(tree.root);
                if (tree != null && tree.root != null)
                    tree.root.ReleaseLock();
            }
        }
    }

    }

    static class search extends Thread {

        public void run() throws NullPointerException {
            synchronized (tree) {
                for (int i = 0; i < PER_THREAD; i++) {
                    int RandInt = ThreadLocalRandom.current().nextInt(1, n);
                    try {
                        if (tree==null || tree.root == null){}
                        else   tree.root.getLock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tree.searchNode(tree.root, RandInt);
            //        System.out.println("searching");
                    if (tree == null || tree.root == null){}
                    else  tree.root.ReleaseLock();
                }
            }
        }
    }
}

