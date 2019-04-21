# Arkkitehtuuri

## Toiminta

Main-luokka kutsuu Screen-luokkaa, joka määrittelee piirrettävän ikkunan koon ja L-systeemin piirto- ja tuotantosäännöt. Nämä säännöt välitetään eteenpäin Overlord-luokalle, joka eristää säännöt toisistaan ja luo StringCreator-luokan. StringCreator tekee merkkijonoesityksen tuotettavasta kuvasta tuotantosääntöjen perusteella. Overlord luo tämän esityksen avulla ImageLogic-olion, joka muokkaa merkeistä komentolistan, joka sen jälkeen jalostuu kuvan vektoriesitykseksi, eli listaksi piirrettäviä vektoreita. Vektoreina käytetään Vector-olioita.

Screen kutsuu Overlordin kautta ImageLogicin "piirtolistaa" ja piirtää sen perusteella lopullisen kuvan ikkunaan. 
