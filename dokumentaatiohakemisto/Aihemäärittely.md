## Aihemäärittely

### Aihe:
#### Shakkipeli, jolla kaksi pelaajaa pystyvät pelaamaan normaalia shakkia 64 ruutuisella laudalla. Toinen pelaa mustilla nappuloilla ja toinen valkoisilla. Pelin tarkoitus on saada vastustajan kuningas kaadettua. Molemmilla pelaajilla on käytössä kahdeksan sotilasta, kaksi tornia, kaksi lähettiä, kaksi hevosta, kuningatar ja kuningas.Valkoinen pelaaja aloittaa pelin. 

### Käyttäjät: 
#### Kaksi pelaajaa, jotka pelaavat vuoron perään.

### Kaikkien käyttäjien toiminnot: 
- Pelaajat avaavat ohjelman.
- Valkoinen aloittaa pelin ensimmäisellä siirrolla ja musta hänen jälkeensä.
- Peli jatkuu kunnes toisen kuningas kaatuu. Peli loppuu kun peli kertoo "CheckMate!"

## Rakennekuvaus.
### Ohjelman main aloittaa ohjelman luomalla käyttöliittymän UI. Käyttöliittymä luo Mouselistenerin, joka kuuntelee ja reagoi hiireen, Drawdoardin, joka piirtää laudan ja nappulat ja GameLogicin joka toimii pelin logiikkana. GameLogic luo Laudan joka luo kaikki Spot oliot, jotka toimivat ruutuina, sekä CheckTester olion, joka tekee testisiirron kopiolaudalle ja tarkistaa joutuuko oma tai vastustajan kuningas shakkiin. Board Luo Ruuduille(Spot) Nappulat(ChessPiece), jotka voivat olla Kuningas, Kuningatar, Lähetti, Torni, Sotilas tai Ritari. Kaikki nämä kuuluvat ChessPiece- abstractiin luokkaan ja ovat aina kiinni jossakin ruudussa.

### Logiikka pystyy hakemaan laudan kautta ruutuja ja liikuttaa nappuloita. Nappulat liikuttavat itseään laudalla. Mouselistener käskee logiikan tekemään siirtoja. DrawBoard tekee graaffisen laudan ja nappulat. CheckTester tekee kopion laudasta ja katsoo tekeekö jokin siirto shakin. 

