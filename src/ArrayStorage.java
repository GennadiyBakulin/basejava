/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
    }

    void save(Resume r) {
        int sizeStorage = size();
        if (sizeStorage == storage.length)
            System.out.println("Превышено максимальное количество сохраняемых резюме в базе!");
        storage[sizeStorage] = r;
    }

    Resume get(String uuid) {
        int i = 0;
        while (storage[i] != null) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
            i++;
        }
        return null;
    }

    void delete(String uuid) {
        int i = 0;
        while (storage[i] != null) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                break;
            }
            i++;
        }
        while (storage[i + 1] != null) {
            storage[i] = storage[i + 1];
            storage[i + 1] = null;
            i++;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        int i = 0;
        while (storage[i] != null) {
            i++;
        }
        return i;
    }
}
