# IDATT2105 Fullstackutvikling
### Gruppemedlemmer
- Aleksander Brekke Røed
- Erlend Rønning
- Nicolai Thorer Sivesind

## Kort om løsningen vår
> Vi har laget en web-applikasjon som tillater studenter å stille seg i kø for å få hjelp eller godkjenning av øvinger.

### Hva vi har bygget løsningen med
Vi har tatt i bruk flere av konseptene fra undervisningen i dette emnet for å vise hva vi har lært:

**Frontend**
+ Vue.js
    + Vuex
    + Vue Router
    + Vee-Validate
    + Axios
+ Javascript
+ Responsivt design med CSS
    + Flexbox
    + CSS-Grid

**Backend**
+ RESTful API
    + Spring Boot med lagmodell
    + JWT autentisering
    + Swagger

+ Databaseløsning
    + JPA 
    + Hibernate

### Arbeidsprosess
Vi startet prosjektet med å delegere ulike hovedansvar:
+ Frontend og UI-Design - Nicolai
+ Backend - Erlend
+ Backend, Testing og Swagger - Aleksander

Dette er kun hovedansvar - Alle medlemmene har vært med å implementere funksjonalitet i både frontend og backend.

## Generell funksjonalitet

### Praktisk
> Her er en oversikt over funksjonaliteter web-applikasjonen tilbyr i praksis.

#### Innlogging, utlogging og validering
+ Registrering av brukere mot database
+ Innlogging og utlogging av brukere
+ Alle input-felt valideres før innsending
+ Lagring av bruker i nettleser slik at de kan forlate siden og komme tilbake uten å måtte logge på på nytt.

#### Emne- og Køside
+ Oversikt over emner brukeren er med i
+ Oversikt over kø knyttet til et fag
    + Viser hvor lang køen er og evt. hvilken posisjon brukeren har i køen om den er med i den.
    + Oppdatering av kø hvert 15. sekund
    + Viser hvem som får hjelp av øvingslærer ved at disse køelementene er lyseblå
    + Egen funksjonalitet for studenter
        + Studenter kan melde seg inn i kø for et emne, og spesialisere informasjonen i køelementet sitt.
    + Egen funksjonalitet for Øvingslærere
        + Øvingslærer kan ikke bli med i kø.
        + Får sin egen verktøyboks som lar dem:
            + Fjerne køelementer
            + Skru av og på hvilke køelementer/studenter som får hjelp
            + Godkjenne øvinger (ikke ferdigimplementert)

#### Administrator side
+ Oppretting av nye emner med importering av studentene som skal være med ved bruk av CSV-fil.
+ Gi brukere administratorrettigheter
+ Fjerne emner

### Annen funksjonalitet
+ JSON Webtoken-basert autentisering av forespørsler
+ Tester på backend
+ Continous Integration som kjører testene hver gang vi pusher.

### Demonstrasjonsvideo
https://user-images.githubusercontent.com/70381155/161971070-25b9fabb-e9b8-4b4a-bfde-8d3240385da9.mov

---

## Frontend-funksjonalitet
### Registrering, innlogging og input-validering
#### Registrering av bruker
  Desktop             |  Mobil
:-------------------------:|:-------------------------:
 ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4b6.png) |  ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4b8.png)

<br>

#### Innloggingsside
  Desktop             |  Mobil
:-------------------------:|:-------------------------:
 ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4b9.png) |  ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4ba.png)

<br>

#### Validering 
   Desktop             |  Mobil
:-------------------------:|:-------------------------:
 ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4bc.png) |   ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4bb.png)
 


### Oversiktside
 >  Her får brukere oversikt over hvilke emner de har tilgang på, og mulighet til å åpne køsiden for disse emnene.
 >  
  Desktop             |  Mobil
:-------------------------:|:-------------------------:
 ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b48f.png) |  ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b491.png)

*Hovedsiden for alle brukere*

### Køside
 Denne siden gir brukeren oversikt over køen til et spesifikt emne der studenter og studentassistenter har tilgang på ulik funksjonalitet.
 Desktop             |  Mobil
:-------------------------:|:-------------------------:
 ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b493.png) |  ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b497.png)

*Køsiden til Fullstack Applikasjonsutvikling*

 
#### Studenter
Brukere med studentrettigheter kan se køen og stille seg i den med tilpassede forespørsler:
+ Legge inn hvor de sitter (evt. discord)
+ Hvilken øving det gjelder
+ Hva slags hjelp de trenger
+ Forlate køen
+ Forespørselen viser også hvor mange minutter studenten har stått i køen

