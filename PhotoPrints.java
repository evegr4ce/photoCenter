public class PhotoPrints implements PhotoCenter {
    private final int printAmount;
    private static double cost = 0.22;
    private static final String type = "Photo Prints";

    public PhotoPrints() {
        printAmount = 0;
    }

    public PhotoPrints(int num) {
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