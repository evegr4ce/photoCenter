public class TableTop implements PhotoCenter {
    public final int printAmount;
    private String matType;
    private double cost;
    private static final String type = "Tabletop";

    public TableTop() {
        printAmount = 0;
    }

    public TableTop(int num, int userType) {
        printAmount = num;

        // switch statement to set type & cost
        switch(userType) {
            case 1:
                matType = "Aluminum";
                cost = 11.5;
                break;
            case 2:
                matType = "Medallion";
                cost = 13.5;
                break;
            case 3:
                matType = "Wood";
                cost = 9.75;
                break;
            default:
                matType = "Other";
                cost = 25.0;
        }
    }
    public String getMatType() {
        return matType;
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
