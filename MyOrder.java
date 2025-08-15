import java.util.ArrayList;
import java.util.Scanner;

public class MyOrder {

    public MyOrder() {
        ArrayList<PhotoCenter> order = new ArrayList<>();
        Scanner user = new Scanner(System.in);

        // while loop running user prompts & creating items based off of user responses
        while (true) {
            System.out.println("Hello! Welcome to the online PhotoCenter. What would you like to do?");
            System.out.println("""
                    Please enter a number listed below.
                    
                    1) Buy Photo Prints
                    2) Buy Posters
                    3) Buy Tabletops
                    4) Hear about Special Deals
                    """);

            boolean validInput = false;

            // checking for a valid input
            while (!validInput) {
                String ans = user.next();

                // depending on the user input, the requested method will be called. (if input is valid)
                validInput = switch (ans) {
                    case "1" -> {
                        System.out.println("How many would you like?");
                        int amount = user.nextInt();

                        PhotoPrints prints = new PhotoPrints(amount);

                        order.add(prints);
                        yield true;
                    }
                    case "2" -> {
                        System.out.println("How many would you like?");
                        int amount = user.nextInt();

                        Poster posters = new Poster(amount);

                        order.add(posters);
                        yield true;
                    }
                    case "3" -> {
                        System.out.println("How many would you like?");
                        int amount = user.nextInt();

                        System.out.println("What material type would you like?");
                        System.out.println("""
                            Please enter a number listed below.
                            
                            1) Aluminum
                            2) Medallion
                            3) Wood
                            4) Other
                            """);
                        int type = user.nextInt();

                        TableTop tabletops = new TableTop(amount, type);
                        order.add(tabletops);
                        yield true;
                    }
                    case "4" -> {
                        System.out.println("""
                            We currently have 2 deals:
                            1) 10 prints of the same item type for 50% off those prints.
                            2) 3 different item types combo deal for $5 off the total order.
                            """);

                        yield true;
                    }
                    default -> {
                        // only if user input is invalid
                        System.out.println("Invalid input. Please try again.");
                        yield false;
                    }
                };
            }

            boolean validCheck = false;

            // continue check loop until end of program
            while (!validCheck) {
                System.out.println("\nWould you like to continue adding items? (y/n)");
                String check = user.next();

                if (check.equalsIgnoreCase("n")) {
                    // if user is finished, calculate total cost & print ending messages
                    validCheck = true;

                    // close scanner for program security
                    user.close();

                    double printsCost = 0;
                    double posterCost = 0;
                    double tabletopCost = 0;

                    System.out.println("Thanks for ordering!");

                    for(PhotoCenter obj : order) {
                        if (obj.getType().equals("Photo Prints")) {
                            printsCost += obj.getTotalCost();
                        }
                        else if (obj.getType().equals("Poster")) {
                            posterCost += obj.getTotalCost();
                        }
                        else if (obj.getType().equals("Tabletop")) {
                            tabletopCost += obj.getTotalCost();
                        }
                    }

                    // checking order combinations for special deals
                    SpecialDeal special = new SpecialDeal(order);

                    // calc subtotal
                    double subtotal = printsCost + posterCost + tabletopCost;
                    String roundedSubtotal = roundOffTo2DecPlaces(subtotal);

                    // subtract all discounts
                    double cost = subtotal - special.getDiscount();
                    String roundedCost = roundOffTo2DecPlaces(cost);

                    // session summary
                    System.out.println("Your prints cost: " + printsCost + "\n" +
                            "Your posters cost: " + posterCost + "\n" +
                            "Your tabletop cost: " + tabletopCost + "\n\n" +
                            "Subtotal: " + roundedSubtotal + "\n" +
                            "Total Discounts: " + special.getDiscount() + "\n\n" +
                            "Your total cost is: " + roundedCost);
                    System.exit(0);
                } else if (check.equalsIgnoreCase("y")) {
                    // restarts item addition dialogue
                    validCheck = true;
                } else {
                    System.out.println("Invalid input. Please try again, and enter 'y' or 'n'.");
                }
            }
        }
    }

    // formats all costs to 2 decimal places
    String roundOffTo2DecPlaces(double val)
    {
        return String.format("%.2f", val);
    }
}
