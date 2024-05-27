package Model;

public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPhoneNum;
    private String userAddress;
    private String userGender;
    private String userImage;
    private boolean isCustomer;
    private boolean isGuest;

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    public void setCustomer(boolean isCustomer) {
        this.isCustomer = isCustomer;
    }

    public boolean isGuest() {
        return isGuest;
    }

    public void setGuest(boolean isGuest) {
        this.isGuest = isGuest;
    }
}
