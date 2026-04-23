# Modifications apportees - amelioration du projet IoC

## Objectif
Rendre le projet plus propre et evolutif avec une vraie demonstration d'inversion de controle:
- structure de packages coherente,
- strategie DAO configurable,
- tests d'integration plus representatifs.

## Principales ameliorations

### 1) Structure des packages harmonisee
- Les classes metier ont ete placees sous `src/main/java/com/mourad/inversion_controle/...`.
- Suppression des anciennes classes dupliques dans `src/main/java/dao`, `metier`, `pres` et `ex1`.

### 2) DAO configurable par propriete
- `DaoImpl` (mode local) est active quand `dao.type=local` (ou par defaut).
- `DaoWebServiceImpl` (mode web service) est active quand `dao.type=ws`.
- Les valeurs de donnees sont configurees via:
  - `dao.local.value`
  - `dao.ws.value`

### 3) Couche metier parametrable
- `MetierImpl` utilise:
  - un `IDao` injecte par Spring,
  - un multiplicateur configurable `business.multiplier`.
- Le calcul devient configurable sans toucher le code.

### 4) Presentation et logs
- `Presentation` reste un `CommandLineRunner` mais utilise un logger SLF4J au lieu de `System.out.println`.

### 5) Configuration centralisee
- `application.properties` contient maintenant des valeurs par defaut:
  - `business.multiplier=2`
  - `dao.type=local`
  - `dao.local.value=10`
  - `dao.ws.value=15`

### 6) Tests d'integration renforces
- `InversionControleApplicationTests`: valide le mode local (`20.0` attendu).
- `WebServiceDaoIntegrationTests`: valide le mode ws avec proprietes dediees (`75.0` attendu).

## Resultat
- Le projet montre mieux l'IoC en selectionnant automatiquement une implementation de `IDao` selon la configuration.
- La structure est plus lisible et plus maintenable.
- Les tests couvrent des scenarios reels de configuration.

## Fichiers concernes
- `src/main/resources/application.properties`
- `src/main/java/com/mourad/inversion_controle/dao/IDao.java`
- `src/main/java/com/mourad/inversion_controle/dao/DaoImpl.java`
- `src/main/java/com/mourad/inversion_controle/ex1/DaoWebServiceImpl.java`
- `src/main/java/com/mourad/inversion_controle/metier/IMetier.java`
- `src/main/java/com/mourad/inversion_controle/metier/MetierImpl.java`
- `src/main/java/com/mourad/inversion_controle/pres/Presentation.java`
- `src/test/java/com/mourad/inversion_controle/InversionControleApplicationTests.java`
- `src/test/java/com/mourad/inversion_controle/WebServiceDaoIntegrationTests.java`
