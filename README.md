**Parcial 1 - Desarrollo de Software**

- Nombre y Apellido: Julieta Paoloni
- Legajo: 48921
- Comisión: 3k9

# Instrucciones y características

Esta API permite detectar si un humano es mutante a partir de su secuencia de ADN.

### Características
- **Base de Datos**: Utiliza una base de datos H2.
- **Hosting**: Está hosteada en Render, y puedes accederla en [https://xmenparcial1.onrender.com](https://xmenparcial1.onrender.com).
  
## Nivel 2 - Postman
## Endpoints

### Detectar Mutante
- **Ruta**: `/api/v1/dna/mutant`
- **Método**: `POST`
- **Descripción**: Permite verificar si una secuencia de ADN pertenece a un mutante y la almacena en la base de datos.

Para detectar si una secuencia de ADN pertenece a un mutante, realizamos una solicitud HTTP `POST` en formato JSON a la URL [https://xmenparcial1.onrender.com/api/v1/dna/mutant](https://xmenparcial1.onrender.com/api/v1/dna/mutant) a través de Postman. En el cuerpo de la solicitud, escribimos:

```json
{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGACGG",
        "CAGCTA",
        "TCACTG"
    ]
}
```
 ![Postman](https://github.com/JulietaPaoloni/XMENS/blob/main/postman%20400.jfif)
 
Este ejemplo representa una secuencia de ADN de no mutante. Al enviar esta solicitud, el endpoint devolverá una respuesta 403 Forbidden. Si el ADN pertene a un mutante, devolverá una respuesta 200-OK.
```json
{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCATA",
        "TCACTG"
    ]
}
```
 ![Postman](https://github.com/JulietaPaoloni/XMENS/blob/main/postman%20200.jpeg)

Si al enviar una solicitud a la API la matriz de ADN no es de tipo `n x n` o si contiene letras que no son válidas (es decir, que no son 'A', 'T', 'C' o 'G'), la respuesta mostrará el siguiente mensaje de error: `{"error":"Error, por favor intente más tarde"}`.
Esto indica que la secuencia de ADN enviada no cumple con lo necesario.


## Nivel 3 - Servicio extra “/stats” 
Para obtener estadísticas sobre la base de datos de ADN, realizamos una solicitud HTTP `GET` a la ruta [https://xmenparcial1.onrender.com/api/v1/dna/stats](https://xmenparcial1.onrender.com/api/v1/dna/stats) a través de Postman. Al enviar esta solicitud, la API devolverá un objeto JSON que incluye la cantidad total de humanos, la cantidad total de mutantes y el ratio de humanos por mutante. La respuesta tendrá el siguiente formato:

```json
{
    "count_human_dna": 2.0,
    "count_mutant_dna": 2.0,
    "ratio": 1.0
}
```

![Postman](https://github.com/JulietaPaoloni/XMENS/blob/main/stats.PNG)

## Base de datos H2

La imagen muestra una consulta SQL ejecutada en una base de datos H2 para la entidad DNA,
con dos filas. La primera fila tiene un valor “mutante” como false. La segunda fila tiene un valor “mutante” como true.
![H2](https://github.com/JulietaPaoloni/XMENS/blob/main/h2.jfif)















 
