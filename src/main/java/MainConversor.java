import java.util.ArrayList;

public class MainConversor {
    public static void main(String[] args) {
        int opcionUsuario = 0;
        ArrayList<Conversor> listaDeConversiones = new ArrayList<>();
        System.out.println("==================================================================================\n");
        System.out.println("                    *** Bienvenid@ al conversor de moneda ***\n");

        while (opcionUsuario != 3) {
            InterfazMenu menu = new InterfazMenu();
            menu.mostrarMenuPrincipal();
            opcionUsuario = menu.leerOpcionPrincipal();

            switch (opcionUsuario) {
                case 1 -> {
                    menu.mostrarMenuMonedas("moneda base");
                    String monedaBase = menu.leerOpcionMoneda();
                    menu.mostrarMenuMonedas("moneda final");
                    String monedaFinal = menu.leerOpcionMoneda();
                    Double cantidadCambiar = menu.leerCantidadACambiar();

                    // Instanciar CurrencyConverter con la moneda base
                    CurrencyConverter converter = new CurrencyConverter(monedaBase);
                    Double tasaDeConversion = converter.getConversionRate(monedaFinal);
                    Double cantidadObtenida = menu.cantidadObtenida(monedaBase, cantidadCambiar, tasaDeConversion, monedaFinal);
                    Conversor nuevaConversion = new Conversor(monedaBase, monedaFinal, cantidadCambiar, cantidadObtenida);
                    listaDeConversiones.add(nuevaConversion);
                }
                case 2 -> menu.imprimirConversiones(listaDeConversiones);
                case 3 -> System.out.println("Hasta luego. Gracias por usar el conversor de moneda.");
                default -> System.out.println("Opcion invalida. Por favor, elija una opcion del menu.");
            }
        }
    }
}