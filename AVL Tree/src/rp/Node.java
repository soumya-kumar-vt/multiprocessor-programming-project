package rp;


import java.util.concurrent.locks.ReentrantLock;

public class Node {

    int key;
    int height;
    Node left;
    Node right;

   ReentrantLock lock=new ReentrantLock();
   int Throughput=0;
    Node(int key){
        this.key = key;
        this.height=height;

    }
    public void getLock() throws InterruptedException {
        Boolean a=lock.tryLock();
        if(a){
            try{
        lock.lock();
                Throughput=Throughput+1;
            }catch (NullPointerException e){

            }


    }}

    public void ReleaseLock(){
        try {
            lock.unlock();
        }catch (NullPointerException e){

        }catch (IllegalMonitorStateException e){

        }
    }
}
