import java.util.ArrayList;

public class SpecialDeal {
    private ArrayList<PhotoCenter> order;
    private double discount;

    public SpecialDeal(ArrayList<PhotoCenter> list) {
        order = list;

        int prints = 0;
        int posters = 0;
        int tabletops = 0;
        discount = 0;

        // checks total types of objects in each list
        for(PhotoCenter obj : order) {
            if (obj.getType().equals("Photo Prints")) {
                prints++;
            }
            else if (obj.getType().equals("Poster")) {
                posters++;
            }
            else if (obj.getType().equals("Tabletop")) {
                tabletops++;
            }

            if (obj.getPrintAmt() == 10) {
                System.out.println("You qualify for our 10 for 50% off deal!");

                // adding discounted cost to total discounts
                discount += obj.getTotalCost()/2;
                // setting new cost to 1/2 of the previous cost for that item.
                obj.setTotalCost(obj.getTotalCost()/2);
            }
        }

        if (prints > 0 && posters > 0 && tabletops > 0) {
            System.out.println("You qualify for our 3 item combo deal!");
            discount += 5;
        }

    }

    public double getDiscount() {
        return discount;
    }
}
