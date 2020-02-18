# 📓 Aantekeningen

### Kent de verschillen tussen checked en unchecked exceptions

Remember the biggest difference between checked and unchecked exceptions is that checked exceptions are forced by compiler
and used to indicate exceptional conditions that are out of the control of the program (for example, I/O errors), while unchecked
exceptions are occurred during runtime and used to indicate programming errors (for example, a null pointer).

### Kan gebruik maken van try en catch om een exception af te vangen
```java	
public void readFile() throws MyExampleException {
    File file = new File("/Users/joris/Desktop/text.txt");
    try {
        // Hier wordt iets uitgevoerfd wat kan misslukkken
    } catch (Exception e) {
        // hier wordt de exception gegooigd eigen gemaakt in dit geval
        throw new MyExampleException("Dikke error");
    } finally {
        //Hier komt die altijd
        System.out.println("Ik kom hier altijd");
    }
}
````

### Kan zelfstandig nieuwe exceptions instantieren en "gooien" met de keywords throw en throws.

```java
public class MyExampleException extends Exception {
      public MyExampleException(String message) {
         super(message);
      }
}
```

### Kan in unit tests checken of de juiste exception op het juiste moment komt.
	
```java
@Test
public void testDivideByZero(){
    assertThrows(IllegalArgumentException.class,
            () -> {
                calculator.divide(100,0);
            }
    );
}
```
