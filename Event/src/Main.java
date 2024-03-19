import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter event ID:");
        String eventID = scanner.nextLine();

        System.out.println("Enter event name:");
        String eventName = scanner.nextLine();

        System.out.println("Enter event venue:");
        String eventVenue = scanner.nextLine();

        System.out.println("Enter event date (yyyy-MM-dd):");
        String dateString = scanner.nextLine();
        LocalDate eventDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);

        Event event = new Event(eventID, eventName, eventVenue, eventDate);
        HandlePerformances handlePerformances = new HandlePerformances();
        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1 - Add attendee");
            System.out.println("2 - Show event details");
            System.out.println("3 - Handle complementary passes");
            System.out.println("4 - Handle performances");
            System.out.println("5 - Get seat details");
            System.out.println("0 - Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter attendee seat number:");
                    String seatNo = scanner.nextLine();
                    Attendee newAttendee = Attendee.createAttendeeFromInput(scanner); 
                    newAttendee.setSeatNo(seatNo); 
                    event.setSeat(seatNo, newAttendee);
                    break;
                case 2:
                    event.showEventDetails();
                    break;
                case 3:
                    HandleComplementaryPasses.handleComplementaryPasses();
                    break;
                case 4:
                    handlePerformances.handlePerformances();
                    break;
                case 5:
                    System.out.println("Enter seat number to get details:");
                    String seatNumber = scanner.nextLine();
                    Attendee attendee = event.getAttendeeBySeat(seatNumber);
                    if (attendee != null) {
                        System.out.println(attendee);
                    } else {
                        System.out.println("No attendee found for seat number: " + seatNumber);
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        scanner.close();
    }
}