*Skjema for innmelding i kø*
Desktop             |  Mobil
:-------------------------:|:-------------------------:
 ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4b4.png) |  ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b498.png)

<br>
        
#### Studentassistenter
Brukere med rolle som øvingslærer får sin egen verktøyboks der de kan:
+ Godkjenne øvinger
+ Sette at en student får (eller ikke får hjelp slik at alle som ser køen får denne informasjonen ved at denne studentens rad i køen endrer farge.
+ Fjerne studenter fra køen

*Køside for student assistenter*
Desktop             |  Mobil
:-------------------------:|:-------------------------:
 ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4bd.png) |  ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4be.png)
 
 Her kan vi se at de har sin egen verktøyboks. Der de kan godkjenne øving, sette at de hjelper studenten eller fjerne de fra køen.

### Administratorside
Administratorsiden gir følgende funksjonalitet:
+ Legge til nye fag og importering av studenter med CSV
+ Gi brukerrettigheter
+ Slette emner

*Administratorside*
Desktop             |  Mobil
:-------------------------:|:-------------------------:
 ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4c1.png) |  ![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4c2.png)

### Responsivt design
 > Vi har implementert et design som skal passe for både mobil- og laptop-enheter. Dette har vi gjort ved bruk av:
+ Mobile First prinsippet:
    + Start minste enhet og utvid for større skjermer
    + Eliminere unødvendige elementer
    + Laste inn innhold som kun er relevant for enheten
        + Desktop pleier å ha flere elementer og mer som må lastes inn
        + Lazy-loading av ekstra elementer til desktop
+ CSS Flexbox og grid
+ CSS Media queries

*Videoeksempel på responsivt design på køsiden*
https://user-images.githubusercontent.com/70381155/161951227-40560346-b177-4f76-897f-1f44b5684236.mov

I denne videoen kan vi se at når siden blir større enn 750px så:
+ Blir navigasjonsbaren tynnere og får skygge under seg
+ Køelementene sin tekst endrer seg fra to rader til en rad.

*Eksempel på bruk av CSS-media queries til å tilpasse navigasjonsbar for nettleser*
```css
@media screen and (min-width: 750px){
  #nav-space {
    height: 60px;
  }

  #nav {
    height: 50px;
    box-shadow: 0 2px 10px 0 rgba(0, 0, 0, 0.3);
  }
}
```

---

### Backend-funksjonalitet
**Oppsett av backend**
Backenden til tjenesten vår er laget med Spring Boot JPA og bruker en H2-database. Den tilbyr funksjonalitet for brukerhåndtering, samt øvingsgodkjenning og administrator-handlinger.

**Arkitektur**
Arkitekturen til backenden er i henhold til den lagdelte modellen Spring Boot legger opp til. Dette vil si at vi har et presentasjonslag med controllere, et businesslag med services og et persistenslag med repositoryer. I tillegg har vi en pakke med entities som fungerer som tabeller i databasen hvor klassevariablene blir kolonnene i tabellene. I tillegg har vi en pakke med modeller som ikke blir brukt i databasen, og en pakke med verktøy som brukes i sammenheng med autentiseringen av forespørsler. Slik ser pakkehierarkiet ut i backenden:

![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b486.png)

*Typisk håndtering av en forespørsel til backenden*


Controlleren spesifiserer pathen forespørselen må gjøres til, og bruker service for å utføre den. Her fra QueueController.java
![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4d0.png)

Servicen bruker repositoryet. Fra QueueServiceImpl.java
![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4d4.png)


**Relasjonsdatabase**
Databaseløsningen har kun én mange-til-mange relasjon, mellom Person og Subject, og den opprettes slik i Person.java:

![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b480.png)

Tabellene i databasen blir da seende slik ut:

![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b481.png)

**Assignment komposit nøkkel**
For å sette opp en komposit nøkkel for assignments, måtte vi lage en egen klasse som holdt nøklene. Dette bruker vi med @IdClass. Etter dette måtte vi definere nøklene som ID slik som på bildet.

![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4c4.png)

Tabellen ser da slik ut:

![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4c9.png)



**JSON Web Token-basert autentisering**
Autentisering er implementert i form av JSON Web Token (JWT). Et JWT request-filter legges til i Spring Security sin filter chain i SecurityConfig.java. Denne typen autentisering krever at en frontenden lagrer brukerens token midlertidig, og legger denne ved som en header i forespørselene sine til backenden.

