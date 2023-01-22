import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;


class Wagon {
    //создаем переменные
    private int id;
    private int capacity;
    private String type;
    private int weight;
    private int numberOfSeats;

    public Wagon(int id, int capacity, String type, int weight, int numberOfSeats) {
        this.id = id;
        this.capacity = capacity;
        this.type = type;
        this.weight = weight;
        this.numberOfSeats = numberOfSeats;
    }

    // функции геттеры для того чтобы взять информацию
    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}

class Train {
    private ArrayList<Wagon> wagons;


    public Train() {
        this.wagons = new ArrayList<>();
        wagons.add(new Wagon(1, 20, "Compartment", 15000, 24));
        wagons.add(new Wagon(2, 40, "Sitting", 20000, 40));
        wagons.add(new Wagon(3, 50, "Reserved seat", 25000, 50));
        wagons.add(new Wagon(4, 10, "Suite", 10000, 12));
    }

    public ArrayList<Wagon> getWagons() {
        return wagons;
    }

    public void printWagonInfo(int wagonId) {
        for (Wagon wagon : wagons) {
            if (wagon.getId() == wagonId) {
                System.out.println("\n\n\n\n\n\n\n\nWagon ID: " + wagon.getId());
                System.out.println("Wagon Capacity: " + wagon.getCapacity());
                System.out.println("Wagon Type: " + wagon.getType());
                System.out.println("Wagon Weight: " + wagon.getWeight());
                System.out.println("Wagon Number of Seats: " + wagon.getNumberOfSeats());
                break;
            } else {
                System.out.println("\n\n\n\n\n\n\n\nWagon not found");
            }
        }
    }

    public void addWagon(Wagon wagon) {
        wagons.add(wagon);
        System.out.println("\n\n\n\n\n\n\n\nWagon added to the train");
    }

    public void removeWagon(int id) {
        for (Wagon wagon : wagons) {
            if (wagon.getId() == id) {
                wagons.remove(wagon);
                System.out.println("\n\n\n\n\n\n\n\nWagon removed from the train");
                return;
            }
        }
        System.out.println("Wagon not found");
    }
}

public class Main {
    public static void main(String[] args) {
        Train train = new Train();
        Scanner scanner = new Scanner(System.in);
        boolean esc = false;
        while(esc!=true) {
            System.out.println("What you want?");
            System.out.println("1. See information about Wagon");
            System.out.println("2. Add wagon and information about it to the train");
            System.out.println("3. Remove wagon from train");
            System.out.println("0. Close the program");
            int choose = scanner.nextInt();
            if (choose == 0)
                esc = true;
            if (choose == 1) {
                System.out.print("Enter Wagon ID: ");
                int wagonId = scanner.nextInt();
                train.printWagonInfo(wagonId);
            }

            if (choose == 2) {
                // add new Wagon
                System.out.print("Enter Wagon ID: ");
                int wagonNum = scanner.nextInt();
                System.out.print("Enter Wagon Capacity: ");
                int wagonCapacity = scanner.nextInt();
                System.out.print("Enter Wagon Type: ");
                String wagonType = scanner.nextLine();
                System.out.print("Enter Wagon Weight: ");
                int wagonWeight = scanner.nextInt();
                System.out.print("Enter Wagon Number of Seats: ");
                int wagonNumberOfSeats = scanner.nextInt();
                train.addWagon(new Wagon(wagonNum, wagonCapacity, wagonType, wagonWeight, wagonNumberOfSeats));
            }
            if (choose == 3) {
                // remove existing Wagon
                System.out.print("Enter Wagon ID to remove: ");
                int removeId = scanner.nextInt();
                train.removeWagon(removeId);
            }
        }
        }
    }