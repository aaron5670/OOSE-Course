# 📓 Aantekeningen

### Kan externe libraries toevoegen als Maven dependency.
Dependencies voeg je toe door in de pom.xml de XML toe tevoegen.
Dus bijvoorbeeld

```xml
<dependency>
     <groupId>junit</groupId>
     <artifactId>junit</artifactId>
     <version>3.8.1</version>
     <scope>test</scope>
</dependency>
```
Deze moeten dan binnen de ``<dependencies>`` komen

### Kan versies van dependencies aanpassen.
Versie van dependencies aanpassen kan in de XML tag <version> 3.8.1 </version>. Let wel op voor 
sommige versies meot bijvoorbeeld de hele XML <dependency> aangepast worden. Bijvoorbeeld bij Junit


### Kan Maven command-line gebruiken voor het runnen en unit-testen van een applicatie.
mvn test voor alles dit doe je in de folder waar de pom.xml in staat
mvn 	
Hier is CalculatorTest de class die gestest gaat worden en testMinus de methode die getest gaat worden.

### Kent de lifecycle van Maven met minimaal de goals clean, compile, test en package
**clean:** hier word de pre-clean clean en post-clean. Dit cleans het project dit betekend dat oude files verwijderd worden. 
*bijvoorbeeld als je een class renamed wordt die wordt bewaart in vorige compiled versions. Totdat je clean runt*

**compile:** hier wordt de source code van het project gecompileert

**test:** test the compiled source met gebruik van een gepast unit testing framework

**package:** verpak de gecompileerde code in een goed format bijvoorbeeld JAR
