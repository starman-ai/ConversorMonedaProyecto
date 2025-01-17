import java.util.Map;

public class CurrencyConverter {
    private final ExchangeRateAPI exchangeRateAPI;
    private final Map<String, Double> conversionRates;

    public CurrencyConverter(String monedaBase) {
        // Instanciar la API de ExchangeRate
        this.exchangeRateAPI = new ExchangeRateAPI();
        this.conversionRates = cargarConversionRates(monedaBase);
    }

    private Map<String, Double> cargarConversionRates(String monedaBase) {
        // Obtener las tasas de conversión de la moneda base
        return exchangeRateAPI.buscaMoneda(monedaBase).getRates();
    }

    public Double getConversionRate(String monedaObjetivo) {
        // Obtener la tasa de conversión de la moneda objetivo
        if (conversionRates.containsKey(monedaObjetivo)) {
            // Devolver la tasa de conversión
            return conversionRates.get(monedaObjetivo);
        } else {
            // Lanzar una excepción si la moneda objetivo no está disponible
            throw new IllegalArgumentException("La moneda objetivo no está disponible.");
        }
    }
}
