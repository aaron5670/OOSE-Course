# 📓 Aantekeningen

### Kent de refactoring principes en weet wanneer en waarom code gerefactord moet worden.
Als er bad smells optreden dan meot je bij jezelf nadenken dat het anders moet.

### Kent de rol van refactoring in de TDD-cyclus. 
Dit doe je nadat je je tests en je code geschreven hebt. Om te kijken of je code kwaliteit beter gemaatk kan worden en of er bad smells in zitten.	

### Kent de volgende bad smells en herkent deze in broncode
- Duplicated Code
- Long Method and Large Class
- Magic Number
- Comments
- Message Chains
	
**Duplicated code**
Bijvoorbeeld 2 stukken die precies het zelfde doen maar de ene alleen voor een man en de ander voor een vrouw. dit kan
je oplossen door bijvoorbeeld er 1 methode met een parameter te maken.

**long method**
Dit is als een methode te lang is. Een vuist regel hiervoor is ze groot als je scherm is bijna te groot.

**Large Class**
Als een class teveel methodes of teveel variabele heeft en dus teveel afhankelijkheden. 
Hier moet je gaan bedenk of je niet iets moet verplaats

**Magic number**
Getallen die vaker weer komen kun je het best een variabele van maken. Hier dus een constannte van maken

**Comments**
Je moet je af vragen of deze comments wel nodig zijn. Of dat ze bijvoorbeeld alleen zeggen wat een methode doet haal ze dan weg.

**Message chains**
Als je bevijoorbeeld h.getFoo().getHoo().getLoo() hebt is dit fout. Dit moet opgesplits worden en misschien wel verplaats worden.

### Kent de volgende refactorings en kan deze in broncode toepassen om de bovenstaande bad smells te verwijderen
- Extract Constant
- Extract Method
- Move Method
- Extract Class.

Kan de refactoring opties van een IDE (IntelliJ, Eclipse) gebruiken.   
	

### Kent de volgende refactorings van naam maar hoeft deze niet zelfstandig toe te kunnen passen in broncode
- Replace Conditional with Polymorphism
- Replace Temp With Query. 

	




