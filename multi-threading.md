# 📓 Aantekeningen

### Kan met de API-onderdelen Thread en Runnable een class multi-threaded maken
Kan op verschillende manieren:

```java
Thread t1 = new Thread(() -> bank.stort(50));
Thread t2 = new Thread(() -> bank.neemOp(80));
Thread t3 = new Thread(() -> bank.neemOp(100));

t1.start();
t2.start();
t3.start();
```

Bij deze erven de klasses stortthread en opnamethread van thread en hebben deze een methode run met daarin de implementie
```java
StortThread stort1 = new StortThread(bank, 50);
OpnameThread opname1 = new OpnameThread(bank, 80);
OpnameThread opname2 = new OpnameThread(bank, 100);

stort1.start();
opname1.start();
opname2.start();
```

### Kan een thread correct starten en stoppen en kent de beperkingen van de API bij het stoppen. 
starten met .start() NOOIT MET .RUN() stoppen doet de thread automatisch als die klaar is.
Dit is deprecated in de nieuwe versies van java.

### Kan het keyword synchronized correct inzetten om te voorkomen dat threads tegelijk een gedeelde resource benaderen.
Synchorized zorgt ervoor dat een methode zeg maar beschermd is en niet meer dan 1 thread er tegelijk bij kan.

### Weet het verschil tussen multi-threading en multi-processing en welke rol de JVM, een besturingssysteem en de processor met zijn cores hierin spelen.
Voor het maken van Threads in Java zijn twee dingen van belang:

De (functionele) interface java.lang.Runnable
Een functionele interface met dus maar één enkele methode (genaamd run()). 

De Klasse java.lang.Thread
Een Klasse met een contructor die een Runnable als parameter heeft. Wanneer de methode start() wordt aangeroepen zal een aparte Thread worden gemaakt, waarop de methode run() van de Runnable wordt aangeroepen.

Implementeer de interface java.lang.Runnable
Geef een zinnige invulling aan de run() methode
Maak een instantie van java.lang.Thread
Geef de Runnable mee aan de constructor van java.lang.Thread
Roep de methode start() aan op je instantie van java.lang.Thread


Wanneer in een programma verscheidende Threads lopen, kunnen er problemen optreden met synchronisatie.

Dit is optelossen met synchronized
Dit probleem treedt op als de Threads acties uitvoeren, die dezelfde gegevens veranderen. Bij de min of meer gelijktijdige veranderingen kunnen fouten optreden.

