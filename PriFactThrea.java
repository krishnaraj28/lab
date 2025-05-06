import java.util.Scanner;
class Prime extends Thread{
    int start,end;
    public Prime(int start,int end){
        this.start=start;
        this.end=end;
    }
    public void run(){
        System.out.println("the prime "+start+" bw "+end);
        for(int i=start;i<end;i++){
           if(isPrime(i)){
                System.out.println(i);
           }
           System.out.println(); 
        }
    }
    boolean isPrime(int n){
        if(n<=1)
            return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
            
        }
        return true;
    }
}
public class PriFactThrea{
    public static void main(String[] args){
        Prime p1=new Prime(1,50);
        p1.start();
    }
}