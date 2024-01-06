# Jeu Tower Defense 
Projet rendu pour Programmation oriente objet (POO) L2 informatique Paris cite

eleves: 
- Beales Archie
- Jin Christophe

L2 informatique groupe 1
## Utilisation
Pour lancer le jeu on a 2 modes differents:
- le mode terminal
- le mode graphic

### prerequesites
```
jdk 11 ou version superieur
```

### compilation des fichiers
```
cd path/to/project/towerDefense/
```
```
javac -cp src/java src/java/main/*.java
```

### Lancer le mode graphic
```
java -cp src/java main.Main
```
### Lancer le mode Terminal
```
java -cp src/java main.TermMain
```


## How to Play (mode graphic)

### Parametrages:
Dans le menu "Settings" vous pouvez activer ou desactiver les 
String debugs dans le terminal du jeu en clickant sur le bouton "true" ou "false"

### Choisir un niveau

Apres avoir clicker sur le bouton "play" vous allez voir les niveau disponibles. pour jouer a un niveau clicker sur le bouton "Play" a droite de chaque niveau

### Preparation

Des la partie lancez vous avez un temps infini pour vous preparer aux vagues de monstres qui vont arriver. Vous pouvez clicker sur les block d'herbe pour ajouter des tours qui font des degats et tues les monstres quand ils arrivent.
Si vous voulez enlever un tour il suffit de clicker sur la tour que vous souhaiter enlever.
Mais faites attention, chaque tour coute de l'argent qui est limites. 

Des que vous etes heureux avec votre placement de tours appuiyer sur le bouton "start" en bas de la page

### La vague

Pendant les enchainement des vagues ils suffit de regarder votre travaille en action, les monstre vont venir automatiquement vague par vague.
Si trop de monstres arrivent a la fin et que votre hp tombe en-dessous de 0 vous avez perdu. Mais si vous arriver a tuer les monstres vous aurez gagnez.

### la fin

Si vous etes mort ou vivant la partie se termine toujour par un menu avez comme choix de revenir au menu principale
L'argent que vous avez gagnez dans la partie reste en memoire donc vous pouvez le re-utiliser pour repartir dans un autre niveau.
## sources
ascii art for castle
https://www.asciiart.eu/buildings-and-places/castles

