#EXERCICE 2

1er etape: C'EST UN TEST 

pour commencer j'ai crée un type avec une commande types -it pour tester 
j'obtien avec la commande gradle run --args "size -h" :

 
`-it, --types |  affiche le type  |  Default: false` 

Puis on avec la commande  gradle run --args="size -f src -it"
on obtien : ce n'est pas tout le contenue btw 
> Task :run
+======================================================================+==============+
| Content                                                              | Size (BYTES) |
+======================================================================+==============+
| src\main\java\client\App.java                                        | 1,608        |
| src\main\java\client                                                 | 0            |
| src\main\java\cmdline\api\BaseParams.java                            | 296          |
| src\main\java\cmdline\api\CommandLine.java                           | 192          |
+======================================================================+==============+
 
2 eme etape TYPE 

