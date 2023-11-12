import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PayrollCalculator extends JFrame {

    private JTextField txtEmployeeName, txtRatePerHour, txtHoursPerDay, txtDaysWorked, txtGrossSalary, txtNetSalary;

    public PayrollCalculator() {
        super("Payroll Calculator");

        
        JLabel lblEmployeeName = new JLabel("Employee Name:");
        JLabel lblRatePerHour = new JLabel("Rate per Hour:");
        JLabel lblHoursPerDay = new JLabel("Hours per Day:");
        JLabel lblDaysWorked = new JLabel("Days Worked:");
        JLabel lblGrossSalary = new JLabel("Gross Salary:");
        JLabel lblNetSalary = new JLabel("Net Salary:");

        
        txtEmployeeName = new JTextField("YourRegistrationNumber");
        txtRatePerHour = new JTextField();
        txtHoursPerDay = new JTextField();
        txtDaysWorked = new JTextField();
        txtGrossSalary = new JTextField();
        txtNetSalary = new JTextField();

        
        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(this::calculateSalary);

        
        setLayout(new GridLayout(7, 2, 5, 5));

        add(lblEmployeeName);
        add(txtEmployeeName);
        add(lblRatePerHour);
        add(txtRatePerHour);
        add(lblHoursPerDay);
        add(txtHoursPerDay);
        add(lblDaysWorked);
        add(txtDaysWorked);
        add(lblGrossSalary);
        add(txtGrossSalary);
        add(lblNetSalary);
        add(txtNetSalary);
        add(btnCalculate);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void calculateSalary(ActionEvent e) {
        try {
            double ratePerHour = Double.parseDouble(txtRatePerHour.getText());
            double hoursPerDay = Double.parseDouble(txtHoursPerDay.getText());
            int daysWorked = Integer.parseInt(txtDaysWorked.getText());

            double grossSalary = ratePerHour * hoursPerDay * daysWorked;
            double tax = 0.15 * grossSalary;
            double philhealth = 0.05 * grossSalary;
            double sss = 0.02 * grossSalary;
            double netSalary = grossSalary - tax - philhealth - sss;

            txtGrossSalary.setText(String.format("%.2f", grossSalary));
            txtNetSalary.setText(String.format("%.2f", netSalary));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PayrollCalculator().setVisible(true));
    }
}
