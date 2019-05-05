# Arkkitehtuuri

## Toiminta

Main-luokka kutsuu Screen-luokkaa, joka määrittelee piirrettävän ikkunan koon ja L-systeemin piirto- ja tuotantosäännöt. Nämä säännöt välitetään eteenpäin Overlord-luokalle, joka eristää säännöt toisistaan ja luo StringCreator-luokan. StringCreator tekee merkkijonoesityksen tuotettavasta kuvasta tuotantosääntöjen perusteella. Overlord luo tämän esityksen avulla ImageLogic-olion, joka muokkaa merkeistä komentolistan, joka sen jälkeen jalostuu kuvan vektoriesitykseksi, eli listaksi piirrettäviä vektoreita. Vektoreina käytetään Vector-olioita.

Screen kutsuu Overlordin kautta ImageLogicin "piirtolistaa" ja piirtää sen perusteella lopullisen kuvan ikkunaan. 


## DAO

LSystemDao lukee ja kirjoittaa conf.txt-tiedostosta LSystemeitä. Se hoitaa myös tarvittavat muuttamiset tallentamista varten.

## Domain

LSystem säilyttää L-systeemin aksiooman, kaikki säännöt, aloitusvektorin ja iteraatioiden määrän.

Vector säilyttää alkamispaikkansa koordinaatit, pituuden, leveyden ja kulman. Se voi myös laskea päätepisteensä.

StringCreator luo aksiooman ja tuotantosääntöjen perusteella merkkijonoesityksen kuvasta.

ImageLogic luo merkkijonoesityksen perusteella listan vektoreita, joiden mukaan piirretään.

Overlord hoitaa lukee ja eristää säännöt StringCreatorille ja ImageLogicille LSystemDaolta saamastaan LSystemista, sekä yhdistää ne toisiinsa. Screen luo tämän olion.


# UI

Screen luo CLI:n, LSystemDaon ja Overlordin ja piirtää lopullisen kuvan.
