public class Main {
    public static void main(String[] args) {
        Cafeteira espresso = new CafeteiraExpresso();
        System.out.println("Preparando Espresso:");
        espresso.prepararCafe();

        System.out.println("\nPreparando Cappuccino:");
        Cafeteira cappuccino = new CafeteiraCappuccino();
        cappuccino.prepararCafe();
    }
}
