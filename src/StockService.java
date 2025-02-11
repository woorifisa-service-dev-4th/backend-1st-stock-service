import parser.StockDataParser;

import java.util.Map;

public class StockService {
    private final Map<String, Stock> stockData;

    public StockService(StockDataParser parser, String filename) {
        this.stockData = parser.parseStockData(filename);
    }

    public Stock getStockInfo(String code) {
        return stockData.get(code);
    }
}
