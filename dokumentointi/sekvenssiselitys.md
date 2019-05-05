# Sekvenssikaavio

## Alustus
Ohjelman alkaessa Main kutsuu ui.Screenin. Screen luo dao.LSystemDaon, joka hakee conf.txt-tiedostoon talletetut L-systeemit ja muuntaa ne domain.LSystem-olioiksi, joiden sisällä on aloituspaikan määräävä domain.Vector. Screen antaa DAOn eteenpäin ui.CLI:lle.

## UI
CLIn kautta voidaan muuttaa saatavilla olevia LSystemeitä tai luoda ja tallentaa uusia. Yksi kuitenkin välitetään eteenpäin. Screenille ja sille luodaan oma domain.Overlord.

## Overlord
Overlord saa sisäänsä LSystemin, eristää siitä tuotantosäännöt ja antaa ne eteenpäin domain.StringCreatorille. StringCreator luo LSystemistä merkkijonoesityksen, jonka Overlord välittää eteenpäin domain.ImageLogicille LSystemistä eristettyjen piirtosääntöjen kanssa. Screen nappaa Overlordilta lopulliset piirtosäännöt ja piirtää niistä kuvan näytölle.
