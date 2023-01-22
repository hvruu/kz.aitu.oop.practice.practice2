import java.util.ArrayList;
import java.util.Scanner;

abstract class Wagon {
    //создаем переменные
    private int id;
    private int capacity;
    private String type;
    private int weight;
    public Wagon(int id, int capacity, String type, int weight) {
        this.id = id;
        this.capacity = capacity;
        this.type = type;
        this.weight = weight;
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
    public abstract int getNumberOfSeats();
}

class CompartmentWagon extends Wagon{
    private int numberOfSeats;
    public CompartmentWagon(int id, int capacity, int weight, int numberOfSeats) {
        super(id, capacity, "Compartment", weight);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}

class SittingWagon extends Wagon{
    private int numberOfSeats;
    public SittingWagon(int id, int capacity, int weight, int numberOfSeats) {
        super(id, capacity, "Sitting", weight);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}

class ReservedSeatWagon extends Wagon{
    private int numberOfSeats;
    public ReservedSeatWagon(int id, int capacity, int weight, int numberOfSeats) {
        super(id, capacity, "Reserved seat", weight);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}

class SuiteWagon extends Wagon {
    private int numberOfSeats;

    public SuiteWagon(int id, int capacity, int weight, int numberOfSeats) {
        super(id, capacity, "Suite", weight);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
class Train {
    private ArrayList<Wagon> wagons;
    public Train() {
        this.wagons = new ArrayList<>();
        wagons.add(new CompartmentWagon(1, 20, 15000, 24));
        wagons.add(new SittingWagon(2, 40, 20000, 40));
        wagons.add(new ReservedSeatWagon(3, 50, 25000, 50));
        wagons.add(new SuiteWagon(4, 10, 10000, 12));
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
                System.out.print("Enter Wagon ID: ");
                int id = scanner.nextInt();
                System.out.print("Enter Wagon capacity: ");
                int capacity = scanner.nextInt();
                System.out.print("Enter Wagon weight: ");
                int weight = scanner.nextInt();
                System.out.print("Enter Wagon number of seats: ");
                int numberOfSeats = scanner.nextInt();
                System.out.print("Enter Wagon type (Compartment, Sitting, Reserved seat,Suite): ");
                String type = scanner.next();
                Wagon wagon;
                switch (type) {
                    case "Compartment":
                        wagon = new CompartmentWagon(id, capacity, weight, numberOfSeats);
                        break;
                    case "Sitting":
                        wagon = new SittingWagon(id, capacity, weight, numberOfSeats);
                        break;
                    case "Reserved seat":
                        wagon = new ReservedSeatWagon(id, capacity, weight, numberOfSeats);
                        break;
                    case "Suite":
                        wagon = new SuiteWagon(id, capacity, weight, numberOfSeats);
                        break;
                    default:
                        System.out.println("Invalid Wagon type. Wagon not added");
                        continue;
                }
                train.addWagon(wagon);
            }
            if (choose == 3) {
                System.out.print("Enter Wagon ID to remove: ");
                int id = scanner.nextInt();
                train.removeWagon(id);
            }
        }
    }
}
