/*
 *  Namn: Hedda Eriksson
 *  Dator-id: 9098
 *  Utbildning: Datateknik och Mobil IT: Högskoleingenjörsprogrammet
 *  Datum: 12/12 - 2021
 * */
package Model;

import Controller.Controller;

public class Manager {

    private Controller controller;
    private Pizza[] pizzaMenu;                  // objects
    private Order[] orderMenu;
    private String[] historyList;
    private String[][] historySpecificList;
    private int i = 0;                          // index selection
    private int i2 = 0;
    private int i3 = 0;
    private int orderNum = 0;
    private double totalAmount = 0.0;
    private Order currOrder = null;              // working object
    private OrderHistory historyOrder = null;



    public Manager(Controller controller) {
        pizzaMenu = new Pizza[5];
        this.controller = controller;
        orderMenu = new Order[20];
        currOrder = new Order(0, null, 0, 0);
        historyList = new String[100];
        historySpecificList = new String[100][100];

    }

    /* Skapar menyn*/
    public void createMenu(){
        pizzaMenu[0] = new Pizza("Margharita", 95, "Tomato sauce, cheese");
        pizzaMenu[1] = new Pizza("Vesuvio", 95, "Tomato sauce, cheese, ham");
        pizzaMenu[2] = new Pizza("Capricciosa", 95, "Tomato sauce, cheese, ham, mushrooms");
        pizzaMenu[3] = new Pizza("Hawaii", 95, "Tomato sauce, cheese, ham, pineapple");
        pizzaMenu[4] = new Pizza("Tonnato", 95, "Tomato sauce, cheese, ham, tuna");
    }

    /* Skapar order och lägger in pizza och antal*/
    public Order[] addToOrder(Pizza pizzaIn, int nbrOfItem){

        if(orderMenu[0] == null){                                                                            // för att placera på index noll igen vid ny beställning
            i = 0;
        }
        else if( i >= orderMenu.length){
            increaseOrderMenu();
        }
        currOrder = new Order(0, null, 0, 0);                               // create new order
        Pizza pizza = new Pizza(pizzaIn.getProductName(), pizzaIn.getProductPrice(), pizzaIn.getToppings()); // create new pizza
        currOrder.setPizza(pizza);
        currOrder.setNbrOfItem(nbrOfItem);


        //currOrder.setOrderNr(i);  //räknar antal beställningar tillagt
        orderMenu[i] = currOrder;
        i++;

        return orderMenu;
    }

    /* verifiera om det finns något i orden att beställa */
    public boolean checkOrder(){
        boolean ok = true;

        if(orderMenu[0] == null ){
            ok = false;
        }
        return ok;
    }

    /* utökar orderlistan om det skulle behövas*/
    private void increaseOrderMenu(){

        Order [] largerOrderMenu = new Order[orderMenu.length + 10];                                           //sets the new array to 10 more elements

        for (int i = 0; i < orderMenu.length; i++) {                                                           //loops through the arrays to replace the old with the new
            largerOrderMenu[i] = orderMenu[i];
        }
        orderMenu = largerOrderMenu;                                                                           // switch names

    }
    /* Sparar en order i historiken */
    public String[] settingHistoryList(String orderNumber, String totalAmount){

        historyOrder = new OrderHistory(orderNumber, totalAmount);
        historyList[i2] = String.valueOf(historyOrder.toString());
        i2++;

        return historyList;
    }
    /* Sparar information om ordrar MÅNDAG*/
    public void settingHistorySpecificsList(){
        for (int l = 0; l < orderMenu.length; l++) {
            if (orderMenu[l] != null) {
                historySpecificList[i3][l] = orderMenu[l].toStringHistory();

            }
        }
        i3++;

    }

    /* hämta specifik beställning på index*/
    public String[] viewHistorySpecifics(int index){
        String[] show = historySpecificList[index];

        return show;
    }

    /* Tar bort ordern från skärmen när beställningen läggs */
    public Order[] clearField(){
        for ( i = 0; i < orderMenu.length; i++) {
            orderMenu[i] = null;
        }
        return orderMenu;
    }

    /* Rensar kostnaden inför ny beställning*/
    public String clearCostsField(){
        totalAmount = 0;
        return String.valueOf(totalAmount);
    }

    /* Ökar ordernumret inför ny beställning */
    public String newOrderNumber(){
        orderNum++;
        return String.valueOf(orderNum);
    }

    /* Anger totala kostnaden */
    public String setTotalAmount(){

        double amount = currOrder.getTotalAmount();
        totalAmount += amount;

        return String.valueOf(totalAmount);
    }

    /* Hämtar ordernummer */
    public String setOrderNumber(){

        return String.valueOf(currOrder.getOrderNr());
    }
    /* Info-string för Pizza menyn */
    public String[] getInfoString (Pizza[] pizzaMenu) {

        String[] infoStrings = new String[pizzaMenu.length];
        for (int i = 0; i < pizzaMenu.length; i++) {
            if (pizzaMenu[i] != null)
                infoStrings[i] = pizzaMenu[i].toString();

        }
        return infoStrings;
    }


    /* Getters and Setters */

    public String[] getHistoryList() {
        return historyList;
    }

    public void setHistoryList(String[] historyList) {
        this.historyList = historyList;
    }

    public Pizza[] getPizzaMenu() {
        return pizzaMenu;
    }

    public void setPizzaMenu(Pizza[] pizzaMenu) {
        this.pizzaMenu = pizzaMenu;
    }

    public Order[] getOrderMenu() {
        return orderMenu;
    }

    public void setOrderMenu(Order[] orderMenu) {
        this.orderMenu = orderMenu;
    }

    public Pizza getPizza(int index){
        return pizzaMenu[index];
    }

}
