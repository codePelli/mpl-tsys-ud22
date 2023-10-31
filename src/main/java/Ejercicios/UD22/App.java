package Ejercicios.UD22;

import Ejercicios.UD22.Controller.ControllerConnect;
import Ejercicios.UD22.View.ViewConnect;

/**
 * Hello world!
 *
 */
public class App{
	
    public static void main( String[] args ){
    	
        ViewConnect vc = new ViewConnect();
    	ControllerConnect cc = new ControllerConnect(vc);
    	
    	
    	
    }
}
