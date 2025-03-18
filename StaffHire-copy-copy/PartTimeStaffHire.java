public class PartTimeStaffHire extends StaffHire {
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName, 
                             String joiningDate, String qualification, String appointedBy, boolean joined, 
                             int workingHour, double wagesPerHour, String shifts) {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }

    public void setShifts(String newShifts) {
        if (isJoined()) {
            shifts = newShifts;
        }
    }

    public void terminateStaff() {
    if (!terminated) {
        setStaffName("");  
        setJoiningDate("");
        setQualification("");
        setAppointedBy("");
        setJoined(false);
        terminated = true;
    } else {
        System.out.println("Staff already terminated.");
    }
}

    @Override
    public void display() {
        super.display();
        System.out.println("Working Hours: " + workingHour);
        System.out.println("Wages Per Hour: " + wagesPerHour);
        System.out.println("Shifts: " + shifts);
        System.out.println("Terminated: " + terminated);
        System.out.println("Income Per Day: " + (wagesPerHour * workingHour));
    }
}