public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("주식 데이터 파일을 지정해주세요.");
            return;
        }
        
        MockStockService mockStockService = new MockStockService(args[0]);
        mockStockService.run();
    }
}
