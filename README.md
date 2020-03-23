# game-ui-dasilva59
game-ui-dasilva59 created by GitHub Classroom


Microservice fonctionnel et déployé sur heroku à l'adresse https://gameui-dasilva.herokuapp.com/.



Les routes disponibles sur ce microservice sont les suivantes:

 - GET: /fight/{opponent} affiche la view d'un combat entre la personne connectée et son opposant.
 
 - GET: /   page d'acceuil du service
 
 - GET: /pokedex  affiche le pokedex ( survoler la souris sur l image du pokemon permettra de le voir de face et ensuite de dos)
 
 - GET: /trainers affiche la liste de tous les dresseurs sauf celui qui est connecté ainsi que leur team.
 
 - GET: trainers/{name} affiche le profil du trainer name.
 
 - GET: /profile affiche le profil du trainer connecté
