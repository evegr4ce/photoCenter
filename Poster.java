public class Poster implements PhotoCenter {
    public final int printAmount;
    private static double cost = 4.5;
    private static final String type = "Poster";

    public Poster() {
        printAmount = 0;
    }

    public Poster(int num) {
        printAmount = num;
    }

    @Override
    public double getTotalCost() {
        return cost * printAmount;
    }

    @Override
    public void setTotalCost(double newCost) {
        cost = newCost;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getPrintAmt() {
        return printAmount;
    }
}