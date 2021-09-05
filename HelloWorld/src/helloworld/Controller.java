package helloworld;

public class Controller {
    private int count;
    private int mid;
    private int left;
    private int right;
    
    public Controller(){
        count = 0;
        mid = 50;
        left = 0;
        right = 101;
    }
    public Controller(int l, int r){
        count = 0;
        left = l;
        right = r;
        mid = this.updateMid();
    }
    
    private int updateMid(){
        return (int)(left + (right - left) / 2);
    }
    
    public int getFindValue(){
        return mid;
    }
    public int getStep(){
        return count;
    }
    
    public void findNumber(int input){
        while(mid != input){
            if(mid > input){
                right = mid;
                mid = this.updateMid();
            }
            else{
                left = mid;
                mid = this.updateMid();
            }
            count++;
        }
    }
}
