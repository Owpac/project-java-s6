package school;

public class EvaluationDoesNotExistException extends Exception
{
    EvaluationDoesNotExistException(String message) {
        super(message);
    }
}
