package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TXTStockParser implements StockDataParser {
    @Override
    public Map<String, Stock> parseStockData(String filename) {
        Map<String, Stock> stocks = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length == 3) {
                    String code = data[0].trim();
                    String name = data[1].trim();
                    int price = Integer.parseInt(data[2].trim());
                    stocks.put(code, new Stock(code, name, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return stocks;
    }
}
