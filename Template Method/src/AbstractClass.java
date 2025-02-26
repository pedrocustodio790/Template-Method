public abstract class AbstractClass {

    // Método template (final para evitar sobrescrita)
    public final void templateMethod() {
        step1();
        step2();
        step3();
    }

    // Métodos abstratos (implementados pelas subclasses)
    protected abstract void step1();
    protected abstract void step3();

    // Método concreto (pode ser sobrescrito)
    protected void step2() {
        System.out.println("AbstractClass: Passo 2 (implementação padrão)");
    }
}