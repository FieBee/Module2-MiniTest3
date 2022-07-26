package model;

import java.time.LocalDate;

public class Meat extends Material{
    private double weight;


    public Meat() {
    }



    public Meat(String id, String name, String manufacturing, int cost, double weight) {
        super(id, name, manufacturing, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return  super.getCost() * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        LocalDate date = LocalDate.now();
        return date.plusDays(7);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getRealMoney() {
        LocalDate timeLine1 = getManufacturing().minusDays(5);
        LocalDate timeLine2 = LocalDate.now();
        if (timeLine1.isAfter(timeLine2)){
            return getAmount()/10*9;

        }else {
            return getAmount()/10*7;
        }
    }

    @Override
    public String toString() {
        return "   Meat {" +
                "id ='" + super.getId() + '\'' +
                ", name = '" + super.getName() + '\'' +
                ", manufacturing = " + super.getManufacturing() +
                ", cost =" + super.getCost() +
                ", weight =" + weight +
                '}';
    }

}
