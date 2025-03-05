public class CafeteiraExpresso extends Cafeteira {
    @Override
    protected void prepararIngredientePrincipal() {
        System.out.println("Moendo grãos finos para expresso...");
    }
}
