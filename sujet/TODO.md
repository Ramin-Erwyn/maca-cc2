# Travail à faire

En utilisant les patrons de conception étudiés et en se basant sur les sources qu'on vous fournit, 
écrivez des commandes qui permettra sur une ou plusieurs arborescences de fichiers données en argument :

## Exercice 1
Indiquer la taille totale (en KB ou MB ou GB) de l'arborescence.
__NB :__ La résolution de cet exercice est fournie en exemple. 
Il n'est donc pas à refaire.  

## Exercice 2
Indiquer par type T de fichier rencontré dans l'arborescence :
- le nombre de fichiers et la taille totale pour chaque type T de fichier, 
- puis la somme pour les nombres de fichiers et les tailles de chaque type.

Par exemple, si on suppose que __types__ est le nom de la commande en question, 
l'invocation suivante : 
```bash
gradle run --args='types -f src'
```
pourrait produire comme sortie :
````bash
+========================+==========+====================+
|           Content Type | Nb files | Total size (BYTES) |
+========================+==========+====================+
| text/x-java-properties |        1 |                229 |
|        application/xml |        2 |              1,596 |
|    text/x-web-markdown |        3 |              3,533 |
|     text/x-java-source |       58 |             63,172 |
|             text/plain |       18 |             18,553 |
+------------------------+----------+--------------------+
|          TOTAL (BYTES) |       82 |             87,083 |
+------------------------+----------+--------------------+
````

## Exercice 3
Indiquer par __type de fichier__ spécifié par un format texte parmi ceux listés dans le fichier 
 [src/main/resources/contenttypes.properties](../src/main/resources/contenttypes.properties) (ex., c, java, plantuml) :
- le nombre de fichiers de ce type,
- la taille totale des fichiers de ce type, 
- le nombre total de lignes sur l'ensemble des fichiers de ce type,
- puis la somme des nombres ci-dessus.

Par exemple, si on suppose que __langs__ est le nom de la commande en question, 
alors l'invocation suivante :
```bash
gradle run --args='langs -u KB -f chemin/vers/un/repertoire/sur/ma/machine'
```

produirait comme sortie :

```bash
+============+=======+=======+===========+
| Language   | Files | Lines | Size (KB) |
+============+=======+=======+===========+
| PROPERTIES | 12    | 97    | 3.577     |
| TEX        | 151   | 23239 | 1,012.877 |
| SHELL      | 20    | 1096  | 31.021    |
| MARKDOWN   | 4     | 24    | 0.835     |
| JAVA       | 331   | 12635 | 285.752   |
+------------+-------+-------+-----------+
| TOTAL (KB) | 518   | 37091 | 1,334.062 |
+------------+-------+-------+-----------+
``` 

Si on ne souhaite avoir les stats (en Kilo-octets) que sur les fichiers Java et Markdown, 
on pourrait faire l'invocation :
```bash
gradle run --args='langs -u KB -l java markdown -f chemin/vers/un/repertoire/sur/ma/machine
``` 

L'affichage s'adapterait en conséquence, ne montrant que le résultat de l'invocation sur les fichiers
Java et Markdown (ainsi que les totaux).

## Exercice 4
Pour un ensemble de types de fichier donnés spécifiés en entrée par leur type
(cf. [src/main/resources/contenttypes.properties](../src/main/resources/contenttypes.properties) comme dans l'exercice 3), 
les compresser dans une archive .zip.


Par exemple, si on suppose que __zip__ est le nom de la commande en question, alors 
l'invocation : 
```bash
gradle run --args='zip -l java markdown -d archive.zip -o -f chemin/vers/un/repertoire/sur/ma/machine
``` 
produirait l'archive __archive.zip__ contenant les fichiers Java et Markdown de l'arborescence spécifiée par -f.
L'option -o écrase la destination __archive.zip__ si elle existait déjà.

Si aucun type de fichier n'est spécifié avec l'option -l, alors cette commande compresse toute(s)
 l'arborescence spécifiée par -f.
 
 
# Résolution de l'exercice 1

__NB :__ La résolution de l'exercice 1 vous est fournie en exemple, à travers les classes :
- cmdline/impl/size/*.java
- visitors/size/*.java
- la déclaration du provider (cmdline.impl.size.SizeProvider) de la commande size 
[cmdline/impl/size/CommandSize.java](../src/main/java/cmdline/impl/size/CommandSize.java)
dans le fichier [services.cmdline.api.CommandLineProvider](../src/main/resources/META-INF/services/cmdline.api.CommandLineProvider)

# Rendu
Rendez tout le code source de votre application à la fin de la séance. 
Pour ce faire, compressez le répertoire de votre projet en un .zip que vous déposerez dans l'espace de ce devoir
sur coursenligne.