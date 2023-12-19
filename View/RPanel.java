/*
 *  Namn: Hedda Eriksson
 *  Dator-id: 9098
 *  Utbildning: Datateknik och Mobil IT: Högskoleingenjörsprogrammet
 *  Datum: 12/12 - 2021
 * */
package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class RPanel extends JPanel {
    private JList<Object> orderList;
    private JList<Object> orderHistoryList;
    private JList<Object> historySpecificsList;   //måndag
    private JButton exitButton;
    private JButton createOrder;
    private JLabel title;
    private JLabel price;
    private JLabel orderHistory;
    private JLabel historySpecifics;                //måndag
    private JTextField totalAmount;
    private JTextField order;


    private int width;
    private int height;

    private Controller controller;

    public RPanel(int width, int height, Controller controller) {
        this.controller = controller;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(width, 0);
        setBackground(Color.MAGENTA);
        setUp();

    }

    public void setUp() {
        title = new JLabel("ORDER:");
        title.setLocation(0, 0);
        title.setSize(width / 2, 20);
        this.add(title);
        order = new JTextField();
        order.setEnabled(false);
        order.setLocation(45, 0);
        order.setSize(width / 8, 20);
        this.add(order);

        price = new JLabel("PRICE: ");
        price.setLocation(width / 2 + 10, 0);
        price.setSize(90, 20);
        this.add(price);
        totalAmount = new JTextField(); //box enable to use for user with total cost
        totalAmount.setEnabled(false);
        totalAmount.setLocation(width/2+50, 0);
        totalAmount. setSize(90, 20);
        this.add(totalAmount);

        orderList = new JList<>();
        orderList.setLocation(0, 23);
        orderList.setSize(width, height - 350);
        orderList.setBackground(Color.PINK);
        this.add(orderList);

        orderHistory = new JLabel("Order History");
        orderHistory.setLocation(width/4-30, height -310); // width/4-80 måndag
        orderHistory.setSize(90, 20);
        this.add(orderHistory);

        orderHistoryList = new JList<>();
        orderHistoryList.setLocation(0, height-280);
        orderHistoryList.setSize(width/2-10, height -350);   // width måndag
        orderHistoryList.setBackground(Color.PINK);
        orderHistoryList.addListSelectionListener(l -> controller.viewOrderHistoryInfo());
        this.add(orderHistoryList);

        historySpecifics = new JLabel("Order History: Specifics");         //måndag
        historySpecifics.setLocation(width/2+70, height -310);
        historySpecifics.setSize(160, 20);
        this.add(historySpecifics);

        historySpecificsList = new JList<>();                               // måndag
        historySpecificsList.setLocation(300, height-280);
        historySpecificsList.setSize(width/2, height -350);
        historySpecificsList.setBackground(Color.PINK);
        this.add(historySpecificsList);

        exitButton = new JButton("Avsluta för idag");
        exitButton.setEnabled(true);
        exitButton.setSize(width / 2, 30);
        exitButton.setLocation(width / 2 - 30, height - 75);
        exitButton.addActionListener(e -> System.exit(0));
        this.add(exitButton);


        createOrder = new JButton("Beställ");
        createOrder.setEnabled(true);
        createOrder.setSize(width / 2 - 30, 30);
        createOrder.setLocation(0, height - 75);
        createOrder.addActionListener(l -> controller.placeOrder());
        this.add(createOrder);
    }




    public JList<Object> getOrderList() {
        return orderList;
    }

    public void setOrderList(Object [] orderList) {
        this.orderList.setListData(orderList);
    }

    public JList<Object> getOrderHistoryList() {
        return orderHistoryList;
    }

    public void setOrderHistoryList(String[] orderHistoryList) {
        this.orderHistoryList.setListData(orderHistoryList);
    }

    public JList<Object> getHistorySpecificsList() {
        return historySpecificsList;
    }

    public void setHistorySpecificsList(String[] historySpecificsList) {
        this.historySpecificsList.setListData(historySpecificsList);
    }

    public JButton getCreateOrder() {
        return createOrder;
    }

    public void setCreateOrder(JButton createOrder) {
        this.createOrder = createOrder;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    public JLabel getPrice() {
        return price;
    }

    public void setPrice(JLabel price) {
        this.price = price;
    }

    public String getOrderNumberText(){
        String orderNumberText = order.getText();
        return orderNumberText;
    }
    public String getTotalAmountText(){  //söndag
        String totalAmountText = totalAmount.getText();
        return totalAmountText;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount.setText(totalAmount);
    }

    public void setOrderNumber(String orderNr) {
        this.order.setText(orderNr);
    }

    //hämta ordern man trycker på
    public int getHistoryListIndex()
    {
        return this.orderHistoryList.getAnchorSelectionIndex();
    }
}
