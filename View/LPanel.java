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


public class LPanel extends JPanel {
    private JList<Object> menu;
    private JButton showDrinks;
    private JButton showFood;
    private JButton addToOrder;
    private JLabel title;

    private int width;
    private int height;

    private Controller controller;

    public LPanel(int width, int height, Controller controller) {
        this.controller = controller;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(0, 0);
        setBackground(Color.MAGENTA);
        setUp();
    }

    public void setUp() {
        title = new JLabel("TjoKatt Pizzeria");
        title.setLocation((width / 2) - 30, 0);
        title.setSize(120, 20);
        this.add(title);

        menu = new JList<>();
        menu.setLocation(0, 23);
        menu.setSize(width, height - 100);
        menu.setBackground(Color.pink);
        this.add(menu);


        showFood = new JButton("Mat");
        showFood.setEnabled(true);
        showFood.setSize(width / 3, 30);
        showFood.setLocation(0, height - 75);
        showFood.addActionListener(l -> controller.setToFoodMenu());
        this.add(showFood);

        showDrinks = new JButton("Drickor");
        showDrinks.setEnabled(false); // Om du ska köra för VG ändrar du denna till True annars kan du skippa allt med drink att göra
        showDrinks.setSize(width / 3, 30);
        showDrinks.setLocation(width / 3, height - 75);
        //showDrinks.addActionListener(l -> controller.setToDrinkMenu());
        this.add(showDrinks);

        addToOrder = new JButton("Lägg till");
        addToOrder.setEnabled(true);
        addToOrder.setSize(width / 3, 30);
        addToOrder.addItemListener(l -> getNbrOfItems());
        addToOrder.addActionListener(l -> controller.addItemToOrder());
        addToOrder.setLocation(width - (width / 3), height - 75);
        this.add(addToOrder);
    }

    public int getNbrOfItems(){
        boolean done = false;
        int nbrOfItem = 0;
        do {
            String input;
            input = JOptionPane.showInputDialog(null, "Number of pizzas", "Order", JOptionPane.INFORMATION_MESSAGE);
            try {
                nbrOfItem = Integer.parseInt(input);
                done = nbrOfItem > 0; //true if nbrOfItem are over 0, else invalid message
               }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Not valid number, try again");
            }

        } while (!done);
        return nbrOfItem;
    }

    //Get index from pointer
    public int getListIndex()
    {
        return this.menu.getSelectedIndex();
    }

    public JList<Object> getMenu() {
        return menu;
    }

    public void setMenu(String [] pizzaMenu) {
        this.menu.setListData(pizzaMenu);
    }

    public JButton getShowDrinks() {
        return showDrinks;
    }

    public void setShowDrinks(JButton showDrinks) {
        this.showDrinks = showDrinks;
    }

    public JButton getShowFood() {
        return showFood;
    }

    public void setShowFood(JButton showFood) {
        this.showFood = showFood;
    }

    public JButton getAddToOrder() {
        return addToOrder;
    }

    public void setAddToOrder(String [] newOrder) { /*JButton addToOrder*/
       this.menu.setListData(newOrder); // this.addToOrder = addToOrder;
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
}
