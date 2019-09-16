# Taok-collector

---

## Padronizar Consumo de API do Portal da Transparência

Hoje para consumirmos dados do portal da transparência e bem complicado, muito dessa complicação se deve a complexidade da organiazação das informações e etc

Esta biblioteca que implementa os padrões definidos no `taok-collector-api` tentará ajudar desenvolvedores a consumir dados abertos de qualquer município do Brasil.


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

Para usar teremos que criar um objeto `Search` e informar os parâmetros que desejaremos usar na busca das informações na API das prefeituras.

**Parêmetros**

- Provider
- StartDate
- EndDate

Vamos usar como exemplo obter dados do portal da transparência da prefeitura de fortaleza:

- Vamos criar um `Provider` chamado Cagece (Compania de Água e esgoto do estado do CE)

```java

Provider cagece = new Provider() {
			
  @Override
  public String getDescription() {
    return "Cagece";
  }

  @Override
  public String getCNPJ() {
    return "007.040.108/0001-57";
  }
};

```

Vamos criar 2 datas para usarmos como período.

```java
LocalDate startDate = LocalDate.of(2019, 7, 1);
LocalDate endDate = LocalDate.of(2019, 7, 31);
```

Agora vamos criar nosso objeto `Search`

```java
Search search = new Search(startDate, endDate, cagece, null);
```

Com esse objeto pronto podemos usar um dos `Collectors` disponiveis, nesse exemplo vamo usar Prefeitura de Fortaleza.

```java
Collector collector =  new CeFortalezaCollector();
collector.collectNow(search)
            .launchs() // retorna todos os lançamentos
            .providers() // retorna todos os providers encontrados 
            .amount(); // retorna o valor total obtido
```
