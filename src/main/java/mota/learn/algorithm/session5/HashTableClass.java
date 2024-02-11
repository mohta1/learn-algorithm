package mota.learn.algorithm.session5;

import java.util.*;

public class HashTableClass {



    public static void main(String[] args) throws Exception {

        Map map = new HashMap<>();
        map.size();


        MohDictionary<Object, String>mohDictionary = new MohDictionary<>();

        mohDictionary.put("Mohsen", "Taheri");
        mohDictionary.put("Sahel", "Hanife");
        mohDictionary.put("Hadi", "Mansour");
        mohDictionary.put("Mohsen", "Taheri1");
        mohDictionary.put(12234, "hiiii");
        mohDictionary.put(13234, "hiiii2");
        System.out.println(mohDictionary.size());
        System.out.println(mohDictionary.remove("aaaa"));
        System.out.println(mohDictionary.size());
        System.out.println(mohDictionary.remove("Sahel"));
        System.out.println(mohDictionary.size());

        System.out.println(mohDictionary.get("Mohsen"));
        System.out.println(mohDictionary.get("Sahel"));
        System.out.println(mohDictionary.get("Hadi"));




        /*for (int j = 0; j < 1000; j++){

            Integer i = new Random().nextInt(10000);
            System.out.println(i + " - " + (i - (int)(i / 100)*100) + " - " + i.hashCode());

            if (list.contains(i.hashCode())){
                throw new Exception("duplicate hashCode !!!!!");
            }

            list.add(i.hashCode());
        }*/
    }
}
