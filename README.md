# Taok-collector

---

## Padronizar Consumo de API do Portal da Transparência

Hoje para consumirmos dados do portal da transparência e bem complicado, pela complexidade da organiazação das informações e etc

Esta biblioteca que implementa os padrões definidos no `taok-collector-api`, tentará ajudar desenvolvedores a consumir dados abertos de qualquer município do Brasil.


## Como instalar?

Para usar essa biblioteca basta fazer o clone do repositório e executar o comando de install do maven:

```
git clone https://github.com/cassunde/taok-collector-impl
cd taok-collector-impl/
mvn install
```

Incluir trecho abaixo no pom.xml

```xml
<dependency>
  <groupId>br.com.taok</groupId>
  <artifactId>collector-impl</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <scope>compile</scope>
</dependency>
```

## Como usar?

Para usar teremos que criar um objeto `Search` e informar os parâmetros que desejaremos usar para buscar informações na API das prefeituras.

**Parêmetros**

- Provider
- startDate
- endDate
