# IDATT2105 Fullstackutvikling
### Gruppemedlemmer
- Aleksander Brekke Røed
- Erlend Rønning
- Nicolai Thorer Sivesind


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

## Kjøre tester
1. Apne folderet *backend* i terminal og kjør:
```console
$ mvn test
```
