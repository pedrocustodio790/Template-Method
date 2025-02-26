public class ConcreteClass2 extends AbstractClass {

    @Override
    protected void step1() {
        System.out.println("ConcreteClass2: Passo 1 implementado");
    }

    @Override
    protected void step3() {
        System.out.println("ConcreteClass2: Passo 3 implementado");
    }

    @Override
    protected void step2() {
        System.out.println("ConcreteClass2: Passo 2 sobrescrito");
    }
}