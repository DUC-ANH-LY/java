/**
 * Created by Lyducanh
 * Date: 5/29/2025
 * Time: {11:14 PM}
 * Project Name: Spring Tutorial
 */


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Event {
    private String id;
    private String title;

    public Event(String id, String title) {
        this.id = id;
        this.title = title;
    }

    // Override equals()
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id);  // Only compare by id
    }

    // Override hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(id); // Only use id for hash
    }

    @Override
    public String toString() {
        return "Event{id='" + id + "', title='" + title + "'}";
    }

    // Main method
    public static void main(String[] args) {

        Event e1 = new Event("E123", "Music Concert");
        Event e2 = new Event("E123", "Music Concert");
        Event e3 = e1;

        e3 = new Event("E124", "Test");

        System.out.println("e1 == e2: " + (e1 == e2));
        System.out.println("e1.equals(e2): " + e1.equals(e2));
        System.out.println("e1 == e3: " + (e1 == e3));

        // Print simulated memory locations
        System.out.println("e1 identityHashCode: " + System.identityHashCode(e1));
        System.out.println("e2 identityHashCode: " + System.identityHashCode(e2));
        System.out.println("e3 identityHashCode: " + System.identityHashCode(e3));

//        Event e1 = new Event("E123", "Music Concert");
//        Event e2 = new Event("E123", "Tech Talk");
//
//        Set<Event> eventSet = new HashSet<>();
//        eventSet.add(e1);
//        eventSet.add(e2); // e2 has same ID as e1
//        System.out.println(e1.equals(e2));
//        System.out.println("Set size: " + eventSet.size()); // Output: 1
//        System.out.println("Set contents: " + eventSet);
    }
}
