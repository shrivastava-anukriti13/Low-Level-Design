import logistics.*;
import java.lang.IllegalArgumentException;

class LogisticsFactory{
    public static Logistics getLogistics(String mode){
        if(mode.equalsIgnoreCase("Air")){
            return new Air();
        }else if(mode.equalsIgnoreCase("Road")){
            return new Road();
        }
        throw new IllegalArgumentException("Invalid mode of transportation");
    }
}