package parser;


public class Parser {

    public static void main(String[] args) throws Exception{
        FileManager fileManager = new FileManager("dataBase.txt");
        PageParser page = new PageParser();
        
        page.addCity("Зеленоград", "https://yandex.ru/pogoda/zelenograd?lat=55.991893&lon=37.214382");
        page.addCity("Москва", "https://yandex.ru/pogoda/213?via=srp");
        page.addCity("Санкт-Питербург", "https://yandex.ru/pogoda/2");
        page.addCity("Екатеринбург", "https://yandex.ru/pogoda/54");
        page.addCity("Архангельск", "https://yandex.ru/pogoda/20");
        page.addCity("Великий Новгород", "https://yandex.ru/pogoda/24");
        
        
        HTMLPageConstructor pageConstructor = new HTMLPageConstructor("dataBase.txt");
        
        
        pageConstructor.createPage();
    }
    
}
