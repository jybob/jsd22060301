package cn.tedu.boot04.entity;

public class Bmi {
    private Double height;
    private Double weight;

    public Bmi() {
    }

    @Override
    public String toString() {
        return "Bmi{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Bmi(Double height, Double weight) {
        this.height = height;
        this.weight = weight;
    }
}
