package src;

class Customer {
    protected String name;
    protected String phone;
    protected String address;

    public Customer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    public double getDiscount(double total) {
        if (total > 500) return total * 0.9;
        return total;
    }
}