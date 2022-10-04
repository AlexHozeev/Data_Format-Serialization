import java.util.Objects;

public class Phone {
    private String brand;
    private int weight;
    private int screenSize;
    private int price;

    public Phone(){

    }

    public Phone(String brand, int weight, int screenSize, int price) {
        this.brand = brand;
        this.weight = weight;
        this.screenSize = screenSize;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getWeight() {
        return weight;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return weight == phone.weight && screenSize == phone.screenSize && price == phone.price && Objects.equals(brand, phone.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, weight, screenSize, price);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", weight=" + weight +
                ", screenSize=" + screenSize +
                ", price=" + price +
                '}';
    }
}
