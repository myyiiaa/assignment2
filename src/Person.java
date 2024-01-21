import java.util.Comparator;

class Person implements Payable, Comparable<Person> {
    private static int nextId = 1;

    private int id;
    private String name;
    private String surname;

    public Person() {
        this.id = nextId++;
    }

    public Person(String name, String surname) {
        this();
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return "Student";
    }

    @Override
    public double getPaymentAmount() {
        return 0.00; // Default payment for Person (override in Employee and Student)
    }

    @Override
    public String toString() {
        return getPosition() + ": " + id + ". " + name + " " + surname;
    }

    @Override
    public int compareTo(Person other) {
        return Comparator.comparingDouble(Person::getPaymentAmount)
                .thenComparingInt(Person::getId)
                .compare(this, other);
    }
}
