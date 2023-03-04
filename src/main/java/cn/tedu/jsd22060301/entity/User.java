package cn.tedu.jsd22060301.entity;

public class User  {
    double height;
    double weight;

    public User() {
    }

    public User(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "User{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}
