public abstract class Cafeteira {
    // Método Template (final para evitar sobrescrita)
    public final void prepararCafe() {
        ferverAgua();
        prepararIngredientePrincipal();
        misturar();
        servir();
    }

    // Métodos concretos (compartilhados)
    private void ferverAgua() {
        System.out.println("Fervendo água...");
    }

    private void misturar() {
        System.out.println("Misturando tudo...");
    }

    private void servir() {
        System.out.println("Servindo na xícara! ☕");
    }

    // Método abstrato (deve ser implementado pelas subclasses)
    protected abstract void prepararIngredientePrincipal();
}
