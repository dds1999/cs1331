/**
* @author dds7
* @version 9.0.1
*/
public class InvalidSquareException extends RuntimeException {
    /**
    * Constucts a InvalidSquareException
    * @param square String represntation invalid sqaure causing the exception
    */
    public InvalidSquareException(String square) {
        super(square);
    }
}