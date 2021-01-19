package prodcon;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {
    Shared s=new Shared();
    public Consumer(Shared sh){
        s=sh;
    }
    public void consume() throws InterruptedException 
        { 
            while (true) 
            { 
                synchronized (this) 
                { 
                    // consumer thread waits while list 
                    // is empty 
                    while (s.list.size()==0) 
                        wait(); 
  
                    //to retrive the ifrst job in the list 
                    int val = s.list.remove(0); 
  
                    System.out.println("Consumer consumed-"+ val); 
  
                    // Wake up producer thread 
                    notify(); 
  
                    // and sleep 
                    Thread.sleep(1000); 
                } 
            } 
        } 

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 

    
}
