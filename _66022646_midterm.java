import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class _66022646_midterm {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int randomStation = random.nextInt(5); // Random starting station

        MRT universityLine = new MRT("UP Line", 10);

        Station upStation = new Station("UP Dorm");
        Station ictStation = new Station("ICT");
        Station ceStation = new Station("CE");
        Station ubStation = new Station("UB");
        Station pkyStation = new Station("PKY");

        universityLine.addStation(upStation);
        universityLine.addStation(ictStation);
        universityLine.addStation(ceStation);
        universityLine.addStation(ubStation);
        universityLine.addStation(pkyStation);

        universityLine.display();

        System.out.println("You are at station " + universityLine.getStationName(randomStation));
        System.out.println("Please select your destination station (Station name): ");
        String destinationStation = scanner.nextLine(); // User input for destination station

        int destinationStationNumber = universityLine.getStationNumber(destinationStation);
        
        if (destinationStationNumber == -1) {
            System.out.println("Station not found");
        } else {
            int numStations = Math.abs(destinationStationNumber - (randomStation + 1));
            int price = universityLine.calPrice(numStations);

            System.out.println("Number of stations: " + numStations);
            System.out.println("Total price: " + price);
        }
    }
}

class MRT {
    // Properties
    private String LineName;
    private int pricePerStation;
    private ArrayList<Station> Stations;

    // Constructor
    MRT(String LineName, int pricePerStation) {
        this.LineName = LineName;
        this.pricePerStation = pricePerStation;
        this.Stations = new ArrayList<>();
    }

    public void addStation(Station station) {
        this.Stations.add(station);
    }

    public int calPrice(int numStations) {
        return numStations * pricePerStation;
    }

    public void display() {
        System.out.println("Line Name: " + LineName);
        System.out.println("Price per Station: " + pricePerStation);
        System.out.println("Stations:");
        for (int i = 0; i < Stations.size(); i++) {
            System.out.println("Station Number: " + (i + 1) + "      " + "Station Name: " + Stations.get(i).getName());
        }
    }

    public void setPricePerStation(int price) {
        this.pricePerStation = price;
    }

    public int getPricePerStation() {
        return this.pricePerStation;
    }

    public String getStationName(int stationNumber) {
        if (stationNumber >= 0 && stationNumber < Stations.size()) {
            return Stations.get(stationNumber).getName();
        } else {
            return "Station not found";
        }
    }

    public int getStationNumber(String stationName) {
        for (int i = 0; i < Stations.size(); i++) {
            if (Stations.get(i).getName().equals(stationName)) {
                return i + 1;
            }
        }
        return -1;
    }

    public void setLineName(String lineName) {
        this.LineName = lineName;
    }

    public String getLineName() {
        return this.LineName;
    }

    public void addSpecificationStation(int stationNumber, Station station) {
        if (stationNumber > 0 && stationNumber <= Stations.size() + 1) {
            this.Stations.add(stationNumber - 1, station);
        }
    }
}

class Station {
    // Property
    private String Name;

    // Constructor
    Station(String Name) {
        this.Name = Name;
    }

    // Methods
    public void setName(String newName) {
        this.Name = newName;
    }

    public String getName() {
        return this.Name;
    }
}
