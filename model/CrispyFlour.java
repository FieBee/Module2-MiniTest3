package model;
import java.time.LocalDate;



public class CrispyFlour extends Material {
    private double quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(String id, String name, String manufacturing, int cost, double quantity) {
        super(id, name, manufacturing ,cost);
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity * getCost() ;
    }

    @Override
    public LocalDate getExpiryDate() {
        LocalDate date = LocalDate.now();
        return date.plusDays(365);
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "   CrispyFlour {" +
                "id ='" + super.getId() + '\'' +
                ", name = '" + super.getName() + '\'' +
                ", manufacturing = " + super.getManufacturing() +
                ", cost =" + super.getCost() +
                ", quantity =" + quantity +
                '}';
    }




    @Override
    public double getRealMoney() {
        LocalDate now = LocalDate.now();
        LocalDate timeLine1 = getManufacturing().minusDays(120);
        LocalDate timeLine2 = getManufacturing().minusDays(60);
        if (timeLine2.isAfter(now)){
            if (timeLine1.isAfter(now)) return getAmount()/20*19;
            return getAmount()/10*8;

        }else {
            return getAmount()/10*6;
        }
    }


}

