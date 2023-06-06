# Ritprogram

Emil Kero

2023-06-06

## Inledning

Syftet med detta arbete var att skapa ett ritprogram där man kunde rita, sudda och ändra färg.
Det var en utveckling på ett ritprogram från ett tidigare arbete, vilket i sig var baserat på en grundläggande existerande mall.
Programmet skrevs i IntelliJ.

## Bakgrund

Det första som gjordes var att kopiera en mall för skapandet av en JFrame med tillhörande funktioner.
Sedan skapades en int vid namnet mode som representerade färgen på en ritfunktion som fungerade genom en if-sats.
Därefter skapades en annan if-sats som representerade suddfunktionen.
Två nya intar, x och y, skapades för att spara x- och y-värdena på musen.
Intarna sattes till att ändras beroende på om man tryckte/drog/flyttade musen, vilket gjorde att rit- och suddfunktionerna fungerade som de skulle.
För att kunna ändra färger skapades en ny string vid namnet color.
En lista skapades vid namnet colorchoice som listar upp ett antal färger man kan välja mellan.
Sedan skapades en JOptionPane som ger en dropdown-meny där man kan sätta color till en av färgerna i colorchoice när man trycker på c.
Inten mode gjordes om till en string för att kunna omvandla color till mode när musen trycks ned.
En ny ritfunktion skapades för varje egen färg och de sattes så att de användes när mode var lika med deras färg.
Titeln på fönstret ändrades för att klargöra att man skulle trycka på tangenten c.

## Positiva erfarenheter

Jag skulle säga att jag lyckades rätt så bra med att skapa metoden för att ändra färg, även fast det blev lite få färger.
Det är också möjligt att det skulle kunna göras på ett enklare sätt, men jag lyckades med det jag ville åstadkomma.

## Negativa erfarenheter

När man drar musen för snabbt i programmet blir det glapp i linjerna.
Detta försökte jag fixa genom att använda g.drawLine med hjälp av nya variabler för x- och y-värden istället för g.fillOval, men det gav några problem som jag inte kunde fixa.
För det första blev linjen för smal, och jag listade inte ut hur man ändrade tjockleken på linjen som ritades ut.
Ett annat problem var att linjerna blev "taggiga" och inte såg särskilt bra ut, vilket jag inte heller hittade någon lösning till.
Därför bestämde jag mig för att strunta i g.drawLine och körde med g.fillOval ändå, för jag tyckte att det blev bättre i helhet.
Mitt program skulle definitivt bli bättre om jag kunde lösa g.drawLine så som jag ville ha det.

## Sammanfattning

Jag skulle säga att jag fick fram ett program som fungerade så som jag ville ha det, förutom när det gäller g.drawLine.
Däremot är programmet långt ifrån ett perfekt ritprogram, och skulle kunna utökas med många fler funktioner såsom:

En "fill" funktion.

Fler färger, ett färghjul där man kan välja vilken färg som helst.

En "undo" knapp.

Funktioner som kan rita ut olika former.

Detta är bara några få av de många funktionerna som skulle behövas för att få ett utvecklat ritprogram.
