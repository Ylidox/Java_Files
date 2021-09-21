package parser;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PageParser {
    
    public PageParser(){
        
    }
    
    public void addCity(String name, String url){
        try{
            String[] str = getDataFromYandex(url);
            saveData(name, str[0], str[1]);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    private void saveData(String city, String dateTime, String temp){
        FileManager fileManager = new FileManager("dataBase.txt");
        fileManager.write(city);
        fileManager.write(dateTime);
        fileManager.write(temp);
    }
    
    private String[] getDataFromYandex(String url) throws Exception{
        Document document = Jsoup
                .connect(url)
                .get();
        Elements days = document.select("div.swiper-slide");
        String times =  days.select("a > time").text();
        String temp = days.select("a > div.forecast-briefly__temp_day > span.temp__value").text();
        
        String[] time = times.split(" ");
        String dateTime = "";
        for(int i = 0; i < time.length; i += 2){
            dateTime += time[i] + time[i + 1] + "  ";
        }

        return new String[]{dateTime, temp};
    }
}
