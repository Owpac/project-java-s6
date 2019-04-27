import java.util.Objects;

public abstract class Human implements Cloneable {
    protected String firstName;
    protected String lastName;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "(" + firstName + ", " + lastName + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Human human = (Human) o;
        return Objects.equals( firstName, human.firstName ) && Objects.equals( lastName, human.lastName );
    }

    @Override
    public int hashCode() {
        return Objects.hash( firstName, lastName );
    }

    @Override
    public Human clone() throws CloneNotSupportedException {
        return (Human) super.clone();
    }
}
