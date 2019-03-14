# Structure de classes

On veut gérer des **produits**, les produits sont gérer par **stocks**.

On veut aussi gérer des **clients** liés à des **ventes**. Les ventes sont
organisées en **paniers**.

On souhaite également gérer des identifiants uniques.


## ID

> Un objet pour gérer des identifiants uniques.

```java
ID(String nomCategorie)
ID(int numeroSerie)
int get()
```


## Client


```java
ID id;
Date creation;
String prenom;
String nom;
String email;

Client(String prenom, String nom, String email)
```

## Produit

```java
ID numeroSerie;
Date dateEntree;

Produit(ID numeroSerie)
```


## Stock

```java
long codeBarre;
double prix;
double tva; // Peut être specifique au produit
List<Produit> produitsEnStock;

Stock(long codeBarre, double prix, double tva)
void ajouteProduit(Produit p)
Produit prendUnProduit()
```


## Vente

```java
Produit produitVendu;

Vente(Stock s)
```


## Panier

```java
ID id;
Date dateDeVente;
Client acheteur;
List<Vente> achats;
double valeurTotale;

Panier(Client acheteur)
void enregistreAchat(Vente achat)
```


## Magasin

> Représente le magasin avec ses stocks, ventes et clients

```java
List<Client> clients;
List<Panier> paniers;
List<Stock> stocks;

Magasin()
void enregistreClient(Client c)
void ajoutePanier(Panier p)
void ajouteStock(Stock s)
```
