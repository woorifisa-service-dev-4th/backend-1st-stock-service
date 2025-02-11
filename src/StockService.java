public class StockService {

    public Stock getStockInfo(String code) {
        return switch (code) {
            case "005930" -> new Stock("005930", "삼성전자", 55600);
            case "000660" -> new Stock("000660", "SK하이닉스", 156800);
            case "035420" -> new Stock("035420", "NAVER", 213000);
            case "035720" -> new Stock("035720", "카카오", 56800);
            case "051910" -> new Stock("051910", "LG화학", 498000);
            case "006400" -> new Stock("006400", "삼성SDI", 456000);
            case "207940" -> new Stock("207940", "삼성바이오로직스", 789000);
            case "005380" -> new Stock("005380", "현대차", 189000);
            case "035900" -> new Stock("035900", "JYP Ent.", 89600);
            case "003670" -> new Stock("003670", "포스코퓨처엠", 345000);
            case "373220" -> new Stock("373220", "LG에너지솔루션", 398000);
            case "000270" -> new Stock("000270", "기아", 82400);
            case "068270" -> new Stock("068270", "셀트리온", 156700);
            case "105560" -> new Stock("105560", "KB금융", 56800);
            case "055550" -> new Stock("055550", "신한지주", 37800);
            case "096770" -> new Stock("096770", "SK이노베이션", 145000);
            case "017670" -> new Stock("017670", "SK텔레콤", 52300);
            case "015760" -> new Stock("015760", "한국전력", 19850);
            case "034220" -> new Stock("034220", "LG디스플레이", 12650);
            case "032830" -> new Stock("032830", "삼성생명", 65800);
            case "003490" -> new Stock("003490", "대한항공", 23450);
            case "086790" -> new Stock("086790", "하나금융지주", 45600);
            case "024110" -> new Stock("024110", "기업은행", 12400);
            case "034730" -> new Stock("034730", "SK", 156700);
            case "028260" -> new Stock("028260", "삼성물산", 112000);
            case "011200" -> new Stock("011200", "HMM", 16850);
            case "009540" -> new Stock("009540", "한국조선해양", 108500);
            case "090430" -> new Stock("090430", "아모레퍼시픽", 134500);
            case "018260" -> new Stock("018260", "삼성에스디에스", 167800);
            case "036570" -> new Stock("036570", "엔씨소프트", 234500);
            default -> null;
        };
    }
}
