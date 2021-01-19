package prodcon;
public class Mainmet {
    public static void main(String[] args){
     Shared d1=new Shared();
     Producer p=new Producer(d1);
     Consumer c=new Consumer(d1);
        
        Thread t1=new Thread(p);
        Thread t2=new Thread(c);
        t1.start();
        t2.start();
}
}
