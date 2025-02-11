package parser;

import java.util.Map;

public interface StockDataParser {

    Map<String, Stock> parseStockData(String filename);
}
