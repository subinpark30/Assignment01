import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Kiosk {
    private static Order order;
    private static int orderCount = 0;

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        System.out.println("SHAKESHACK BURGER에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");

        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. Burgers         | 앵거스 비프 통살을 다져만든 버거");
        System.out.println("2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림");
        System.out.println("3. Drinks          | 매장에서 직접 만드는 음료");
        System.out.println("4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주");
        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order       | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel      | 진행중인 주문을 취소합니다.");

        processMainMenuInput();
    }

    private static void processMainMenuInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "0":
                displayFinalPrice();
                break;
            case "1":
                displayBurgersMenu();
                break;
            case "2":
                displayFrozenCustardMenu();
                break;
            case "3":
                displayDrinksMenu();
                break;
            case "4":
                displayBeerMenu();
                break;
            case "5":
                displayOrderMenu();
                break;
            case "6":
                displayCancelMenu();
                break;
            default:
                System.out.println("유효한 입력이 아닙니다. 다시 입력해주세요.");
                processMainMenuInput();
                break;
        }
    }
    private static void displayFinalPrice() {
        double finalPrice = order.getFinalPrice();
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ " + finalPrice + " ] 입니다.");
        System.out.println();
        System.out.println("1. 돌아가기");

        processFinalPriceInput();
    }
    private static void processFinalPriceInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        switch (input) {
            case "1":
                displayMainMenu();
                break;

            default:
                System.out.println("유효한 입력이 아닙니다. 다시 입력해주세요.");
                processFinalPriceInput();
                break;
        }
    }
    private static void displayBurgersMenu() {
        System.out.println("[ Burgers MENU ]");
        System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        System.out.println("3. Shroom Burger | W 9.4 | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거");
        System.out.println("4. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        System.out.println("5. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");

        processBurgersMenuInput();
    }

    private static void processBurgersMenuInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        switch (input) {
            case "1":
                addToCart(new Product("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
                break;
            case "2":
                addToCart(new Product("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
                break;
            case "3":
                addToCart(new Product("Shroom Burger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"));
                break;
            case "4":
                addToCart(new Product("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
                break;
            case "5":
                addToCart(new Product("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
                break;
            default:
                System.out.println("유효한 입력이 아닙니다. 다시 입력해주세요.");
                processBurgersMenuInput();
                break;
        }
    }

    private static void displayFrozenCustardMenu() {
        System.out.println("[ Frozen Custards MENU ]");
        System.out.println("1. Chocolate   | W 1.2 | 초코맛 프로즌 커스타드");
        System.out.println("2. Vanilla    | W 1.0 | 바닐라맛 프로즌 커스타드");

        processCustardsMenuInput();
    }

    private static void processCustardsMenuInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                addToCart(new Product("Chocolate", 1.2, "초코맛 프로즌 커스타드"));
                break;
            case "2":
                addToCart(new Product("Vanilla", 1.0, "바닐라맛 프로즌 커스타드"));
                break;
            default:
                System.out.println("유효한 입력이 아닙니다. 다시 입력해주세요.");
                processCustardsMenuInput();
                break;
        }
    }

    private static void displayDrinksMenu() {
        System.out.println("[ Drinks MENU ]");
        System.out.println("1. Coke   | W 0.4 | 코카콜라 맛있다");
        System.out.println("2. Zero Coke    | W 0.4 | 제로코크는 더 맛있다");

        processDrinksMenuInput();
    }
    private static void processDrinksMenuInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                addToCart(new Product("Coke", 0.4, "코카콜라 맛있다"));
                break;
            case "2":
                addToCart(new Product("Zero Coke", 0.4, "제로코크는 더 맛있다"));
                break;
            default:
                System.out.println("유효한 입력이 아닙니다. 다시 입력해주세요.");
                processDrinksMenuInput();
                break;
        }
    }
    private static void displayBeerMenu() {
        System.out.println("[ Beer MENU ]");
        System.out.println("1. Kelly   | W 0.4 | 켈리가 대세");
        System.out.println("2. Tera    | W 0.4 | 그래도 테라");

        processBeerMenuInput();
    }
    private static void processBeerMenuInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                addToCart(new Product("Kelly", 0.4, "켈리가 대세"));
                break;
            case "2":
                addToCart(new Product("Tera", 0.4, "그래도 테라"));
                break;
            default:
                System.out.println("유효한 입력이 아닙니다. 다시 입력해주세요.");
                processDrinksMenuInput();
                break;
        }
    }
    private static void displayOrderMenu() {
        System.out.println("[ Orders ]");
        List<Product> cart = order.getCart();
        Map<String, Integer> productCountMap = new HashMap<>(); // 상품 개수를 저장하는 맵

        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
        } else {
            for (Product product : cart) {
                String productName = product.getName();
                int count = productCountMap.getOrDefault(productName, 0);
                productCountMap.put(productName, count + 1);
            }

            for (Map.Entry<String, Integer> entry : productCountMap.entrySet()) {
                String productName = entry.getKey();
                int count = entry.getValue();
                for (Product product : cart) {
                    if (product.getName().equals(productName)) {
                        System.out.println(productName + " | W " + product.getPrice() + " | " + count + "개 | " + product.getDescription());
                        break;
                    }
                }
            }
        }

        double totalPrice = order.getTotalPrice();
        System.out.println("[ Total ]");
        System.out.println("W " + totalPrice);

        System.out.println("1. 주문");
        System.out.println("2. 메뉴판");

        processOrderMenuInput();
    }

    private static void processOrderMenuInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                completeOrder();
                break;
            case "2":
                displayMainMenu();
                break;
            default:
                System.out.println("유효한 입력이 아닙니다. 다시 입력해주세요.");
                processOrderMenuInput();
                break;
        }
    }

    private static void completeOrder() {
        System.out.println("주문이 완료되었습니다!");
        orderCount++;
        System.out.println("대기번호는 [ " + orderCount + " ] 번 입니다.");

        order.clearCart();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        displayMainMenu();
    }

    private static void displayCancelMenu() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인");
        System.out.println("2. 취소");

        processCancelMenuInput();
    }

    private static void processCancelMenuInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                cancelOrder();
                break;
            case "2":
                displayCancelMenu();
                break;
            default:
                System.out.println("유효한 입력이 아닙니다. 다시 입력해주세요.");
                processCancelMenuInput();
                break;
        }
    }

    private static void cancelOrder() {
        System.out.println("진행하던 주문이 취소되었습니다.");

        order.clearCart();

        displayMainMenu();
    }

    private static void addToCart(Product product) {
        if (order == null) {
            // 최초의 주문일 경우 Order 객체 생성
            order = new Order();
        }
        order.addToCart(product);
        System.out.println(product.getName() + " 가 장바구니에 추가되었습니다.");
        displayMainMenu();
    }
}
