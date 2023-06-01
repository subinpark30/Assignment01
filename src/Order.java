import java.util.ArrayList;
import java.util.List;

class Order {
    private List<Product> cart;

    public Order() {
        this.cart = new ArrayList<>();

    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : cart) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }
    public void clearCart() {
        cart.clear();
    }

    public double getFinalPrice() {
        double finalPrice = 0;
        for (Product product : cart) {
            finalPrice += getTotalPrice();
        }
        return finalPrice;
    }

}