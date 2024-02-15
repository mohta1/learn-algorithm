package mota.learn.algorithm.session5;

import java.util.*;

public class HashTableClass {



    public static void main(String[] args) throws Exception {

        Map map = new HashMap<>();
        map.size();


        MohDictionary<Object, String>mohDictionary = new MohDictionary<>();

        mohDictionary.put("foo", "11111");
        mohDictionary.put("bar", "22222");
        mohDictionary.put("baz", "33333");
        mohDictionary.put("foo", "121212");
        mohDictionary.put(12234, "foo1");
        mohDictionary.put(13234, "bar2");
        System.out.println(mohDictionary.size());
        System.out.println(mohDictionary.remove("aaaa"));
        System.out.println(mohDictionary.size());
        System.out.println(mohDictionary.remove("bar"));
        System.out.println(mohDictionary.size());

        System.out.println(mohDictionary.get("foo"));
        System.out.println(mohDictionary.get("bar"));
        System.out.println(mohDictionary.get("baz"));
        System.out.println(mohDictionary.get(13234));



    }
}
