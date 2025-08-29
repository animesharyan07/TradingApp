import java.util.List;
import java.util.Scanner;
import java.sql.Date;

public class User{
    private int tradeID;
    private Date tradeDate;
    private String counterparty;
    private String commodity;
    private double volume;
    private double price;
    private String tradeType;

    public User(int tradeID, Date tradeDate, String counterparty, String commodity, double volume, double price, String tradeType) {
        this.tradeID = tradeID;
        this.tradeDate = tradeDate;
        this.counterparty = counterparty;
        this.commodity = commodity;
        this.volume = volume;
        this.price = price;
        this.tradeType = tradeType;
    }

    public User(Date tradeDate, String counterparty, String commodity, double volume, double price, String tradeType) {
        this(0, tradeDate, counterparty, commodity, volume, price, tradeType);
    }

    
    public int getTradeID() { return tradeID; }
    public Date getTradeDate() { return tradeDate; }
    public String getCounterparty() { return counterparty; }
    public String getCommodity() { return commodity; }
    public double getVolume() { return volume; }
    public double getPrice() { return price; }
    public String getTradeType() { return tradeType; }
}


