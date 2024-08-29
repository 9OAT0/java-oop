import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hotel hotel = new Hotel("Hotel T");

        Room T001 = new Room("T001", true);
        Room T002 = new Room("T002", true);
        Room T003 = new Room("T003", true);

        hotel.addRoom(T001);
        hotel.addRoom(T002);
        hotel.addRoom(T003);

        hotel.Display();

        System.out.println("Enter the room to check in: ");
        String selRoom = scanner.nextLine();
        hotel.checkIn(selRoom);

        hotel.Display();

        System.out.println("Enter the room to check in: ");
        String selRoom2 = scanner.nextLine();
        hotel.checkIn(selRoom2);

        hotel.Display();

        System.out.println("Enter the room to check out: ");
        String selRoom3 = scanner.nextLine();
        hotel.checkOut(selRoom3);

        scanner.close();
    }
}

class Room {

    // Properties
    private String name;
    private Boolean status;

    // Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    // Constructor
    public Room(String name, Boolean status) {
        this.name = name;
        this.status = status;
    }
}

class Hotel {

    // Properties
    private String name;
    private ArrayList<Room> rooms = new ArrayList<>();

    // Constructor
    public Hotel(String name) {
        this.name = name;
    }

    // Methods
    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void checkIn(String roomName) {
        for (Room room : rooms) {
            if (room.getName().equals(roomName)) {
                if (room.getStatus()) {
                    room.setStatus(false);
                    System.out.println("Room " + room.getName() + " is now checked in.");
                    System.out.println(" ");
                } else {
                    System.out.println("Room " + room.getName() + " is not available.");
                    System.out.println(" ");
                }
                return;
            }
        }
        System.out.println("Room " + roomName + " does not exist.");
    }

    public void checkOut(String roomName) {
        for (Room room : rooms) {
            if (room.getName().equals(roomName)) {
                if (!room.getStatus()) {
                    room.setStatus(true);
                    System.out.println("Room " + room.getName() + " is now checked out.");
                    System.out.println(" ");
                } else {
                    System.out.println("Room " + room.getName() + " is not alredy checked in.");
                    System.out.println(" ");
                }
                return;
            }
        }
        System.out.println("Room " + roomName + " sorry we dosen't have this room.");
        System.out.println(" ");
    }

    public void Display() {
        System.out.println("Welecom to Hotel : " + this.name);
        for (Room room : this.rooms) {
            System.out.println(room.getName() + " : " + room.getStatus());
        }
        System.out.println(" ");
    }
}


// //Output
// Welecom to Hotel : Hotel T
// T001 : true
// T002 : true
// T003 : true

// Enter the room to check in:
// T001
// Room T001 is now checked in.

// Welecom to Hotel : Hotel T
// T001 : false
// T002 : true
// T003 : true

// Enter the room to check in:
// T003
// Room T003 is now checked in.

// Welecom to Hotel : Hotel T
// T001 : false
// T002 : true
// T003 : false

// Enter the room to check out:
// T001
// Room T001 is now checked out.