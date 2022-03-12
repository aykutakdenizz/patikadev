import java.util.Arrays;

public class MyList<T> {

    private T[] list;
    private int capacity;
    private int itemIndex = 0; //MAX (capacity - 1);


    public MyList() {
        this.list = this.createArray(10);
        this.capacity = 10;
    }

    public MyList(int capacity) {
        this.list = this.createArray(capacity);
        this.capacity = capacity;
    }


    public int size() {
        return this.itemIndex;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(T data) {
        if (itemIndex == capacity - 1) {
            this.realloc();
        }
        this.list[itemIndex] = data;
        itemIndex++;
    }

    public T get(int index) {
        if (index <= this.itemIndex) {
            return this.list[index];
        } else {
            return null;
        }
    }

    public T remove(int index) {
        if (index <= this.itemIndex) {
            T deletedItem = list[index];
            for (int i = index; i < this.itemIndex - 1; i++) {
                this.list[i] = this.list[i + 1];
            }
            this.itemIndex--;
            return deletedItem;
        } else {
            return null;
        }
    }

    public T set(int index, T data) {
        if (index <= this.itemIndex) {
            this.list[index] = data;
            return data;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < this.itemIndex; i++) {
            str.append(this.list[i]).append(",");

        }
        if(str.length() > 1){
            str.delete(str.length() - 1, str.length());
        }
        str.append("]");
        return str.toString();
    }

    public int indexOf(T data) {
        int index = -1;
        for (int i = 0; (i < this.itemIndex) && (index == -1); i++) {
            if (data.equals(this.list[i])) {
                index = i;
            }
        }
        return index;
    }

    public int lastIndexOf(T data) {
        int index = -1;
        for (int i = this.itemIndex - 1; (i > 0) && (index == -1); i--) {
            if (data.equals(this.list[i])) {
                index = i;
            }
        }
        return index;
    }

    public boolean isEmpty() {
        return this.itemIndex == 0;
    }

    public T[] toArray() {
        return Arrays.copyOf(this.list, this.itemIndex);
    }

    public void clear() {
        for (int i = 0; i < this.itemIndex; i++) {
            this.list[i] = null;
        }
        this.itemIndex = 0;
    }

    public MyList<T> subList(int start, int finish) {
        if (finish > start && start >= 0 && finish <= this.itemIndex) {
            MyList<T> subArray = new MyList<>(finish - start + 1);
            for (int i = start; i <= finish; i++) {
                subArray.add(this.list[i]);
            }
            return subArray;
        } else {
            return null;
        }
    }

    public boolean contains(T data) {
        boolean isContain = false;
        for (int i = 0; i < (this.itemIndex) && (!isContain); i++) {
            if (this.list[i].equals(data)) {
                isContain = true;
            }
        }
        return isContain;
    }

    private void realloc() {
        int oldLength = this.getCapacity();
        T[] newList = this.createArray(oldLength * 2);
        System.arraycopy(this.list, 0, newList, 0, oldLength);
        this.capacity = oldLength * 2;
        this.list = newList;
    }

    @SuppressWarnings("unchecked")
    private T[] createArray(int length) {
        return (T[]) new Object[length];
    }

}
