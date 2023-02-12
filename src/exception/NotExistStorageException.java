package exception;

public class NotExistStorageException extends StorageException{

    public NotExistStorageException(String uuid) {
        super("Резюме с uuid=" + uuid + " в базе не найдено!", uuid);
    }
}
