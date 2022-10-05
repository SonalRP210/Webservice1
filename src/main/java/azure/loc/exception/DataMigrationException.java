package azure.loc.exception;

public class DataMigrationException extends RuntimeException{

    private static final long serialVersionUID = -4250165639887604630L;

    public DataMigrationException(String message){
        super(message);
    }
}
