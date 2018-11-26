//public class Cars {
//    private String model;
//    private double fuelAmount;
//    private double fuelAmountForKm;
//    private long distanceTraveled;
//
//    public Cars(String model, double fuelAmount, double fuelAmountForKm) {
//        this.model = model;
//        this.fuelAmount = fuelAmount;
//        this.fuelAmountForKm = fuelAmountForKm;
//        this.distanceTraveled = 0;
//    }
//
//    public void calculatingParameters(long amountKm) {
//            double fuelAmount = amountKm * this.fuelAmountForKm;
//            if(fuelAmount > this.fuelAmount) {
//                System.out.println("Insufficient fuel for the drive");
//            }
//            else {
//                this.distanceTraveled += amountKm;
//                this.fuelAmount -= fuelAmount;
//            }
//    }
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public double getFuelAmount() {
//        return fuelAmount;
//    }
//
//    public void setFuelAmount(double fuelAmount) {
//        this.fuelAmount = fuelAmount;
//    }
//
//    public double getFuelAmountForKm() {
//        return fuelAmountForKm;
//    }
//
//    public void setFuelAmountForKm(double fuelAmountForKm) {
//        this.fuelAmountForKm = fuelAmountForKm;
//    }
//
//    public long getDistanceTraveled() {
//        return distanceTraveled;
//    }
//
//    public void setDistanceTraveled(long distanceTraveled) {
//        this.distanceTraveled = distanceTraveled;
//    }
//}
