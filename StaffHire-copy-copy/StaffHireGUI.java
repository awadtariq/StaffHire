import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StaffHireGUI {
    private JFrame frame;
    private JTextField vacancyNumberField, designationField, jobTypeField, staffNameField, joiningDateField,
            qualificationField, appointedByField, salaryField, weeklyHoursField, workingHoursField,
            wagesPerHourField, shiftsField;
    private JButton addFullTimeBtn, addPartTimeBtn, setSalaryBtn, setShiftBtn, terminateBtn, displayBtn, clearBtn;
    private ArrayList<StaffHire> staffList;

    public StaffHireGUI() {
        frame = new JFrame("Staff Hire Management");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        staffList = new ArrayList<>();

        // Creating a panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(12, 2, 5, 5));

        // Create Labels and Text Fields
        inputPanel.add(new JLabel("Vacancy Number:"));
        vacancyNumberField = new JTextField();
        inputPanel.add(vacancyNumberField);

        inputPanel.add(new JLabel("Designation:"));
        designationField = new JTextField();
        inputPanel.add(designationField);

        inputPanel.add(new JLabel("Job Type:"));
        jobTypeField = new JTextField();
        inputPanel.add(jobTypeField);

        inputPanel.add(new JLabel("Staff Name:"));
        staffNameField = new JTextField();
        inputPanel.add(staffNameField);

        inputPanel.add(new JLabel("Joining Date:"));
        joiningDateField = new JTextField();
        inputPanel.add(joiningDateField);

        inputPanel.add(new JLabel("Qualification:"));
        qualificationField = new JTextField();
        inputPanel.add(qualificationField);

        inputPanel.add(new JLabel("Appointed By:"));
        appointedByField = new JTextField();
        inputPanel.add(appointedByField);

        inputPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        inputPanel.add(salaryField);

        inputPanel.add(new JLabel("Weekly Fractional Hours:"));
        weeklyHoursField = new JTextField();
        inputPanel.add(weeklyHoursField);

        inputPanel.add(new JLabel("Working Hours:"));
        workingHoursField = new JTextField();
        inputPanel.add(workingHoursField);

        inputPanel.add(new JLabel("Wages Per Hour:"));
        wagesPerHourField = new JTextField();
        inputPanel.add(wagesPerHourField);

        inputPanel.add(new JLabel("Shifts:"));
        shiftsField = new JTextField();
        inputPanel.add(shiftsField);

        // Creating a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 2, 5, 5)); // Organize buttons in a grid

        // Buttons
        addFullTimeBtn = new JButton("Add Full Time Staff");
        addPartTimeBtn = new JButton("Add Part Time Staff");
        setSalaryBtn = new JButton("Set Salary - Full Time");
        setShiftBtn = new JButton("Set Working Shifts - Part Time");
        terminateBtn = new JButton("Terminate Part Time Staff");
        displayBtn = new JButton("Display Staff Details");
        clearBtn = new JButton("Clear");

        // Add buttons to the panel
        buttonPanel.add(addFullTimeBtn);
        buttonPanel.add(addPartTimeBtn);
        buttonPanel.add(setSalaryBtn);
        buttonPanel.add(setShiftBtn);
        buttonPanel.add(terminateBtn);
        buttonPanel.add(displayBtn);
        buttonPanel.add(clearBtn);

        // Action Listeners
        addFullTimeBtn.addActionListener(e -> addFullTimeStaff());
        addPartTimeBtn.addActionListener(e -> addPartTimeStaff());
        setSalaryBtn.addActionListener(e -> setSalary());
        setShiftBtn.addActionListener(e -> setShifts());
        terminateBtn.addActionListener(e -> terminatePartTimeStaff());
        displayBtn.addActionListener(e -> displayStaff());
        clearBtn.addActionListener(e -> clearFields());

        // Add panels to frame
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addFullTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String designation = designationField.getText();
            String jobType = jobTypeField.getText();
            String staffName = staffNameField.getText();
            String joiningDate = joiningDateField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = !staffName.isEmpty();
            double salary = Double.parseDouble(salaryField.getText());
            int weeklyHours = Integer.parseInt(weeklyHoursField.getText());

            FullTimeStaffHire staff = new FullTimeStaffHire(vacancyNumber, designation, jobType, staffName,
                    joiningDate, qualification, appointedBy, joined, salary, weeklyHours);
            staffList.add(staff);
            JOptionPane.showMessageDialog(frame, "Full Time Staff Added Successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Input! Please check your data.");
        }
    }

    private void addPartTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String designation = designationField.getText();
            String jobType = jobTypeField.getText();
            String staffName = staffNameField.getText();
            String joiningDate = joiningDateField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = !staffName.isEmpty();
            int workingHours = Integer.parseInt(workingHoursField.getText());
            double wagesPerHour = Double.parseDouble(wagesPerHourField.getText());
            String shifts = shiftsField.getText();

            PartTimeStaffHire staff = new PartTimeStaffHire(vacancyNumber, designation, jobType, staffName,
                    joiningDate, qualification, appointedBy, joined, workingHours, wagesPerHour, shifts);
            staffList.add(staff);
            JOptionPane.showMessageDialog(frame, "Part Time Staff Added Successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Input! Please check your data.");
        }
    }

    private void displayStaff() {
        for (StaffHire staff : staffList) {
            staff.display();
        }
    }

    private void clearFields() {
        vacancyNumberField.setText("");
        designationField.setText("");
        staffNameField.setText("");
        jobTypeField.setText("");
        joiningDateField.setText("");
        qualificationField.setText("");
        appointedByField.setText("");
        salaryField.setText("");
        weeklyHoursField.setText("");
        workingHoursField.setText("");
        wagesPerHourField.setText("");
        shiftsField.setText("");
    }

    public static void main(String[] args) {
        new StaffHireGUI();
    }
}
