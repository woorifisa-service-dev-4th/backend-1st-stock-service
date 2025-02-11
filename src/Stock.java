public class Stock {
    private String code;
    private String name;
    private int price;

    public Stock(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    // Getters
    public String getCode() { return code; }

    public String getName() { return name; }
    
    public int getPrice() { return price; }
}