**Swagger implementering**
For å dokumentere endpoint-api så bruker vi swagger. Dette implementerte vi i pom.xml filen med org.springdoc. For å bruke den med autentisering måtte vi også legge den inn  i securityconfig filen. Her slipper vi gjennom alle spørringer som skjer fra swagger. Dette er bare gjort for å kunne teste programmet og ville vært implementert med passord seinere. Når du kjører programmet finner du swagger på url: localhost:8081/swagger-ui/index.html#/. Deretter skriver du i explorer feltet: /javainuse-openapi. Du får da mulighet til å teste endpointene.

![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4c7.png)

**Tester**
For å teste programmet junit og Mockito. Før hver test måtte vi sette opp en mock som bestemte hva som skulle returneres. Dette måtte vi gjøre da innhold i databasen vil bli slettet mellom hver test. Her er et eksempel på hva vi gjorde før person testen:

![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4ca.png)

Og her kan vi se hvordan vi brukte det i en av enhets testene: 

![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4cb.png)

Og her kan vi se hvordan vi brukte det i en av integrasjonstestene:

![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4cc.png)

**Øving innlevering**
I backend fikk vi implementert at student assistenter skulle kunne si hvilke øvinger som var godkjent og hvilke som ikka var det. 

![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4cf.png)


Dette fikk vi ikke tid til å legge inn i front-end.

**Continuous integration**
I Github brukte vi CI som kompilerer prosjektet og kjører testene våre når vi pusher. Dette var veldig hjelpsomt, da det sjekker at alt fungerer mellom hver gang vi gjør endringer.

![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4d2.png)

## Videre arbeid
+ Vise studenter status på øvingene sine
+ Implementere Godkjenning av øvinger i frontend
+ Gjøre routingen rollebasert
+ Administrator side som gjør at du kan komme til admin side hvis rollen din er administrator 

## Utfordringer under utvikling
+ Git sammenflettinger som forårsaket at gammel kode dukket opp og gjorde deler av løsningen korrupt
+ Førte til tidspress siste dagen som førte til lite ekstern dokumentering av prosjektet.

## Hvordan fikse feilene

## Metode 1: Git
>Vi har pushet opp en commit etter innleveringen som kun inneholder de fikset de tre linjene med kode som har gjort deler av løsningen vår korrupt. (se neste steg)

```console
$ git clone https://github.com/erl1erl1/qs3.git
```

## Metode 2: Gjøre endringene i den innleverte mappen:

### 1. CSV backend - lagrer feil objekt
Fil det gjelder: I backend-prosjektet - service/subject/SubjectServiceImpl.java
Linje: #138
Feilen: Den lagrer person-objekt og ikke personen som har blitt opprettt i databasetabellen

*Feil*
![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4d5.png)

*Riktig*
![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4d6.png)

### 2. CSV frontend - kaller på gammel autoriseringsfunksjon
Fil det gjelder: I vue-prosjektet - components/form/AddSubject.vue
Linje: #55
Feilen: Den kaller en gammel metode som sender ugyldig autentisering.
**Hvordan rette opp:** Endre![Uploading file..._0g9bqoyaq]()
 "authHeaderCSV" til "authHeader"

**Feil**
![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4d9.png)


**Riktig**
![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4db.png)


### 3. Fjerne godkjenn-øvingskall
Fil det gjelder: I vue-prosjektet - components/QueueItem.vue
Linje: 75
Feil: Denne funksjonen ble vi ikke ferdig med, og gir feilmelding om den kjøres.
**Hvordan rette opp:** Fjern linjen helt

**Feil**
![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4d7.png)

**Riktig**
![](https://codimd.s3.shivering-isles.com/demo/uploads/44fa0f91ce1d47acab119b4d8.png)

## Hvordan kjøre programmet
### Kjøre backend

1. Åpne folderet *Backend* i en terminal og kjør:
```console
 $ mvn clean install
   ``` 
2. Deretter kan du kjøre programvaren ved:
```console
$ mvn exec:java -Dexec.mainClass="idi.bidata.burritobanden.qs3.Qs3Application" -s "pom.xml"
```
*OBS: det er viktig at serveren kjøres på port 8080. Pass derfor på at denne porten er tilgjengelig*

### Kjøre frontend
1. Åpne folderet "qs" i en terminal og kjør:
```console
$ npm install
```
2. Deretter kan du kjøre programvaren ved:
```console
$ npm run serve
```

Du kan nå åpne nettleser:
http://localhost:8081

### Kjøre tester
1. Apne folderet *backend* i terminal og kjør:
```console
$ mvn test
```




