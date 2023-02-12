package exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Резюме с uuid=" + uuid + " в базе уже сущуствует", uuid);
    }
}
