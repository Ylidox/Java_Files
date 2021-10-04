package lab2v3;

public class TableManager {
    public TableManager(){
        
    }
    
    public void hello(){
        System.out.println(
"      oooOOOOOOOOOOO\"\n" +
"     o   ____          :::::::::::::::::: :::::::::::::::::: __|-----|__\n" +
"     Y_,_|[]| --++++++ |[][][][][][][][]| |[][][][][][][][]| |  [] []  |\n" +
"    {|_|_|__|;|______|;|________________|;|________________|;|_________|;\n" +
"     /oo--OO   oo  oo   oo oo      oo oo   oo oo      oo oo   oo     oo\n" +
"+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }
    
    public void showWarehouse(ProductWarehouse w){
        Product[] list = w.getProducts();
        System.out.println("----------Информация о складе----------");
        System.out.println("  Тип " + "\t\t" + " Имя" + "\t\t" + " Масса");
        for(Product p : list){
            System.out.println(p.getType() + " \t\t" + p.getName() + " \t\t" + p.getMass());
        }
    }
    
    public void showTrain(Train train){
        Wagon[] list = train.getWagons();
        System.out.println("---------------Информация о поезде---------------");
        System.out.println("№ Вагона" + "\t" + "Тип " + "\t\t" + "Имя" + "\t\t" + "Масса");
        for(int i = 0; i < list.length; i++){ 
            try{
               System.out.println("    " + (i + 1) + " \t\t" + list[i].getProduct().getType() + "    \t" + list[i].getProduct().getName() + " \t\t" + list[i].getProduct().getMass()); 
            }catch(Exception exc){
                
            }
//            System.out.println(list[i].getProduct().getType() + " \t\t" + list[i].getProduct().getName() + " \t\t" + list[i].getProduct().getMass());
        
        }
    }
}
