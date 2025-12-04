import java.util.Scanner;

public class ExpressingGratitude_12 {

    public static String getGreetingRecipient() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Input the name of people you want to greet:  ");
            String recipientName = input.nextLine();
            return recipientName;
        }
    }

    public static void sayThankyou() {
        String name = getGreetingRecipient(); // This is now correct
        System.out.println("Thank you " + name + " for being the best teacher in the world.\n" +
                           "You inspired in me a love for learning and made me feel like i could ask you anything.");
    }

    public static void main(String[] args) {
        sayThankyou();
    }
}