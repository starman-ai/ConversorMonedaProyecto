import java.time.LocalDateTime;

class Conversor {
    private final String monedaBase;
    private final String monedaObjetivo;
    private final Double cantidadACambiar;
    private final Double cantidadEnMonedaObjetivo;
    private final LocalDateTime tiempo;

    public Conversor(String monedaBase, String monedaObjetivo, Double cantidadACambiar, Double cantidadEnMonedaObjetivo) {
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;
        this.cantidadACambiar = cantidadACambiar;
        this.cantidadEnMonedaObjetivo = cantidadEnMonedaObjetivo;
        this.tiempo = LocalDateTime.now();
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public Double getCantidadACambiar() {
        return cantidadACambiar;
    }

    public Double getCantidadEnMonedaObjetivo() {
        return cantidadEnMonedaObjetivo;
    }

    public LocalDateTime getTiempo() {
        return tiempo;
    }
}
