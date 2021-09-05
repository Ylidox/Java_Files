package helloworld;

public class mainClass {
    public static void main(String[] args) {
        
        Model m = new Model();
        View v = new View();
        Controller c = new Controller();
        
        m.correctInput();
        c.findNumber(m.getValue());
        
        m.setValue(c.getFindValue());
        m.setStep( c.getStep());
        v.println("Find : " + m.getValue());
        v.println("Step : " + m.getStep());
    }
}
