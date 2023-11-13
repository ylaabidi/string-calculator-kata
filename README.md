# String Calculator kata
Démonstration de la pratique du Test Driven Development [(Source originale)](http://osherove.com/tdd-kata-1/)

## Consignes avant de commencer
- Éviter de lire les étapes à l’avance.
- Faire une tâche à la fois, démontrez votre capacité à respecter le cycle du TDD.
- Ne réaliser que les tests dont les entrées sont correctes.
- Montrer votre capacité à bien nommer les choses.

## Ce qu’il faut réaliser
Le StringCalculator permet de calculer la somme de nombres passés en argument sous la forme d’une chaîne de caractères.

- Créer une classe StringCalculator ayant une méthode int Add(string input). Cette méthode peut prendre 0, 1 ou 2 nombres et retourne la somme.
  - “” retourne 0.
  - “1” retourne 1.
  - “1,2” retourne 3. La virgule est utilisé comme délimiteur.
- Permettre à la méthode Add de gérer un nombre inconnu de nombres.
  - “1,2,3,4,5” retourne 15.
- Permettre à la méthode Add de gérer également les sauts de ligne en tant que délimiteur.
  - “1\n2,3” retourne 6.
- Permettre à la méthode Add de supporter un délimiteur personnalisé (sur 1 caractère).
  - Le format est le suivant : “//{délimiteur}\n{nombres}”.
  - Exemple : “//;\n1,2;3” retourne 6.
- Permettre à la méthode Add de retourner une exception ayant comme message “Les nombres négatifs ne sont pas autorisés” si un nombre négatif est présent dans la chaîne.
  - S’il y en a plusieurs, les afficher : “Les nombres négatifs ne sont pas autorisés : -5, -10”. Exemple : “-5,2,-10,9”
- Permettre à la méthode Add d’ignorer les nombres supérieurs à 1000.
  - Exemple : “5,10,1664” retourne 15.
