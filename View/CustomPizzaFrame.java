package View;


import Controller.Controller;
//import Model.food.Toppings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*public class CustomPizzaFrame extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JTextField pizzaName;
    private JComboBox<Toppings> toppings;
    private JButton addTopping;
    private JLabel currentPizzaText;
    private JButton savePizza;
    private ArrayList<Toppings> toppingsAdded;
    private Controller controller;
    private JLabel selectedToppings;

    public CustomPizzaFrame(Controller controller) {
        mainPanel = new JPanel(new GridLayout(3, 3));
        setSize(600, 150);
        this.setContentPane(mainPanel);
        setupPanel();
        this.setTitle("Create your own pizza!");
        this.setVisible(true);
        this.setResizable(false);
        toppingsAdded = new ArrayList<>();
        this.controller = controller;
    }

    public void setupPanel() {
        addTopping = new JButton("Add topping");
        pizzaName = new JTextField("Pizza name?");
        currentPizzaText = new JLabel("Add your toppings:");
        savePizza = new JButton("Save pizza");
        toppings = new JComboBox<>(Toppings.values());

        pizzaName.setFont(new Font("Times New Roman", Font.BOLD, 13));
        toppings.setFont(new Font("Times New Roman", Font.BOLD, 13));
        currentPizzaText.setFont(new Font("Times New Roman", Font.BOLD, 13));
        selectedToppings = new JLabel();


        mainPanel.add(pizzaName);
        mainPanel.add(toppings);
        mainPanel.add(currentPizzaText);
        mainPanel.add(addTopping);
        mainPanel.add(savePizza);
        mainPanel.add(selectedToppings);

        savePizza.addActionListener(this);
        addTopping.addActionListener(this);


    }


    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JComboBox<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(JComboBox<Toppings> toppings) {
        this.toppings = toppings;
    }

    public JButton getAddTopping() {
        return addTopping;
    }

    public void setAddTopping(JButton addTopping) {
        this.addTopping = addTopping;
    }

    public JLabel getCurrentPizzaText() {
        return currentPizzaText;
    }

    public void setCurrentPizzaText(JLabel currentPizzaText) {
        this.currentPizzaText = currentPizzaText;
    }

    public JButton getSavePizza() {
        return savePizza;
    }

    public void setSavePizza(JButton savePizza) {
        this.savePizza = savePizza;
    }

    public ArrayList<Toppings> getToppingsAdded() {
        return toppingsAdded;
    }

    public void setToppingsAdded(ArrayList<Toppings> toppingsAdded) {
        this.toppingsAdded = toppingsAdded;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public JTextField getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(JTextField pizzaName) {
        this.pizzaName = pizzaName;
    }

    public JLabel getSelectedToppings() {
        return selectedToppings;
    }

    public void setSelectedToppings(JLabel selectedToppings) {
        this.selectedToppings = selectedToppings;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTopping) {
            toppingsAdded.add((Toppings) toppings.getSelectedItem());
            selectedToppings.setText(toppingsAdded.toString().replace("[", "").replace("]", ""));
        } else if (e.getSource() == savePizza) {
            /*
            TODO: Skapa ny pizza här och spara den.
             */
        //}
    //}
//}
