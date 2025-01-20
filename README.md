# Conversor de Moneda

Este proyecto es un programa en Java que permite realizar conversiones entre diferentes monedas utilizando tasas de cambio en tiempo real obtenidas de una API externa. También incluye funcionalidades para registrar y consultar el historial de conversiones realizadas.

## Funcionalidades

1. **Realizar Conversiones:**
   - Convierte una cantidad de una moneda base a una moneda objetivo utilizando tasas de cambio actuales.

2. **Consultar Historial de Conversiones:**
   - Visualiza un historial detallado de todas las conversiones realizadas, incluyendo:
     - Moneda base.
     - Moneda objetivo.
     - Cantidad convertida.
     - Tasa de cambio.
     - Fecha y hora de la conversión.

3. **Menú Interactivo:**
   - Navega fácilmente por las opciones utilizando un menú interactivo.

## Tecnologías Utilizadas

- **Lenguaje:** Java
- **API Externa:** [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tasas de cambio en tiempo real.
- **Gson:** Biblioteca para la deserialización de datos JSON.
- **Java HttpClient:** Cliente HTTP nativo para realizar solicitudes API.

## Clases Principales

### `MainConversor`
Clase principal que inicializa el programa y gestiona el menú interactivo. 

### `InterfazMenu`
Maneja la interacción con el usuario mediante la consola, mostrando menús y leyendo las entradas.

### `ExchangeRateAPI`
Realiza solicitudes a la API de tasas de cambio y deserializa las respuestas JSON.

### `CurrencyConverter`
Gestiona la lógica de conversión de moneda utilizando las tasas obtenidas por `ExchangeRateAPI`.

### `Conversor`
Modelo que almacena los detalles de una conversión, como la moneda base, la moneda objetivo, la cantidad convertida y la fecha/hora.

## Monedas Soportadas

- USD - Dólar Estadounidense
- JPY - Yen Japonés
- CAD - Dólar Canadiense
- KRW - Won Surcoreano
- MXN - Peso Mexicano
- COP - Peso Colombiano
- ARS - Peso Argentino
- EUR - Euro

## Requisitos Previos

1. **Java Development Kit (JDK):** Asegúrate de tener instalado JDK 11 o superior.
2. **Conexión a Internet:** El programa requiere conexión para consultar las tasas de cambio en tiempo real.
3. **Dependencias:**
   - Gson (añade esta biblioteca a tu proyecto para manejar JSON).

## Ejecución

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/starman-ai/ConversorMonedaProyecto.git

1. **Compila el proyecto:**
   ```bash
   javac MainConversor.java

1. **Clona el repositorio:**
   ```bash
   java MainConversor

## Estructura del Menú

### Opción 1 - Realizar una conversión:
1. Elige la moneda base.
2. Elige la moneda objetivo.
3. Ingresa la cantidad a convertir.

### Opción 2 - Consultar historial de conversiones:
- Muestra todas las conversiones realizadas con detalles.

### Opción 3 - Salir:
- Cierra el programa.

## Manejo de Errores
- Validación de monedas ingresadas.
- Manejo de entradas no numéricas en las cantidades.
- Control de errores en caso de problemas con la conexión a la API.
