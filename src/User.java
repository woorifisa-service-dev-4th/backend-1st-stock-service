import java.util.HashMap;
import java.util.Map;

public class User {
    private int cash;
    private Map<String, Integer> holdings;

    public User() {
        this.cash = 0;
        this.holdings = new HashMap<>();
    }

    public void deposit(int amount) {
        this.cash += amount;
    }

    public boolean buy(Stock stock, int quantity) {
        int totalCost = stock.getPrice() * quantity;
        if (totalCost > cash) return false;
        
        cash -= totalCost;
        holdings.merge(stock.getCode(), quantity, Integer::sum);
        return true;
    }

    public boolean sell(Stock stock, int quantity) {
        int currentQuantity = holdings.getOrDefault(stock.getCode(), 0);
        if (currentQuantity < quantity) return false;

        cash += stock.getPrice() * quantity;
        holdings.put(stock.getCode(), currentQuantity - quantity);
        return true;
    }

    public int getCash() { return cash; }
    public Map<String, Integer> getHoldings() { return holdings; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("현금 : ").append(Utils.formatMoney(cash)).append("원\n");

        if (holdings.isEmpty()) {
            sb.append("보유 종목: 없음\n");
        } else {
            sb.append("보유 종목:\n");
            holdings.forEach((code, quantity) ->
                sb.append(code).append(": ").append(quantity).append("주\n"));
        }

        return sb.toString();
    }

}
