/*
 *  Namn: Hedda Eriksson
 *  Dator-id: 9098
 *  Utbildning: Datateknik och Mobil IT: Högskoleingenjörsprogrammet
 *  Datum: 12/12 - 2021
 * */
package Controller;

import Model.*;
import View.*;
import Model.Manager;



public class Controller {

    // instance variables for example array of order
    private MainFrame view;
    private Manager manager;
    private LPanel lPanel;

    //default constructor
    public Controller(){
        //deklarera variablerna
       view = new MainFrame(1200, 550, this);
       lPanel = new LPanel(600, 500, this);
       manager = new Manager(this);
       manager.createMenu();
       String orderNr = manager.setOrderNumber();                               // hämtar ordernummer från manager
       view.getMainPanel().getrPanel().setOrderNumber(orderNr);                 // sätter ordernummer i JtextField

    }


    /* this method is used to set menu in right panel for customer to choose from.*/
    public void setToFoodMenu() {
        view.getMainPanel().getlPanel().setMenu(manager.getInfoString(manager.getPizzaMenu()));
    }

    /* this method is used to set everything that happens when you choose an Item*/
    public void addItemToOrder() {
        //boolean done = false;

        int index = view.getMainPanel().getlPanel().getListIndex();             //get index from LPanel
        int nbrOfItem = view.getMainPanel().getlPanel().getNbrOfItems();        // antal pizzor av den sorten
        Pizza pizzaIn = manager.getPizza(index);                                // hämta vald pizza
        manager.addToOrder(pizzaIn, nbrOfItem);                                 // skicka in vald pizza och antal till manager för att sätta
        view.getMainPanel().getrPanel().setOrderList(manager.getOrderMenu());   // sätt order i rPanel

        String amount = manager.setTotalAmount();                                // sätter aktuell kostnad i manager
        view.getMainPanel().getrPanel().setTotalAmount(amount);                  // sätter kostnaden i Jtextfield

       // String orderNr = manager.setOrderNumber();                               // hämtar ordernummer
        //view.getMainPanel().getrPanel().setOrderNumber(orderNr);                 // sätter ordernummer i JtextField
    }

    public void placeOrder() {
        // Finns det värden att hämta?

        boolean ok = manager.checkOrder();
        if(ok) {
            // Hämta värden
            String totalAmount = view.getMainPanel().getrPanel().getTotalAmountText();                                  //hämta info från view om totala kostnad och ordernummer
            String orderNumber = view.getMainPanel().getrPanel().getOrderNumberText();

            // Sätt värden
            manager.settingHistoryList(orderNumber, totalAmount);                                                       //skicka in i en metod med dessa parametrar som gör en order av dessa parametrar
            view.getMainPanel().getrPanel().setOrderHistoryList(manager.getHistoryList()); //(manager.getHistoryString(manager.getHistoryList()));    // skickar in historyList i metod i en infoString som fixar utskriften som skickas till utskrift

            // view.getMainPanel().getrPanel().setOrderHistoryList(manager.getHistoryString(manager.getOrderMenu()));

            //spara info historiken
            manager.settingHistorySpecificsList();



            // Rensa värden
            view.getMainPanel().getrPanel().setOrderList(manager.clearField());                                         // Rensa inför ny beställning
            view.getMainPanel().getrPanel().setTotalAmount(manager.clearCostsField());                                  // Kostand = 0 inför ny beställning
            view.getMainPanel().getrPanel().setOrderNumber(manager.newOrderNumber());                                   // Sätter nytt ordernummer
        }

    }

    public void viewOrderHistoryInfo(){
        int index = view.getMainPanel().getrPanel().getHistoryListIndex();
        view.getMainPanel().getrPanel().setHistorySpecificsList(manager.viewHistorySpecifics(index));
    }
}
