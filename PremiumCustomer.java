package src;

class PremiumCustomer extends Customer {

    public PremiumCustomer(String name, String phone, String address) {
        super(name, phone, address);
    }

    @Override
    public double getDiscount(double total) {
        if (total > 500) return total * 0.8;
        return total * 0.95;
    }
}