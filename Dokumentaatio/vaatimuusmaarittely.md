# Puutuotin

## Vaatimusmäärittely

### Sovelluksen tarkoitus

Puutuotin piirtää itseään toistavia kuvioita annettujen sääntöjen perusteella L-systeemiä käyttäen. Nämä kuviot voivat olla esimerkiksi kasveja tai fraktaaleja. Käyttäjä voi itse määritellä ja tallentaa sääntöjä, sekä muokata niiden avulla luotuja kuvia

#### L-systeemi

L-systeemi on biologi Aristid Lindenmayerin luoma järjestelmä, jonka avulla voidaan esittää itseääntoistavia rakennelmia, kuten puita, merkkijonoina. Järjestelmää määritellessä asetetaan käytettävät aakkosto, alkuperäinen merkkijono ja eri aakkosille säännöt. Jokaisella iteraatiolla jokainen merkki korvataan sääntöjoukosta löytyvän säännön mukaisella merkkijonolla. 

Merkkijonosta voidaan myös piirtää kuva ns. kilpikonnapiirtämistä käyttäen. Jokaiselle merkille määritetään myös säännöt, joiden pohjalta kuva piirretään. Esimerkiksi _A_ piirtää viivan eteenpäin ja _+_ kääntää piirturin suuntaa _α_ astetta oikealle. 

### Perusversion tarjoama toiminnallisuus

* Käyttäjä voi määritellä L-systeemin (niin merkkijonon luonnin kuin kuvan parametrit) itse ja tallettaa ne
* Ohjelma piirtää määritellyn kuvion
	* Ohjelman pitää myös kyetä skaalaamaan kuva ikkunan kokoiseksi
* Täysi tuki deterministisille L-systeemeille

### Jatkokehitysideoita

* Tuki stokastisille ja parametrillisille L-systeemeille
* Kuvion piirtämisen animointi
	* Joko iteraatio kerrallaan, viiva kerrallaan tai parhaassa tapauksessa puun kasvua simuloiva alhaalta ylöspäin kasvaminen
* Käyttäjälle mahdollisuus käyttää ohjelmaa komentoriviltä tai graafisessa ympäristössä
* Mahdollisuus konfiguroida ikkunasta ja kuvasta oikean kokoinen
* Useiden kuvioiden piirtäminen samaan kuvaan
* Merkkijonon ja kuvan tallentaminen erilliseen tiedostoon

