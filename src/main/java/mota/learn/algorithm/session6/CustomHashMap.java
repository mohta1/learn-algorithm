package mota.learn.algorithm.session6;

import java.util.HashMap;

public class CustomHashMap extends HashMap {

    @Override
    public Object put(Object key, Object value) {

        if (value instanceof Person[]){
            for (Person person : (Person[]) value) {
                person.setParent((Person) key);
            }
        }

        return super.put(key, value);
    }
}
