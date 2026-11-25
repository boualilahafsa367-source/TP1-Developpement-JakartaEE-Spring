# TP 1 : Programmation dynamique par réflexion en Java

**Exercice 1 : Programmation dynamique par réflexion**

=> Figure 1: Exécution du programme – Injection des dépendances et calcul du résultat
<img width="959" height="158" alt="image" src="https://github.com/user-attachments/assets/1b968468-b29a-44ee-8687-3da173484b95" />

Cet exercice consiste à développer une application Java en utilisant le principe de la programmation dynamique par réflexion. L'objectif principal est de comprendre comment charger des classes, créer des objets et injecter des dépendances dynamiquement, sans avoir besoin de créer directement les instances avec l'opérateur `new` dans la classe principale.

Pour réaliser ce programme, plusieurs packages ont été créés afin d'organiser les différentes parties de l'application : 'dao', 'metier' et 'presentation'.

La première partie du programme concerne le package 'dao', dans lequel une interface appelée 'IDao' a été créée. Cette interface définit une méthode 'getValue()' qui retourne une valeur de type 'double'. Elle permet de préciser le comportement attendu pour récupérer une valeur numérique, sans définir directement son implémentation.

Une classe appelée 'DaoImpl' a ensuite été développée dans le même package. Elle implémente l'interface 'IDao' et redéfinit sa méthode 'getValue()'. Dans notre implémentation, cette méthode retourne une valeur fixe de **100.0**. Cette classe représente la source de données utilisée par le reste de l'application.

La deuxième partie concerne le package 'metier'. Une interface nommée 'IMetier' y a été créée. Elle définit une méthode 'calcul()' qui retourne également un nombre de type 'double'. Cette interface représente le traitement métier que l'application doit effectuer.

La classe 'MetierImpl' a ensuite été créée pour implémenter cette interface. Elle contient un attribut privé de type 'IDao', qui permet de recevoir une instance de la classe d'accès aux données. Une méthode 'setDao()' a été ajoutée pour effectuer l'injection de cette dépendance. Cette méthode reçoit un objet de type 'IDao' et l'affecte à l'attribut 'dao'.

La méthode 'calcul()' est ensuite redéfinie pour récupérer la valeur retournée par 'dao.getValue()' et la multiplier par deux. Dans notre cas, puisque la méthode 'getValue()' retourne **100.0**, le calcul effectué donne un résultat de **200.0**.

La troisième partie du programme concerne le package 'presentation', dans lequel une classe appelée 'Presentation2' a été créée. Elle représente le point d'entrée de l'application et contient la méthode principale 'main()'. Son rôle est de charger dynamiquement les classes et de réaliser l'injection des dépendances en utilisant les mécanismes de réflexion de Java.

Pour cela, un fichier de configuration nommé 'config.txt' a été créé à la racine du projet. Ce fichier contient les noms complets des classes à utiliser, chacun sur une ligne :

- "dao.DaoImpl"
- "metier.MetierImpl"

La classe 'Presentation2' utilise la classe 'Scanner' pour lire ces deux noms depuis le fichier de configuration. Ensuite, la méthode 'Class.forName()' permet de charger dynamiquement chaque classe à partir de son nom.

La création des objets est réalisée grâce à 'getDeclaredConstructor().newInstance()'. Cette instruction permet d'obtenir le constructeur sans paramètres et de créer une nouvelle instance de la classe correspondante. Les objets créés sont ensuite convertis vers les interfaces 'IDao' et 'IMetier' afin de pouvoir être utilisés dans le programme.

L'injection de la dépendance est effectuée à l'aide de la réflexion. Pour cela, la méthode 'getMethod("setDao", IDao.class)' permet de récupérer la méthode 'setDao()' de la classe 'MetierImpl'. Ensuite, 'invoke(metier, dao)' permet d'appeler cette méthode dynamiquement en lui transmettant l'objet DAO créé précédemment.

Enfin, le programme appelle la méthode 'calcul()' sur l'objet 'metier' et affiche le résultat dans la console à l'aide de 'System.out.println()'.

Pour vérifier le fonctionnement de l'application, les différentes classes ont été organisées dans leurs packages respectifs, puis le fichier de configuration a été ajouté à la racine du projet. La classe 'Presentation2' a ensuite été exécutée dans Eclipse en tant que Java Application.

Le résultat obtenu dans la console est le suivant :

text :
Résultats = 200.0


Ce résultat confirme le bon fonctionnement du programme : la classe 'DaoImpl' fournit la valeur **100.0**, puis la classe 'MetierImpl' effectue le calcul en multipliant cette valeur par deux.

Cet exercice permet ainsi de mettre en pratique plusieurs notions importantes de Java, notamment les interfaces, l'implémentation des interfaces, la séparation du programme en packages, l'injection de dépendances et la réflexion. Il montre également comment un fichier de configuration peut être utilisé pour modifier les classes employées par une application sans devoir changer directement le code de la classe principale.
