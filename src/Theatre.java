import java.io.File;                       
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Theatre {
         //Initialize three global integer arrays to store rows information.
    public static int[] row_1;
    public static int[] row_2;
    public static int[] row_3;

        //Initialize global array list to store tickets.
    public static ArrayList<Ticket> ticketList;
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
                //Make three arrays free with 0 in the beginning of the program
        row_1 = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        row_2 = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        row_3 = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        ticketList = new ArrayList<>();

        System.out.println("------------ Welcome to New Theatre ------------");
        int option = 0;
        do {
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println("Please Select an Option:");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("    0) Quit");
            System.out.print("\nEnter an option: ");

                 //Validating option as an integer
            if (!input.hasNextInt()) {
                System.out.println("\nInvalid input, Please enter an integer");
                input.next();
                continue;
            }
            option = input.nextInt();
                switch (option){
                    case 1:
                        // to call buy_ticket method
                        buy_ticket();
                        break;
                    case 2:
                        // to call print_seating_area method
                        print_seating_area();
                        break;
                    case 3:
                        // to call cancel_ticket method
                        cancel_ticket();
                        break;
                    case 4:
                        // to call show_available method
                        show_available();
                        break;
                    case 5:
                        // to call saveToFile method
                        saveToFile();
                        break;
                    case 6:
                        // to call loadFromFile method
                        loadFromFile();
                        break;
                    case 7:
                        // to call show_tickets_info method
                        show_tickets_info(ticketList);
                        break;
                    case 8:
                        // to call sort_tickets method
                        sort_tickets();
                        break;
                    case 0:
                        // to end the new theatre program
                        System.out.println("Program end .... \nThank you for using New Theatre program");
                        break;
                    default:
                        // to validate whether user input in range.
                        System.out.println("Invalid Option");
                        System.out.println(" ");
                }
            }
        while (option != 0);
    }

    // To get and validate row and seat number as a user input
    private static int[] getRowSeat() {
        int[] inputRowSeat = new int[2];  //Initialize input detail array as size 2.
        while (true) {
            System.out.print("\nEnter row number: ");
            if (!input.hasNextInt()) {      // validating row number as an integer
                System.out.println("Invalid input, Enter an integer");
                input.next();
                continue;
            }
            int rowNo = input.nextInt();
            if (rowNo < 1 || rowNo > 3) {      // validating row number in range 1-3.
                System.out.println("Invalid row number");
            }
            else {
                inputRowSeat[0] = rowNo;
                while (true) {
                    System.out.print("Enter seat number: ");
                    if (!input.hasNextInt()) {      // validating seat number as an integer
                        System.out.println("Invalid input, Enter an integer");
                        input.next();
                        continue;
                    }
                    int seatNo = input.nextInt();
                            // validating seat number in range according to row.
                    if (rowNo == 1 && (seatNo < 1 || seatNo > 12)) {
                        System.out.println("Enter a number between 1 - 12");
                    }
                    else if (rowNo == 2 && (seatNo < 1 || seatNo > 16)) {
                        System.out.println("Enter a number between 1 - 16");
                    }
                    else if (rowNo == 3 && (seatNo < 1 || seatNo > 20)) {
                        System.out.println("Enter a number between 1 - 20");
                    }
                    else {
                        inputRowSeat[1] = seatNo;
                        break;
                    }
                }
                return inputRowSeat;      // return input details array.
            }
        }
    }
    private static void buy_ticket(){
        System.out.println("--- Buy Ticket ---");
        System.out.println(" Row 1 = 12 seats");         // Showing the user about seats information.
        System.out.println(" Row 2 = 16 seats");
        System.out.println(" Row 3 = 20 seats");
        int rowNO;
        int seatNo;
        int[] rowSeatInput = getRowSeat();    // call getRowSeat method to get row and seat number inputs.
        rowNO = rowSeatInput[0];
        seatNo = rowSeatInput[1] - 1;
        if (rowNO == 1){
            if (row_1[seatNo] == 0) {       // checking whether the seat is available or not.
                row_1[seatNo] = 1;          // make seat as reserved.
                System.out.println("This seat is available to buy\n");
            }
            else{
                System.out.println("This seat is already reserved\n");
                return;
            }
        }
        else if(rowNO == 2){
            if (row_2[seatNo] == 0) {
                row_2[seatNo] = 1;        // make seat as reserved.
                System.out.println("This seat is available to buy\n");
            }
            else{
                System.out.println("This seat is already reserved\n");
                return;
            }
        }
        else {
            if (row_3[seatNo] == 0) {
                row_3[seatNo] = 1;     // make seat as reserved.
                System.out.println("This seat is available to buy\n");
            }
            else{
                System.out.println("This seat is already reserved\n");
                return;
            }
        }
        input.nextLine();
        String name;
        while(true) {
            System.out.print("Enter your name: ");
            name = input.nextLine();
            if (name.matches("[a-zA-Z]+")) {    // validating name as in correct type
                break;
            }
            else {
                System.out.println("Enter a valid name");
            }
        }
        String surname;
        while(true) {
            System.out.print("Enter your surname: ");
            surname = input.nextLine();
            if (surname.matches("[a-zA-Z]+")){         // validating surname as in correct type
                break;
            } else {
                System.out.println("Enter a valid surname");
            }
        }

        String email;
        while (true) {
            System.out.print("Enter your Email: ");
            email = input.nextLine();
                    // validating email as in correct format.
            if (email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                break;
            } else {
                System.out.println("Invalid email format. Please enter a valid email address.");
            }
        }
        Person customer = new Person(name, surname, email);   // passing person data to constructor in Person class.
        double price;
        while (true){
            System.out.print("Enter a price for ticket: ");
            if (!input.hasNextDouble()){              // validating price as in correct type.
                System.out.println("Enter a valid price");
                input.next();
                continue;
            }
            price = input.nextDouble();
            break;
        }
        Ticket ticket = new Ticket(rowNO,seatNo+1,price,customer);   // passing ticket data to constructor in Ticket class.
        ticketList.add(ticket);   // Add ticket to array list .
        System.out.println(" ");
        ticket.print();   // print the ticket information bought by user.

    }
    private static void print_seating_area(){
        System.out.println("--- Print Seating Area ---\n");
                // Print stage.
        System.out.println("       ***********");
        System.out.println("       *  STAGE  *");
        System.out.println("       ***********");

        System.out.print("      ");
        for (int i=0;i< row_1.length;i++){   // Print row 1.
            if (i == 6){
                System.out.print(" ");
            }
            if (row_1[i] == 1){
                System.out.print("X");
            }
            else {
                System.out.print("O");
            }
        }
        System.out.print("\n    ");
        for (int i=0;i< row_2.length;i++){  // Print row 2.
            if (i == 8){
                System.out.print(" ");
            }
            if (row_2[i] == 1){
                System.out.print("X");
            }
            else {
                System.out.print("O");
            }
        }
        System.out.print("\n  ");
        for (int i=0;i< row_3.length;i++){   // Print row 3.
            if (i == 10){
                System.out.print(" ");
            }
            if (row_3[i] == 1){
                System.out.print("X");
            }
            else {
                System.out.print("O");
            }
        }
        System.out.println(" ");
    }
    private static void cancel_ticket(){
        System.out.println("--- Cancel Ticket ---");
        int[] rowSeatInput = getRowSeat();     // call getRowSeat method to get row and seat number inputs.
        int rowNo = rowSeatInput[0];
        int seatNo = rowSeatInput[1]-1;
        for (Ticket ticket : ticketList) {      // checking whether ticket matches with a ticket in arraylist.
            if (ticket.getRaw_no() == rowNo && ticket.getSeat_no() == seatNo+1) {
                ticketList.remove(ticket);     // remove ticket from arraylist.
                break;
            }
        }

        if (rowNo == 1){
            if (row_1[seatNo] == 1) {
                row_1[seatNo] = 0;            //making the seat available again
                System.out.println("Successfully canceled the ticket");
            }
            else{
                System.out.println("This seat is not reserved");
            }
        }
        else if(rowNo == 2){
            if (row_2[seatNo] == 1) {
                row_2[seatNo] = 0;     //making the seat available again
                System.out.println("Successfully canceled the ticket");
            }
            else{
                System.out.println("This seat is not reserved");
            }
        }
        else {
            if (row_3[seatNo] == 1) {
                row_3[seatNo] = 0;       //making the seat available again
                System.out.println("Successfully canceled the ticket");
            }
            else{
                System.out.println("This seat is not reserved");
            }
        }
    }
    private static void show_available(){
        System.out.println("--- Show Available ---");
        System.out.print("\nSeats available in row 1: ");
        for (int i = 0; i < row_1.length; i++) {       // prints available seat in row 1.
            if (row_1[i] == 0) {
                System.out.print(i + 1);
                if (i == 11) {
                    System.out.print(".");
                } else {
                    System.out.print(", ");
                }
            }
            else {
                System.out.print("*, ");     // marking reserved seat as *
            }
        }
        System.out.println(" ");
        System.out.print("Seats available in row 2: ");
        for (int i = 0; i < row_2.length; i++) {          // prints available seat in row 2.
            if (row_2[i] == 0) {
                System.out.print(i + 1);
                if (i == 15) {
                    System.out.print(".");
                } else {
                    System.out.print(", ");
                }
            }
            else {
                System.out.print("*, ");       // marking reserved seat as *
            }
        }
        System.out.println(" ");
        System.out.print("Seats available in row 3: ");
        for (int i = 0; i < row_3.length; i++) {      // prints available seat in row 3.
            if (row_3[i] == 0) {
                System.out.print(i + 1);
                if (i == 19) {
                    System.out.print(".");
                } else {
                    System.out.print(", ");
                }
            }
            else {
                System.out.print("*, ");       // marking reserved seat as *
            }
        }
        System.out.println(" ");
    }
    private static void saveToFile(){
        System.out.println("--- Save To File ---\n");
        try {
            File book = new File("ArrayData.txt");   // create ArrayData.txt file
            boolean file_created = book.createNewFile();     // checking whether file is created
            boolean file_exists = book.exists();             // checking whether file exists
            if (file_created || file_exists) {
                FileWriter writer = new FileWriter("ArrayData.txt");
                      // writhe rows information to the file.
                for (int element : row_1) {
                    writer.write(element + " ");
                }
                writer.write("\n");
                for (int element : row_2) {
                    writer.write(element + " ");
                }
                writer.write("\n");
                for (int element : row_3) {
                    writer.write(element + " ");
                }
                writer.close();
                System.out.println("Array Data successfully save to file ...");
            }
        } catch (Exception e) {          // handling errors when occurred.
            System.out.println("Error while writing to a file");
            e.printStackTrace();
        }
    }
    private static void loadFromFile(){
        System.out.println("--- Load From File ---\n");
        try {
            File book = new File("ArrayData.txt");
            boolean file_exists = book.exists();     // checking whether the file is exists.
            if (file_exists) {
                Scanner read = new Scanner(book);
                    // read data in file and replace three arrays with saved information.
                for (int i = 0; i < row_1.length; i++) {
                    int seat = read.nextInt();
                    row_1[i] = seat;
                }
                for (int i = 0; i < row_2.length; i++) {
                    int seat = read.nextInt();
                    row_2[i] = seat;
                }
                for (int i = 0; i < row_3.length; i++) {
                    int seat = read.nextInt();
                    row_3[i] = seat;
                }
                read.close();
                System.out.println("Saved Array Data successfully loaded ...");
                System.out.println(" ");
                print_seating_area();    // to display loaded data.
            }
            else {
                System.out.println("File not found");
            }
        }
        catch (IOException e) {        // to handle an error when occurred.
            System.out.println("Error while reading the file.");
            e.printStackTrace();
        }
    }
    private static void show_tickets_info(ArrayList<Ticket> infoList){
        double total = 0.0;
        System.out.println("-------------------------  Ticket information  ------------------------------");
                // making show ticket information format with printf method.
        System.out.printf("%-10s%-10s%-11s%-15s%-17s%-15s\n", "Price","Row","Seat","Name","Surname","Email");
        for (Ticket ticket : infoList) {
            System.out.printf("%s%-10.2f%-10d%-10d%-15s%-17s%-15s\n", "£", ticket.getPrice(), ticket.getRaw_no(), ticket.getSeat_no(),ticket.getName(), ticket.getSurName(), ticket.getEmail());
            total += ticket.getPrice();    // updating total with price values.
        }
        System.out.println("\nTotal Amount = £" + total);
    }
    private static void sort_tickets(){
        System.out.println("--- Sort Tickets ---");
           // making a copy of original arraylist to sort.
        ArrayList<Ticket> sortedList = mergeSort(ticketList,0, ticketList.size()-1);
        show_tickets_info(sortedList);   // call merge sort algorithm to sort ticket info in ascending order.
    }
    private static ArrayList<Ticket> mergeSort (ArrayList<Ticket> unSortedList, int start, int end) {
        ArrayList<Ticket> sortedList = new ArrayList<>();
        if (start<end){
            int mid = (start+end)/2;
            ArrayList<Ticket> leftArray = mergeSort(unSortedList, start, mid);        // Sort the left half of the arraylist recursively
            ArrayList<Ticket> rightArray = mergeSort(unSortedList, mid+1, end);    // Sort the right half of the arraylist recursively
            sortedList = merge(leftArray,rightArray);         // Merge the two halves of the arraylist
        }
        else{
            sortedList.add(unSortedList.get(start));
        }
        return sortedList;
    }
    private static ArrayList<Ticket> merge(ArrayList<Ticket> left_array,ArrayList<Ticket> right_array){
        ArrayList<Ticket> merged = new ArrayList<>();
        int i=0; int j=0; int k=0;

        while (i< left_array.size() && j< right_array.size()){
            if (left_array.get(i).getPrice()<= right_array.get(j).getPrice()){
                merged.add(left_array.get(i));
                i++;
            }
            else{
                merged.add(right_array.get(j));
                j++;
            }
            k++;
        }
        while (i< left_array.size()){
            merged.add(k, left_array.get(i));
            i++;
            k++;
        }
        while (j< right_array.size()){
            merged.add(k, right_array.get(j));
            j++;
            k++;
        }
        return merged;
    }

}
