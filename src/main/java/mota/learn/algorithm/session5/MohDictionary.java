package mota.learn.algorithm.session5;

import java.util.ArrayList;
import java.util.List;

public class MohDictionary<T, V> {

    class MapItem<T, V> {
        private T key;
        private V value;

        public MapItem(T key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<MapItem<T, V>>[] items;
    private long size = 0;

    MohDictionary() {
        items = new List[100];
    }

    public void put(T key, V value) {
        int index = hash(key);
        List<MapItem<T, V>> targetList = items[index];

        if (targetList == null) {
            targetList = new ArrayList<>();
        }

        if (targetList.size() < 1) {
            targetList.add(new MapItem<>(key, value));
            size++;
        } else {
            for (MapItem<T, V> mapItem : targetList) {
                if (mapItem.key.equals(key)) {
                    mapItem.value = value;
                } else {
                    targetList.add(new MapItem<>(key, value));
                    size++;
                    break;
                }
            }
        }

        items[index] = targetList;
    }

    public V get(T key) {
        int index = hash(key);
        List<MapItem<T, V>> targetList = items[index];

        if (targetList == null)
            return null;

        for (MapItem<T, V> mapItem : targetList) {
            if (mapItem.key.equals(key)) {
                return mapItem.value;
            }
        }

        return null;
    }

    public boolean contaionsKey(T key) {
        if (get(key) == null)
            return false;
        else
            return true;
    }


    public boolean remove(T key) {
        int index = hash(key);
        List<MapItem<T, V>> targetList = items[index];

        if (targetList == null)
            return false;

        for (MapItem<T, V> mapItem : targetList) {
            if (mapItem.key.equals(key)) {
                targetList.remove(mapItem);
                size--;
                return true;
            }
        }

        return false;
    }

    public long size() {
        return size;
    }

    private int hash(T key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode - (int) (hashCode / items.length) * items.length);
    }

}
