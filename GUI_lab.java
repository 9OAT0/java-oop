import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_lab {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John", "123456789", 1000.00);
        BankAccountView view = new BankAccountView();
        BankAccountController controller = new BankAccountController(account, view);
    }
}

class BankAccount {
    private String accName;
    private String accountNum;
    private double balance;

    public BankAccount(String accName, String accountNum, double balance) {
        this.accName = accName;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getAccName() {
        return accName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

class BankAccountView extends JFrame {
    private JTextField accounNumberField = new JTextField(20);
    private JTextField balanceField = new JTextField(20);
    private JTextField accountNameField = new JTextField(20);
    private JTextField amountField = new JTextField(20);
    private JButton depositButton = new JButton("Deposit");
    private JButton withdrawButton = new JButton("Withdraw");

    public BankAccountView() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 10));
        panel.add(new JLabel("Account Number:"));
        panel.add(accounNumberField);
        panel.add(new JLabel("Account Name:"));
        panel.add(accountNameField);
        panel.add(new JLabel("Balance:"));
        panel.add(balanceField);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);

        balanceField.setEditable(false);
        accounNumberField.setEditable(false);
        accountNameField.setEditable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.add(panel);
        setVisible(true);
    }

    public String getAccountNumber() {
        return accounNumberField.getText();
    }

    public String getAccountName() {
        return accountNameField.getText();
    }

    public double getAmount() {
        try {
            return Double.parseDouble(amountField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void setBalance(double balance) {
        balanceField.setText(String.valueOf(balance));
    }

    public void setAccountNumber(String accountNumber) {
        accounNumberField.setText(accountNumber);
    }

    public void setAccountName(String accountName) {
        accountNameField.setText(accountName);
    }

    public void addDepositListener(ActionListener listenerForDepositButton) {
        depositButton.addActionListener(listenerForDepositButton);
    }

    public void addWithdrawListener(ActionListener listenerForWithdrawButton) {
        withdrawButton.addActionListener(listenerForWithdrawButton);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

class BankAccountController {
    private BankAccount model;
    private BankAccountView view;

    BankAccountController(BankAccount model, BankAccountView view) {
        this.model = model;
        this.view = view;
        view.setAccountNumber(model.getAccountNum());
        view.setAccountName(model.getAccName());
        view.setBalance(model.getBalance());
        view.addDepositListener(new DepositListener());
        view.addWithdrawListener(new WithdrawListener());
    }

    class DepositListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double amount = view.getAmount();
            model.deposit(amount);
            view.setBalance(model.getBalance());
            view.showMessage("Deposited: " + amount + " THB");
        }
    }

    class WithdrawListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double amount = view.getAmount();
            model.withdraw(amount);
            view.setBalance(model.getBalance());
            view.showMessage("Withdrawn: " + amount + " THB");
        }
    }
}
