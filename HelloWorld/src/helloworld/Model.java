package helloworld;
import java.util.Scanner;

public class Model {
    private int value;
    private int step;
    private final View v = new View();
    
    public Model(){
        value = 0;
        step = 0;
    }
    
    public void correctInput(){
        this.inputIntNumber();
        while(value < 0 || value > 100){
            v.println("Enter a number from 0 to 100");
            this.inputIntNumber();
        }
    }
    
    public void inputIntNumber(){    
        v.print("Input a number: ");
        Scanner in = new Scanner(System.in);
        while(true){
            try{
               if(in.hasNextInt()) {
                    value = in.nextInt();
                    break;
                } else {
                   throw new java.io.IOException("You didn't enter an integer");
                } 
            }catch(java.io.IOException exc){
                in = new Scanner(System.in);
                v.println(exc.getMessage());
            }
        }
    }
    
    public int getValue(){
        return value;
    }
    public void setValue(int item){
        value = item;
    } 
    public int getStep(){
        return step;
    }
    public void setStep(int item){
        step = item;
    } 
}
