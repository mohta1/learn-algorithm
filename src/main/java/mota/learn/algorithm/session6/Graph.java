/*
package mota.learn.algorithm.session6;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Graph {

    static Person mohsen;
    static Person alice;
    static Person bob;
    static Person claire;
    static Person anuj;
    static Person peggy;
    static Person thom;
    static Person jonny;
    static Map<Person, Person[]> graphMap = new HashMap();
    static LinkedBlockingQueue<Person> personQueue = new LinkedBlockingQueue();
    static List<Person> searchedPerson = new ArrayList();

    public static void main(String[] args) {
        init();

        Person person = searchQueue();

        if (person == null){
            System.out.println("There is not mango seller!");
        } else {
            System.out.println(person.name + " is mango seller!");
        }
    }

    private static Person searchQueue(){
        personQueue.addAll(Arrays.asList(graphMap.get(mohsen)));

        while (!personQueue.isEmpty()){
            Person person = personQueue.poll();

            if (searchedPerson.contains(person))
                continue;

            if (person.isMangoSeller){
                return person;
            } else {
                personQueue.addAll(Arrays.asList(graphMap.get(person)));
            }

            searchedPerson.add(person);
        }
        return null;
    }

    private static void init (){
        mohsen = new Person("Mohsen", false);
        alice = new Person("Alice", false);
        bob = new Person("Bob", false);
        claire = new Person("Claire", false);
        anuj = new Person("Anuj", false);
        peggy = new Person("Peggy", false);
        thom = new Person("Thom", true);
        jonny = new Person("Jonny", false);

        graphMap.put(mohsen, new Person[]{alice, bob, claire});
        graphMap.put(bob, new Person[]{anuj, peggy});
        graphMap.put(alice, new Person[]{peggy});
        graphMap.put(claire, new Person[]{thom, jonny});
        graphMap.put(anuj, new Person[0]);
        graphMap.put(peggy, new Person[]{mohsen});
        graphMap.put(thom, new Person[0]);
        graphMap.put(jonny, new Person[0]);
    }

}
*/
