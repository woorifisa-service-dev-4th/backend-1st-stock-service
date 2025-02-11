import java.util.Scanner;

public class MockStockService {
    private final Scanner scanner;
    private final User user;
    private final StockService stockService;

    public MockStockService() {
        this.scanner = new Scanner(System.in);
        this.user = new User();
        this.stockService = new StockService();
    }

    public void run() {
        try {
            processTrading();
        } finally {
            scanner.close();
        }
    }

    private void processTrading() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            if (choice == 4) break;

            executeAction(choice);
        }
    }

    private void displayMenu() {
        System.out.println("\n모의주식 프로그램에 오신것을 환영합니다");
        System.out.println("기능을 선택하세요 : 1. 거래 2. 내정보 3. 입금 4. 종료");
    }

    private void executeAction(int choice) {
        switch (choice) {
            case 1 -> handleTrading();
            case 2 -> System.out.println(user);
            case 3 -> handleDeposit();
        }
    }

    private void handleTrading() {
        System.out.print("주식 종목코드를 입력하세요 : ");
        String code = scanner.next();

        Stock stock = stockService.getStockInfo(code);
        if (stock == null) {
            System.out.println("올바르지 않은 종목코드입니다.");
            return;
        }

        displayStockInfo(stock);
        processTrade(stock);
    }

    private void displayStockInfo(Stock stock) {
        System.out.println("주식명 : " + stock.getName());
        System.out.println("현재가 : " + Utils.formatMoney(stock.getPrice()) + "원");
        System.out.println("기능을 선택하세요 : 1. 매수 2. 매도");
    }

    private void processTrade(Stock stock) {
        int choice = scanner.nextInt();
        System.out.print(choice == 1 ? "주문 수량을 입력하세요 : " : "매도 수량을 입력하세요 : ");
        int quantity = scanner.nextInt();

        boolean success = choice == 1 ? 
            user.buy(stock, quantity) : 
            user.sell(stock, quantity);

        System.out.println(success ? 
            (choice == 1 ? "매수 체결이 완료되었습니다." : "매도 체결이 완료되었습니다.") :
            (choice == 1 ? "현금이 부족합니다." : "수량이 부족합니다."));
    }

    private void handleDeposit() {
        System.out.print("얼마를 입금하시겠습니까? : ");
        int amount = scanner.nextInt();
        user.deposit(amount);
        
        System.out.println("보유 현금 : " + Utils.formatMoney(user.getCash()) + "원");
        System.out.println("입금이 완료되었습니다.");
    }
}
