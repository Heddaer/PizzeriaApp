/*
 *  Namn: Hedda Eriksson
 *  Dator-id: 9098
 *  Utbildning: Datateknik och Mobil IT: Högskoleingenjörsprogrammet
 *  Datum: 12/12 - 2021
 * */
package Model;

/* order-hanterare för att kunna skapa order-objekt i manager*/

public class Order {

    private int orderNr;
    private Pizza pizza;
    private int nbrOfItem;
    private int totalAmount;

    public Order(int orderNr, Pizza pizza, int nbrOfItem, int totalAmount) {
        this.orderNr = orderNr;
        this.pizza = new Pizza(null,0,null);
        this.nbrOfItem = nbrOfItem;
        this.totalAmount = totalAmount;

    }


    public int getNbrOfItem() {
        return nbrOfItem;
    }

    public void setNbrOfItem(int nbrOfItem) {
        this.nbrOfItem = nbrOfItem;
    }

    public int getTotalAmount() {

        totalAmount = (int) (pizza.productPrice * nbrOfItem);
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String toString (){
        return String.format(" QTY:  %s  | %s ", nbrOfItem, pizza);
    }

    public String toStringHistory(){
        return String.format("%s | %s ", nbrOfItem, pizza.toStringHistory());
    }
}

