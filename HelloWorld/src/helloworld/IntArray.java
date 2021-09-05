package helloworld;
import java.util.*;

public class IntArray {
    private int[] intArray;
    private int size;
    public int length;
     
    public IntArray(int sizeValue){
        intArray = new int[sizeValue];
        size = sizeValue;
    }
    public IntArray(int[] arr){
        intArray = arr;
        size = arr.length;
        length = arr.length;
    }
    
    private void increaseSize(){
        int newSize = (int)(size * 1.5);
        int[] newArr = new int[newSize];
        if(length == size){
            System.arraycopy(intArray, 0, newArr, 0, length);
            intArray = newArr;
            size = newSize;
        }
    }
    
    public String toString(String d){
        String out = "[";
        for(int i = 0; i < length; i++){
            out += intArray[i];
            if(i != length - 1) out += d;
            else out += "]";
        }
        return out;
    }
    public int[] get(){
        return intArray;
    }
    public int get(int i){
        return intArray[i];
    }
    public void set(int index, int item){
        if(index < length - 1){
            intArray[index] = item;
        }
    }
    public void set(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(length < size){
                intArray[i] = arr[i];
                length++;
            }
            else{
                this.increaseSize();
                intArray[i] = arr[i];
                length++;
            }
        }
    }
    
        
    public void push(int item){
        this.increaseSize();
        intArray[length] = item;
        length++;
    }
    public int pop(){
        int out = intArray[length - 1];
        intArray[length - 1] = 0;
        length--;
        return out;
    }
    public void shift(int item){
        this.increaseSize();
        int[] newArr = new int[size];
        for(int i = 0; i < length; i++){
            newArr[i + 1] = intArray[i]; 
        }
        newArr[0] = item;
        intArray = newArr;
        length++;
    }
    public int unshift(){
        int out = intArray[0];
        int[] newArr = new int[size];
        for(int i = 1; i < length; i++){
            newArr[i - 1] = intArray[i]; 
        }
        intArray = newArr;
        length--;
        return out;
    }
    
    public int[] splice(int index, int num){
        int[] out = new int[num];
        int border = (index + num > length) ? length : index + num;
        int count = 0;
        // копируем участок массива, чтобы вернуть
        for(int i = index; i < border; i++){
            out[count] = intArray[i];
            count++;
        }
        // удаляем этот участок из исходного массива
        int[] newArr = new int[size];
        int newCount = 0;
        for(int i = 0; i < index; i++){
            newArr[newCount] = intArray[i];
            newCount++;
        }
        for(int i = border; i < length; i++){
            newArr[newCount] = intArray[i];
            newCount++;
        }
        if(index + num > length) length -= num - (index + num) + length;
        else length -= num;
        intArray = newArr;
        return out;
    }
    
    public void concat(int[] arr){
        for(int i = 0; i < arr.length; i++){
            this.push(arr[i]);
        }
    }
    
    public int includes(int item, int from){
        int out = -1;
        for(int i = from; i < length; i++){
            if(intArray[i] == item){
                out = i;
                break;
            }
        }
        return out;
    }
    public int includes(int item){
        return this.includes(item, 0);
    }
    
    public void sort(int mode){
        if(mode >= 0) Arrays.sort(intArray);
    }
}
