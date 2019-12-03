public class Person implements Comparable{
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "\n";
    }

    @Override
    public int compareTo(Object o) {
        Person other = (Person) o;
        return this.firstName.compareTo(other.firstName);
    }
}

