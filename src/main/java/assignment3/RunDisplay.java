package assignment3;

public class RunDisplay {

    public static void main(String[] args){
        try{
            Displayer paintGui = new Displayer();
        }catch (Exception e){
            System.err.println("GUI closed from error");
        }
    }
}
