# 📓 Aantekeningen

### Kent het verschil tussen unit-tests en integration-tests. 
Unit-test werkt 1 object
Integration test: werken meerdere objecten samen

### Kan de scope van een unit-test bepalen. 
Het gaat vooral om methode te testen

### Kent de TDD red-green-refactor-cycle. 
Eerst de testcases schrijven en dan pas de code
Deze tests gebruiken voor het design 
En dan de implementatie van de code pas schrijven

**Red** — think about what you want to develop

**Green** — think about how to make your tests pass

**Refactor** — think about how to improve your existing implementation

Kan op de TDD wijze testcases definieren die zorgen voor 100% linecoverage van een of twee classes bestaande uit enkele methoden. 
Hierbij worden niet alleen "happy day"-scenario's getest maar ook randgevallen en uitzonderingen. 
Altijd 2 tests maken goed kijken naar alle mogelijkheiden die er zich voor kunnne doen. Bijvoorbeeld floats 1.0 
Denk hierbij dus ook aan delta hiermee kan je getallen achter de komma regelen bijvoorbeeld
	

### Kan JUnit als framework gebruiken om testcases te schrijven en uit te voeren 
```java
    @Test
    public void testTimes() {
        assertEquals(100, calculator.times(10,10));
        assertEquals(69, calculator.times(3,23));
    }


    @Test
    public void testSubstract() {
        assertEquals(100, calculator.subtract(105,5));
        assertEquals(10, calculator.subtract(200,190));
    }
```

### Kan unit tests uitvoeren in IntelliJ waarbij een coverage rapportage gegenereerd wordt.
Run with code coverage 

### Kan unit tests uitvoeren met Maven op de command-line.
  mvn test
  
  mvn -Dtest=CalculatorTest#testMinus test
  
  
Hier is CalculatorTest de class die gestest gaat worden en testMinus de methode die getest gaat worden.
