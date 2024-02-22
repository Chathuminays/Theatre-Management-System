public class Person {
                // Initialize variables as private.
    private String name;
    private String surname;
    private String email;

    public Person(String name,String surname,String email){     // building the constructor for Person class.
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public String getName(){      // getter method to get name
        return this.name;
    }
    public String getSurname(){    // getter method to get surname
        return this.surname;
    }
    public String getEmail(){      // getter method to get email
        return this.email;
    }
}
