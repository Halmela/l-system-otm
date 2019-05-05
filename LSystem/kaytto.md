# Käyttöohjeet
 
## Suoritus 
- Lataa uusin [release](https://github.com/Halmela/l-system-otm/releases)
- Luo suoritus-kansioon ´conf.txt´. [Esimerkki](https://github.com/Halmela/l-system-otm/blob/master/conf.txt) sisältää binääripuun.
- Suorita .jar
	- Komentoriviltä tämä onnistuu ´java -jar TIEDOSTO.jar´


## Käyttö

Ohjelma toimii dialogipohjaisesti. Ohjelma ei tallenna automaattisesti ennen kuvan piirtämistä, joten muista tallentaa ennen sitä.

# Konfigurointi

Voit kirjoittaa kirjoittaa omia l-systeemeitä seuraavalla syntaksilla:
AKSIOOMA;ITERAATIOT;ALOITUSX;ALOITUSY;KULMA(asteina);0;0;SÄÄNNÖT

Sääntöjen syntaksi:
MERKKI,TUOTANTOSÄÄNTÖ,PIIRTOSÄÄNTÖ1,PIIRTOSÄÄNTÖ2...:

Muista luoda säännöt jokaiselle merkille.

