import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size - 1, null);
        size = 0;
    }

    void save(Resume r) {
        int index = isFindResume(r.uuid);
        if (index == -1 && size < storage.length) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Error");
        }
    }

    void update(Resume r) {
        int index = isFindResume(r.uuid);
        if (index != -1) {
            storage[index] = r;
        } else {
            System.out.println("Error");
        }
    }

    Resume get(String uuid) {
        int index = isFindResume(uuid);
        if (index != -1) {
            return storage[index];
        }
        return null;
    }

    void delete(String uuid) {
        int index = isFindResume(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Error");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }

    private int isFindResume(String uuid) {
        for (int index = 0; index < size; index++) {
            if (storage[index].uuid.equals(uuid)) {
                return index;
            }
        }
        return -1;
    }
}
