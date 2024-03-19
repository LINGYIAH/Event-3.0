import java.time.LocalDate;
import java.util.HashMap;

public class Event {
    private static final int CAPACITY = 200;
    private String eventID;
    private String eventName;
    private String eventVenue;
    private LocalDate eventDate;
    private HashMap<String, Attendee> seatDetails;

    public Event(String eventID, String eventName, String eventVenue, LocalDate eventDate) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventDate = eventDate;
        this.seatDetails = new HashMap<>(CAPACITY, 0.6f);
    }

    public void setSeat(String seatNo, Attendee attendee) {
        if (seatDetails.size() >= CAPACITY) {
            System.out.println("Event is at full capacity. Cannot add more attendees.");
        } else if (seatDetails.containsKey(seatNo)) {
            System.out.println("Seat " + seatNo + " is already taken.");
        } else {
            seatDetails.put(seatNo, attendee);
        }
    }


    public Attendee getAttendeeBySeat(String seatNo) {
        return seatDetails.get(seatNo);
    }


    public void showEventDetails() {
        System.out.println("Event Details:");
        System.out.println("ID: " + eventID);
        System.out.println("Name: " + eventName);
        System.out.println("Venue: " + eventVenue);
        System.out.println("Date: " + eventDate);
        System.out.println("Attendees: ");
        for (Attendee attendee : seatDetails.values()) {
            System.out.println(attendee);
        }
        System.out.println("Total number of attendees: " + seatDetails.size());
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Event ID: ").append(eventID)
                .append("\nEvent Name: ").append(eventName)
                .append("\nEvent Venue: ").append(eventVenue)
                .append("\nEvent Date: ").append(eventDate)
                .append("\nAttendees:\n");
        for (Attendee attendee : seatDetails.values()) {
            sb.append(attendee).append("\n");
        }
        return sb.toString();
    }
}