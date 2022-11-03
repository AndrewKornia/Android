package models;


public class Vehicle {

    private String id;
    private String title;
    private String imageURL;
    private int year;
    private double mileage;
    private String price;

    public Vehicle(String id, String title, String imageURL, int year, double mileage, String price) {
        this.id = id;
        this.title = title;
        this.imageURL = imageURL;
        this.price = price;
        this.year = year;
        this.mileage = mileage;

    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return imageURL;
    }

    public int getYear() {
        return year;
    }

    public double getMileage() {
        return mileage;
    }

    public String getPrice() {
        return price;
    }

    public String builder() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID автомобиля : " + getId() +
                "\n Цена автомобиля : " + getPrice() +
                "\n Пробег : " + getMileage() + "km" +
                "\n Год выпуска : " + getYear());
        return builder.toString();

    }

}
