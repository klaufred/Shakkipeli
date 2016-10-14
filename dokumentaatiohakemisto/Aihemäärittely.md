## Aihemäärittely

### Aihe:
#### Shakkipeli, jolla kaksi pelaajaa pystyvät pelaamaan normaalia shakkia 64 ruutuisella laudalla. Toinen pelaa mustilla nappuloilla ja toinen valkoisilla. Pelin tarkoitus on saada vastustajan kuningas kaadettua. Molemmilla pelaajilla on käytössä kahdeksan sotilasta, kaksi tornia, kaksi lähettiä, kaksi hevosta, kuningatar ja kuningas.Valkoinen pelaaja aloittaa pelin. 

### Käyttäjät: 
#### Kaksi pelaajaa, jotka pelaavat vuoron perään.

### Kaikkien käyttäjien toiminnot: 
- Pelaajat avaavat ohjelman.
- He päättävät kumpi pelaa valkoisella ja kumpi mustalla.
- Valkoinen aloittaa pelin ensimmäisellä siirrolla ja musta hänen jälkeensä.
- Peli jatkuu kunnes toisen kuningas kaatuu tai tulee tasapeli.

## Rakennekuvaus.
### Ohjelman main aloittaa ohjelman luomalla käyttöliittymän UI. Käyttöliittymä luo Mouselistenerin, joka kuuntelee ja reagoi hiireen, Drawdoardin, joka piirtää laudan ja nappulat ja Gamellogicin joka toimii pelin logiikkana. UI luo myös laudan joka luo kaikki Spot oliot, jotka toimivat ruutuina. Board Luo Ruuduille Nappulat, jotka voivat olla Kuningas, Kuningatar, Lähetti, Torni, Sotilas tai Ritari. Kaikki nämä kuuluvat ChessPiece- abstractiin luokkaan ja ovat aina kiinni jossakin ruudussa.

### Logiikka pystyy hakemaan laudan kautta ruutuja ja liikuttaa nappuloita. Nappulat liikuttavat itseään laudalla. Mouselistener käskee logiikan tekemään siirtoja.

