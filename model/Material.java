package model;

import java.time.LocalDate;

public abstract class Material implements Discount{
    private String id;
    private String name;
    private LocalDate manufacturing;
    private int cost;

    public Material() {}

    public Material(String id, String name, String manufacturing, int cost) {
        this.id = id;
        this.name = name;
        this.manufacturing = LocalDate.parse(manufacturing);
        this.cost = cost;
    }

    public Material(String id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(LocalDate manufacturing) {
        this.manufacturing = manufacturing;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturing= " + manufacturing +
                ", cost=" + cost +
                '}';
    }

    public abstract double getAmount();
    public abstract LocalDate getExpiryDate();

    public abstract double getRealMoney();
}

