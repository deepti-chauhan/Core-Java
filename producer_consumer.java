package MultiThreading;

class userData {
    int value = 0;
    boolean flag = true;

    synchronized public void setValue(int v){

        while(!flag){
            try{
                wait();
            } catch (Exception ignored){}
        }

        value = v;
        flag = false;
        notify();
    }

    synchronized public int getValue(){

        while(flag){
            try{
                wait();
            } catch (Exception ignored){}
        }
        flag = true;
        notify();

        return value;
    }
}

class Producer extends Thread{
    userData data;

    public Producer(userData d){
        this.data = d;
    }

    public void run(){
        int count = 1;
        while(true){
            data.setValue(count);
            System.out.println("Producer : "+count);
            count++;
        }
    }
}

class Consumer extends Thread{
    userData data;

    public Consumer(userData d){
        this.data = d;
    }

    public void run(){
        int value;
        while(true){
            value = data.getValue();
            System.out.println("Consumer : "+value);
        }
    }
}

public class interThreadComm {
    public static void main(String[] args){
        userData dat = new userData();
        Producer p = new Producer(dat);
        Consumer c = new Consumer(dat);

        p.start();
        c.start();

    }
}
