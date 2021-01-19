package prodcon;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {
            Shared s=new Shared();
            public Producer(Shared sh){
                s=sh;
            }
            public void produce() throws InterruptedException{ 
            int value = 0; 
            while (true) { 
                synchronized (this) 
                { 
                    // producer thread waits while list 
                    // is full 
                    while (s.list.size()==s.capacity) 
                        wait(); 
  
                    System.out.println("Producer produced-"+ value); 
  
                    // to insert the jobs in the list 
                    s.list.add(value++); 
  
                    // notifies the consumer thread that 
                    // now it can start consuming 
                    notify(); 
  
                    // makes the working of program easier 
                    // to  understand 
                    Thread.sleep(1000); 
                } 
            } 
        }

    @Override
    public void run() {
                try {
                    produce();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
  
        