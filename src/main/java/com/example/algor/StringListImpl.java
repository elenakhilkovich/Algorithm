package com.example.algor;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] stringArray;

    public StringListImpl() {
        this.stringArray = new String[]{"яблоко", "груша", "апельсин"};
    }

    public String[] getArray() {
        return stringArray;
    }

    @Override
    public String add(String item) {
        String[] stringArrayTemp = new String[stringArray.length + 1];
        System.arraycopy(stringArray, 0, stringArrayTemp, 0, stringArray.length);
        stringArrayTemp[stringArrayTemp.length - 1] = item;
        stringArray = Arrays.copyOf(stringArrayTemp, stringArrayTemp.length);
        return stringArray[stringArray.length - 1];
    }

    @Override
    public String add(int index, String item) {
        if (index < stringArray.length) {
            String[] stringArrayTemp = new String[stringArray.length + 1];
            System.arraycopy(stringArray, 0, stringArrayTemp, 0, index);
            stringArrayTemp[index] = item;
            for (int i = index; i < stringArray.length; i++) {
                stringArrayTemp[i + 1] = stringArray[i];
            }
            stringArray = Arrays.copyOf(stringArrayTemp, stringArrayTemp.length);
            return stringArray[index];
        }
        throw new IndexOutOfBoundsException("Номер позиции превышает длину массива");
    }

    @Override
    public String set(int index, String item) {
        if (index < stringArray.length - 1) {
            stringArray[index] = item;
            return stringArray[index];
        }
        throw new IndexOutOfBoundsException("Номер позиции превышает длину массива");
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(item)) {
                String strRemove = stringArray[i];
                String[] stringArrayNew = new String[stringArray.length - 1];

                System.arraycopy(stringArray, 0, stringArrayNew, 0, i);
                System.arraycopy(stringArray, i + 1, stringArrayNew, i, stringArray.length - i - 1);

                stringArray = Arrays.copyOf(stringArrayNew, stringArrayNew.length);
                return strRemove;
            }
        }
        throw new IllegalArgumentException("Элемента нет в списке");
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= stringArray.length) {
            throw new IllegalArgumentException("Элемента нет в списке");
        } else {
            String strRemove = stringArray[index];
            String[] stringArrayNew = new String[stringArray.length - 1];

            System.arraycopy(stringArray, 0, stringArrayNew, 0, index);
            System.arraycopy(stringArray, index + 1, stringArrayNew, index, stringArray.length - index - 1);

            stringArray = Arrays.copyOf(stringArrayNew, stringArrayNew.length);
            return strRemove;
        }
    }

    @Override
    public boolean contains(String item) {
        for (String i : stringArray) {
            if (i.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = stringArray.length - 1; i >= 0; i--) {
            if (stringArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index > 0 && index < stringArray.length) {
            return stringArray[index];
        }
        throw new IndexOutOfBoundsException("Индекс вне фактического количества элементов");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        StringListImpl other = (StringListImpl) obj;
        return Arrays.equals(getArray(), other.getArray());
    }

    @Override
    public int size() {
        return stringArray.length;
    }

    @Override
    public boolean isEmpty() {
        return stringArray.length == 0;
    }

    @Override
    public void clear() {
        stringArray = new String[]{};
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(stringArray, stringArray.length);
    }
}






