
public class RewardValue{

    private double cashValue;
    private double milesValue;

    public RewardValue(double cashValue)
    {
        this.cashValue=cashValue;
        this.milesValue=convertToMiles(cashValue);
    }
    public RewardValue(double milesValue, boolean isMiles) {
        if (isMiles) {
            this.milesValue = milesValue;
            this.cashValue = convertToCash(milesValue);
        }
    }

    public double getCashValue()
    {
        return cashValue;
    }
    public double getMilesValue()
    {
        return milesValue;
    }
    private double convertToCash(double miles)
    {
        return miles *  0.0035;
    }
    private  double convertToMiles(double cash)
    {
        return  cash/0.0035;
    }
}