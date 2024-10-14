**Parcial 1 - Desarrollo de Software**

- Nombre y Apellido: Julieta Paoloni
- Legajo: 48921
- Comisión: 3k9
  
**Nivel 2**

1.URL RENDER 

- /mutant: https://xmenparcial1.onrender.com/api/v1/dna/mutant

Explicación: Usamos este link para agregar un nuevo adn (dna en mi proyecto) a la base de datos a través de "postman". En el body colocamos una secuencia de adn en formato JSON, en este caso yo utilicé una para mutante y otra secuencia para no mutante.
Se adjunta imágen en el punto 2 de como agregamos un adn y en el punto 3 de como lo visualizamos en la base de datos h2.

- /stats: https://xmenparcial1.onrender.com/api/v1/dna/stats

 Explicación: En este link se detalla la cantidad de humanos, mutantes y la cantidad de humanos por mutante (ratio).



2.Postman



Podemos observar la creación de un mutante enviando la secuencia de ADN mediante un
HTTP POST con un Json, devolviendo un  HTTP 200-OK

 ![Postman](https://github.com/JulietaPaoloni/XMENS/blob/main/postman%20200.jpeg)

Podemos observar la creación de un no mutante enviando la secuencia de ADN mediante un HTTP POST con un Json, devolviendo un  HTTP 403-Forbidden
 ![Postman](https://github.com/JulietaPaoloni/XMENS/blob/main/postman%20400.jfif)


 3.Base de datos H2
 
 La imagen muestra una consulta SQL ejecutada en una base de datos H2 para la entidad DNA,
 con dos filas. La primera fila tiene un valor “mutante” como false. La segunda fila tiene un valor “mutante” como true.
 ![H2](https://github.com/JulietaPaoloni/XMENS/blob/main/h2.jfif)

 
