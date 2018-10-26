package model;

public class Product {
    private int id;
    private String name;
    private String type;
    private String vendor;

    public Product(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Product(int id, String name, String type, String vendor){
        this.id = id;
        this.name = name;
        this.type = type;
        this.vendor = vendor;
    }
}
