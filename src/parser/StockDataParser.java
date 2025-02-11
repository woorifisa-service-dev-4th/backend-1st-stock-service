package parser;

import java.util.List;
import java.util.Map;

public interface StockDataParser {
    Map<String, Stock> parseStockData(String filename);
}
