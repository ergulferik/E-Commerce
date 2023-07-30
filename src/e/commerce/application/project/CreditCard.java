package e.commerce.application.project;

public class CreditCard {

    private String cardNumber;
    private User cardUser;
    private int securityCode;
    private String expirationDate;
    private String cardName;
    private int password;

    public CreditCard(String cardNumber, User cardUser, int securityCode, String expirationDate, int password, String cardName, Data data) {
        this.cardNumber = cardNumber;
        this.cardUser = cardUser;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.cardName = cardName;
        this.password = password;

    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public User getCardUser() {
        return cardUser;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardUser(User cardUser) {
        this.cardUser = cardUser;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

}
