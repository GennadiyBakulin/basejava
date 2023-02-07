import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        if (size == 0) {
            storage[0] = r;
            size++;
            return;
        }

        if (size >= STORAGE_LIMIT) {
            System.out.println("Превышено максимальное количество Резюме в базе");
            return;
        }

        int index = getIndex(r.getUuid());

        if (index >= 0) {
            System.out.println("Резюме с uuid=" + r.getUuid() + " в базе уже сущуствует");
            return;
        }

        index = Math.abs(index) - 1;

        if (index == size) {
            storage[size] = r;
        } else {
            Resume[] temp = Arrays.copyOfRange(storage, index, size);
            storage[index] = r;
            System.arraycopy(temp, 0, storage, index + 1, temp.length);
        }
        size++;
    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("Резюме с uuid=" + r.getUuid() + " в базе не найдено!");
        } else {
            storage[index] = r;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Резюме с uuid=" + uuid + " в базе не найдено!");
        } else {
            Resume[] temp = Arrays.copyOfRange(storage, index + 1, size);
            System.arraycopy(temp, 0, storage, index, temp.length);
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
