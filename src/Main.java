public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);

        while (true) {
            try {
                account.withDraw(6000);
                System.out.println("Снято 6000 сом. Текущий остаток: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println(e.getMessage() + " Остаток: " + e.getRemainingAmount());

                try {
                    account.withDraw((int) e.getRemainingAmount());
                    System.out.println("Снята оставшаяся сумма. Текущий счет: " + account.getAmount());
                } catch (LimitException ex) {}
                break;
            }
        }

    }
}
