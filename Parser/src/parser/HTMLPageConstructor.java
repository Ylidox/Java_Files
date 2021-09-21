package parser;

public class HTMLPageConstructor {
    private String fileName;
    public HTMLPageConstructor(String path){
        fileName = path;
    }
    private String createHead(){
        return  "<!DOCTYPE html>\n" +
                "<html lang=\"ru\">\n" +
                "<head>\n" +
                "	<meta charset=\"UTF-8\">\n" +
                "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "	<title>Weather</title>\n" +
                "	<link rel=\"stylesheet\" href=\"style.css\">\n" +
                "</head>";
    }
    private String createFooter(){
        return  "<script src=\"dataOfCitys.js\"></script>\n" +
                "<script src=\"script.js\"></script>\n" +
                "</html>";
    }
    private String createBody(){
        String output = "<body>\n" +
                    "	<div class=\"header\">\n" +
                    "		<h1>Погода</h1>\n" +
                    "		<hr>\n" +
                    "	</div>\n" +
                    "	<div class=\"main\">";
        FileManager fa = new FileManager("dataBase.txt");
        String[] data = fa.read();
        
        for(int i = 0; i < data.length; i += 3){
            output += createCity(data[i], data[i + 1].split("  "), data[i + 2].split(" "));
        }
        
        output += "</div>\n" +
                "	<div class=\"footer\">\n" +
                "		\n" +
                "	</div>\n" +
                "\n" +
                "</body>";
        
        return output;
    }
    private String createCity(String city, String[] days, String[] temp){
        String output = "<div class=\"city\">\n" +
                        "<h3>" + city + "</h3>\n" +
                            "<div class=\"days\">";
        for(int i = 0; i < 8; i++){
            output += "<div class=\"day\">\n" +
                        "<span>" + days[i] + "</span>\n" +
                        "<span class=\"temp\">" + temp[i] + "</span>\n" +
                       "</div>";
        }
        
        output += "</div>\n" +
                "</div>";
        
        return output;
    }
    private String createJSData(){
        FileManager fa = new FileManager("dataBase.txt");
        String[] data = fa.read();
        
        String output = "const Citys = {";
        int count = 0;
        for(int i = 0; i < data.length; i += 3){
            output += "" + count + ":";
            output += "['" + data[i + 1] + "'.split('  '),\n";
            output += "'" + data[i + 2] + "'.split(' ')],\n";
            count++;
        }
        output += "}";
        
        return output;
    }
    
    public void createPage(){
        FileManager page = new FileManager("page/main.html");
        page.clear();
        
        FileManager js = new FileManager("page/dataOfCitys.js");
        js.clear();
        
        String output = createHead() + createBody() + createFooter();
        page.write(output);
        js.write(createJSData());
//        System.out.println(output);
//        return output;
    }
}
