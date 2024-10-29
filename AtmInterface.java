
package com.mycompany.atminterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AtmInterface {
 private JFrame frame;
    private JTextField pinField, amountField;
    private JLabel balanceLabel;

    public AtmInterface() {
        frame = new JFrame("Thomas Bank ATM");
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.add(new JLabel("Welcome to ATM"));
        frame.add(headerPanel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // PIN Panel
        JPanel pinPanel = new JPanel();
        pinPanel.add(new JLabel("Enter PIN:"));
        pinField = new JTextField(10);
        pinPanel.add(pinField);
        centerPanel.add(pinPanel);

        // Option Panel
        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new GridLayout(3, 1));
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new WithdrawButtonListener());
        optionPanel.add(withdrawButton);
        
        JButton balanceButton = new JButton("Check Balance");
        balanceButton.addActionListener(new BalanceButtonListener());
        optionPanel.add(balanceButton);
        
        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new DepositButtonListener());
        optionPanel.add(depositButton);
        
        centerPanel.add(optionPanel);

        // Amount Panel
        JPanel amountPanel = new JPanel();
        amountPanel.add(new JLabel("Enter Amount:"));
        amountField = new JTextField(10);
        amountPanel.add(amountField);
        centerPanel.add(amountPanel);

        // Balance Panel
        JPanel balancePanel = new JPanel();
        balanceLabel = new JLabel("Balance: $0");
        balancePanel.add(balanceLabel);
        centerPanel.add(balancePanel);

        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    
}



public class ATM {
   
    }

    private class WithdrawButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Withdraw logic
            double amount = Double.parseDouble(amountField.getText());
            // Update balance
            balanceLabel.setText("Balance: R" + (getBalance() - amount));
        }
    }

    private class DepositButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            double amount = Double.parseDouble(amountField.getText());
            
            balanceLabel.setText("Balance: R" + (getBalance() + amount));
        }
    }

    private class BalanceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            balanceLabel.setText("Balance: R" + getBalance());
        }
    }

    private double getBalance() {
       
        return 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AtmInterface();
            }
        });
    }
}


