package org.javaturk.oofp.ch03.math.calculator1;

public class FunctionArgumentValueException extends Exception {
 FunctionArgumentValueException(){
     super("This argument can not be passed to selected function, please try again with correct function argument:");
 }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
