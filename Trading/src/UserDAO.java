import java.sql.*;
import java.util.ArrayList;
import java.util.List;
  
public class UserDAO {
    public void addTrade(User user){
        String sql="INSERT INTO Trades (TradeDate,Counterparty, Commodity, Volume, Price, TradeType) VALUES(?,?,?,?,?,?) ";
        try(Connection con=DataBaseConnection.getConnection())
        {
            PreparedStatement st=con.prepareStatement(sql);
            st.setDate(1, user.getTradeDate());
            st.setString(2, user.getCounterparty());
            st.setString(3, user.getCommodity());
            st.setDouble(4, user.getVolume());
            st.setDouble(5, user.getPrice());
            st.setString(6, user.getTradeType());
            st.executeUpdate();
             System.out.println("Added Successfully.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        


    }

    public List<User> getAllTrades() {
        List<User> trades = new ArrayList<>();
        String sql = "SELECT * FROM Trades";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                trades.add(new User(
                    rs.getInt("TradeID"),
                    rs.getDate("TradeDate"),
                    rs.getString("Counterparty"),
                    rs.getString("Commodity"),
                    rs.getDouble("Volume"),
                    rs.getDouble("Price"),
                    rs.getString("TradeType")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trades;
    }

    public void updateTrade(int id, double newPrice, double newVolume) {
        String sql = "UPDATE Trades SET Price=?, Volume=? WHERE TradeID=?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement st= conn.prepareStatement(sql)) {
            st.setDouble(1, newPrice);
            st.setDouble(2, newVolume);
            st.setInt(3, id);
            int rows = st.executeUpdate();
            if (rows > 0) System.out.println("Trade Updated.");
            else System.out.println("Trade ID not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTrade(int id) {
        String sql = "DELETE FROM Trades WHERE TradeID=?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Trade Deleted.");
            else System.out.println("Trade ID not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        public List<User> searchTrades(String keyword) {
        List<User> trades = new ArrayList<>();
        String sql = "SELECT * FROM Trades WHERE Counterparty ILIKE ? OR Commodity ILIKE ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                trades.add(new User(
                    rs.getInt("TradeID"),
                    rs.getDate("TradeDate"),
                    rs.getString("Counterparty"),
                    rs.getString("Commodity"),
                    rs.getDouble("Volume"),
                    rs.getDouble("Price"),
                    rs.getString("TradeType")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trades;
    }
}


