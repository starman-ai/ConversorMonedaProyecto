import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ExchangeRateAPI {
    public ExchangeRateResponse buscaMoneda(String denominacionBase) {
        // Crear la URI con la dirección de la API
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/4406ee5b0b4a24a5c5d9315e/latest/" + denominacionBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRateResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la moneda", e);
        }
    }

    // Clase interna para modelar la respuesta JSON
    public static class ExchangeRateResponse {
        private String base_code;
        private Map<String, Double> conversion_rates;

        public String getBaseCode() {
            return base_code;
        }

        public Map<String, Double> getRates() {
            return conversion_rates;
        }
    }
}
