package Model;

public class Manager {
    private int managerId;
    private String managerEmail;
    private byte[] managerPassword;
    private String managerAddress;
    private String managerPhoneNum;
    private String managerGender;
    private boolean isAdmin;
    private boolean isStaff;

    // Getters and Setters
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public byte[] getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(byte[] managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerAddress() {
        return managerAddress;
    }

    public void setManagerAddress(String managerAddress) {
        this.managerAddress = managerAddress;
    }

    public String getManagerPhoneNum() {
        return managerPhoneNum;
    }

    public void setManagerPhoneNum(String managerPhoneNum) {
        this.managerPhoneNum = managerPhoneNum;
    }

    public String getManagerGender() {
        return managerGender;
    }

    public void setManagerGender(String managerGender) {
        this.managerGender = managerGender;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isStaff() {
        return isStaff;
    }

    public void setStaff(boolean isStaff) {
        this.isStaff = isStaff;
    }
}
