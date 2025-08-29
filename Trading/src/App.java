import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;
public class App {
    public static void main(String[] args) {
        //For checking DB connection.
        Connection con=DataBaseConnection.getConnection();
        if(con!=null)
        {

            System.out.println("Connection successful!");
        } else {
            System.out.println(" Connection failed!");
        }

        Scanner sc = new Scanner(System.in);
        UserDAO dao = new UserDAO();

        while (true) {
            System.out.println("\n--- Energy Trading System ---");
            System.out.println("1. Add a Trade");
            System.out.println("2. View All Trades");
            System.out.println("3. Update Trade");
            System.out.println("4. Delete Trade");
            System.out.println("5. Search Trades");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Date (yyyy-mm-dd): ");
                    Date date = Date.valueOf(sc.nextLine());
                    System.out.print("Enter Counterparty: ");
                    String cp = sc.nextLine();
                    System.out.print("Enter Commodity: ");
                    String cmd = sc.nextLine();
                    System.out.print("Enter Volume: ");
                    double vol = sc.nextDouble();
                    System.out.print("Enter Price: ");
                    double pr = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Trade Type (BUY/SELL): ");
                    String tt = sc.nextLine();

                    dao.addTrade(new User(date, cp, cmd, vol, pr, tt));
                }
                case 2 -> {
                    List<User> trades = dao.getAllTrades();
                    trades.forEach(t -> System.out.println(
                        t.getTradeID() + " | " + t.getTradeDate() + " | " +
                        t.getCounterparty() + " | " + t.getCommodity() +
                        " | Vol: " + t.getVolume() + " | Price: " + t.getPrice() +
                        " | " + t.getTradeType()
                    ));
                }
                case 3 -> {
                    System.out.print("Enter Trade ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Price: ");
                    double np = sc.nextDouble();
                    System.out.print("Enter New Volume: ");
                    double nv = sc.nextDouble();
                    dao.updateTrade(id, np, nv);
                }
                case 4 -> {
                    System.out.print("Enter Trade ID: ");
                    int id = sc.nextInt();
                    dao.deleteTrade(id);
                }
                case 5 -> {
                    System.out.print("Enter Counterparty/Commodity keyword: ");
                    String kw = sc.nextLine();
                    List<User> results = dao.searchTrades(kw);
                    results.forEach(t -> System.out.println(
                        t.getTradeID() + " | " + t.getTradeDate() + " | " +
                        t.getCounterparty() + " | " + t.getCommodity() +
                        " | Vol: " + t.getVolume() + " | Price: " + t.getPrice() +
                        " | " + t.getTradeType()
                    ));
                }
                case 6 -> {
                    System.out.println("Exiting... Bye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid Choice.");
            }
    }
}
}

