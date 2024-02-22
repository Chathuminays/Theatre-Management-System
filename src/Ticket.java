public class Ticket {
           // Initialize variables as private.
    private int row;
    private int seat;
    private double price;
    Person person;

    public Ticket(int row,int seat,double price,Person person){        // building the constructor for Ticket class.
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    public void print(){                                     // print ticket information after successfully purchased a ticket.
        System.out.println("Name    : " + getName());
        System.out.println("Surname : " + getSurName());
        System.out.println("Email   : " + getEmail());
        System.out.println("Successfully bought a ticket for row: " + this.row + " seat: " + this.seat + " for: £" + this.price );

    }
    public int getRaw_no(){            // getter method to get row number
        return this.row;
    }
    public int getSeat_no(){          // getter method to get seat number
        return this.seat;
    }
    public Double getPrice(){          // getter method to get price
        return this.price;
    }
    public String getName(){           // getter method to get name in person object.
        return person.getName();
    }
    public String getSurName(){           // getter method to get surname in person object.
        return person.getSurname();
    }
    public String getEmail(){                // getter method to get email in person object.
        return person.getEmail();
    }
}
