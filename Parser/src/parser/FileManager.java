package parser;
import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private String path;
    private File file;
    public FileManager(String str){
        setPath(str);
        file = new File(path);
    }
    public String getPath(){
        return path;
    }
    public void setPath(String s){
        path = s;
    }
    
    public void write(String str){
        try{
            if(!file.exists()) file.createNewFile();
            
            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.println(str);
            pw.close();
            
        }catch(Exception exc){
            System.out.println("Error: " + exc.getMessage());
        }
        
    }
    public void clear(){
        try{
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    public String[] read() {
        ArrayList<String> lines = new ArrayList<String>();
        try{

            FileReader file = new FileReader(path);
            BufferedReader br = new BufferedReader(file);

            String line = br.readLine();
            while(line != null) {
                lines.add(line);
                line = br.readLine();
            }
            file.close();
            br.close();
        } catch(IOException e){
            System.out.println("Error : " + e.getMessage());
        }
           
        String[] strings = new String[lines.size()];
        for(int i = 0; i < lines.size(); i++){
            strings[i] = lines.get(i);
        }
        return strings;
    }
}
