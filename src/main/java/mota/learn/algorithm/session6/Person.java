package mota.learn.algorithm.session6;

public class Person {
    private String name;
    private boolean isMangoSeller;
    private Person parent;

    public Person(String name, boolean isMangoSeller) {

        this.name = name;
        this.isMangoSeller = isMangoSeller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMangoSeller() {
        return isMangoSeller;
    }

    public void setMangoSeller(boolean mangoSeller) {
        isMangoSeller = mangoSeller;
    }

    public Person getParent() {
        return parent;
    }

    public void setParent(Person parent) {
        this.parent = parent;
    }
}
