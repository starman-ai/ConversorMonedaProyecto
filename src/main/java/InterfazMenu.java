import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class InterfazMenu {
    // Menu de monedas disponibles
    private final String monedasDisponibles = """
                USD --- Dolar Estadounidense
                JPY --- Yen Japones
                CAD --- Dolar Canadiense
                KRW --- Won Surcoreano
                MXN --- Peso Mexicano
                COP --- Peso Colombiano
                ARS --- Peso Argentino
                EUR --- Euro""";

    public void mostrarMenuPrincipal() {
        System.out.println("==================================================================================");
        System.out.println("Ingrese la opcion que desea realizar: \n");
        String menuPrincipal = """
                1) Realizar una conversion
                2) Consultar historial de conversiones
                3) Salir del programa
                """;
        System.out.println(menuPrincipal);
    }

    public int leerOpcionPrincipal() {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Elija una opcion valida");
        System.out.println("==================================================================================");
        return lectura.nextInt();
    }

    public void mostrarMenuMonedas(String denominacion) {
        System.out.println("==================================================================================");
        System.out.println("Seleccione la denominacion " + denominacion + ": \n");
        System.out.println(monedasDisponibles);
        System.out.println("==================================================================================");
    }

    public String leerOpcionMoneda() {
        Scanner lectura = new Scanner(System.in);
        String opcion = lectura.nextLine().toLowerCase();
        while (!monedasDisponibles.toLowerCase().contains(opcion)) {
            System.out.println("La opcion seleccionada no esta disponible");
            System.out.println("Elija una opcion valida");
            System.out.println("==================================================================================");
            opcion = lectura.nextLine().toLowerCase();
        }
        return opcion.toUpperCase();
    }

    public Double leerCantidadACambiar() {
        System.out.println("==================================================================================");
        System.out.println("Ingrese la cantidad que desea cambiar: \n");
        System.out.println("==================================================================================");
        Scanner lectura = new Scanner(System.in);
        double cantidad;
        while (!lectura.hasNextDouble()) {
            System.out.println("==================================================================================");
            System.out.println("La cantidad ingresada no es un numero valido");
            System.out.println("Ingrese una cantidad valida");
            System.out.println("==================================================================================");
            lectura.nextLine();
        }
        cantidad = lectura.nextDouble();
        lectura.nextLine();
        return cantidad;
    }

    public Double cantidadObtenida(String monedaBase, Double cantidadCambiar, Double tasaDeConversion, String monedaFinal) {
        Double resultado = cantidadCambiar * tasaDeConversion;
        System.out.println("==================================================================================");
        System.out.println(cantidadCambiar + " " + monedaBase + " equivalen a: " + resultado + " " + monedaFinal);
        return resultado;
    }

    public void imprimirConversiones(ArrayList<Conversor> listaDeConversiones) {
        if (listaDeConversiones.isEmpty()) {
            System.out.println("No se han realizado conversiones.");
        } else {
            System.out.println("Historial de conversiones:");
            for (int i = 0; i < listaDeConversiones.size(); i++) {
                Conversor conversor = listaDeConversiones.get(i);
                System.out.println("Conversion " + (i + 1) + ":");
                System.out.println("Moneda origen: " + conversor.getMonedaBase());
                System.out.println("Moneda destino: " + conversor.getMonedaObjetivo());
                System.out.println("Cantidad a cambiar: " + conversor.getCantidadACambiar());
                System.out.println("Cantidad obtenida: " + conversor.getCantidadEnMonedaObjetivo());
                System.out.println("Fecha y hora: " + formatDateTime(conversor.getTiempo()));
                System.out.println("-----------------------------------------");
            }
        }
    }

    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }
}