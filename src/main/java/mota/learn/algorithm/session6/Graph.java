package mota.learn.algorithm.session6;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Graph {

    private static Person mohsen;
    private static Person alice;
    private static Person bob;
    private static Person claire;
    private static Person anuj;
    private static Person peggy;
    private static Person thom;
    private static Person jonny;
    private static Map<String, Person[]> graphMap = new HashMap();
    private static LinkedBlockingQueue<Person> personQueue = new LinkedBlockingQueue();
    private static List<Person> searchedPerson = new ArrayList();
    private static StringBuilder path = new StringBuilder();

    public static void main(String[] args) throws InterruptedException {
        init();

        Person person = searchQueue();

        if (person == null){
            System.out.println("There is not mango seller!");
        } else {
            System.out.println(person.getName() + " is mango seller!");
        }


        person = searchQueueWithPath();

        if (person == null){
            System.out.println("There is not mango seller!");
        } else {
            System.out.println(person.getName() + " is mango seller!");
            System.out.println(person.getName() + getPath(person) );
        }
    }

    private static Person searchQueue(){
        personQueue.addAll(Arrays.asList(graphMap.get(mohsen.getName())));

        while (!personQueue.isEmpty()){
            Person person = personQueue.poll();

            if (searchedPerson.contains(person))
                continue;

            if (person.isMangoSeller()){
                return person;
            } else {
                personQueue.addAll(Arrays.asList(graphMap.get(person.getName())));
            }

            searchedPerson.add(person);
        }
        return null;
    }

    private static Person searchQueueWithPath() throws InterruptedException {
        addChildsToQueue(mohsen);

        while (!personQueue.isEmpty()){
            Person person = personQueue.poll();

            if (searchedPerson.contains(person))
                continue;

            if (person.isMangoSeller()){
                return person;
            } else {
                addChildsToQueue(person);
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

        graphMap.put(mohsen.getName(), new Person[]{alice, bob, claire});
        graphMap.put(bob.getName(), new Person[]{anuj, peggy});
        graphMap.put(alice.getName(), new Person[]{peggy});
        graphMap.put(claire.getName(), new Person[]{thom, jonny});
        graphMap.put(anuj.getName(), new Person[0]);
        graphMap.put(peggy.getName(), new Person[]{mohsen});
        graphMap.put(thom.getName(), new Person[0]);
        graphMap.put(jonny.getName(), new Person[0]);
    }

    private static String getPath(Person person){
        getParent(person);

        return path.toString();
    }

    private static Person getParent(Person person){
        if (person.getParent() == null)
            return null;

        path.append("-->").append(person.getParent().getName());
        return getParent(person.getParent());
    }

    private static void addChildsToQueue(Person key) throws InterruptedException {
        Person[] persons = graphMap.get(key.getName());
        for (Person person : persons) {
            Person person1 = new Person(person.getName(), person.isMangoSeller());
            person1.setParent(key);
            personQueue.put(person1);
        }
    }
}
