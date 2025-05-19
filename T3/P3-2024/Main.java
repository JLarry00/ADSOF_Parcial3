import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(new Person("Peter", 35),
                                    new Person("Paul", -4), // invalid age
                                    new Person("mary", 0)); // invalid name (should start by Upper case) and age
        System.out.println(people);
    
        Validator<Person> validator = new Validator<Person>(p -> "Person: "+p.getName())
        .withConstraint("Invalid age", p -> p.getAge()<=0, p -> p.setAge(18)) // fixes age to 18
        .withConstraint("Empty name", p -> p.getName()==null || p.getName().equals(""))//no fixer
        .withConstraint("Lower case name", // detects names in lower case, and fixes them
        p -> Character.isLowerCase(p.getName().charAt(0)),
        p -> p.setName(Character.toUpperCase(p.getName().charAt(0))+
        p.getName().substring(1)));
        try {
            validator.validateAll(people);
        } catch (ValidationException e) {
        System.err.println(e);
        }
        validator.fixAll(people); // fixes the three detected problems
        System.out.println(people);
        validator.validateAll(people); // now, no errors left
    }
}