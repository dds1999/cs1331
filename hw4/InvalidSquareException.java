/**
* Exception caused by entering an invlaid square value (out of bounds)
* I chose a checked exception because this is a user error, not a programming
* error. Furthermore, this is something I want my code to check for and handle
* before running.
*
* @author dds7
* @version 9.0.1
*/
public class InvalidSquareException extends Exception {
    /**
    * Constucts a InvalidSquareException
    * @param square String represntation invalid sqaure causing the exception
    */
    public InvalidSquareException(String square) {
        super(square);
    }
}