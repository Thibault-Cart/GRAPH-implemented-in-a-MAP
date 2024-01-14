/**
 * Graphe de type abstrait T mis dans une Map
 *
 * @author Ch. Stettler - HEG-Genève puis modifier par Thibault Cart
 */

import java.util.*;

class GraphDistance<T> {
    private Map<T, HashMap<T, Integer>> lstRelations;

    private Set<T> dejaVisites;


    /**
     * Constructeur
     */
    public GraphDistance() {
        lstRelations = new HashMap<>();
    }


    /**
     * Ajoute une relation entre deux noeuds
     *
     * @param source      le noeud source
     * @param destination le noeud destination
     */
    public void addRelation(T source, T destination, int distance) {

        //verifie si la source et la destination sont deja dans la liste
        if (!lstRelations.keySet().contains(source)) {
            lstRelations.put(source, null);
        }
        if (!lstRelations.keySet().contains(destination)) {
            lstRelations.put(destination, null);
        }
        // recupere la liste des relations de la source
        HashMap<T, Integer> relations = lstRelations.get(source);
        // si la liste est null, on la cree
        if (relations == null) {
            relations = new HashMap<T, Integer>();
            // on ajoute la destination a la liste
            relations.put(destination, distance);
            // on ajoute la liste a la source
            lstRelations.put(source, relations);
        } else {
            // sinon on ajoute la destination a la liste
            relations.put(destination, distance);
        }
        System.out.println("Relation ajoutée : " + source + " -> " + destination);
    }


    /**
     * Supprime une relation entre deux noeuds
     *
     * @param source      le noeud source
     * @param destination le noeud destination
     */

    public void deleteRelation(T source, T destination) {
        //si la source ou la destination n'existe pas dans la liste, on ne fait rien
        if (!lstRelations.keySet().contains(source) || !lstRelations.keySet().contains(destination)) {
            return;
        }

        // recupere la liste des relations de la source
        HashMap<T, Integer> relations = lstRelations.get(source);
        // si la liste est null, on la cree
        if (relations == null) {
            return;
        } else {
            // sinon on supprime la destination a la liste
            relations.remove(destination);
        }
        System.out.println("Relation supprimée : " + source + " -> " + destination);
    }


    /**
     * Verifie si une relation existe entre deux noeuds
     *
     * @param source      le noeud source
     * @param destination le noeud destination
     * @return true si la relation existe, false sinon
     */

    public boolean existeRelation(T source, T destination) {
        boolean existe = lstRelations.get(source) != null && lstRelations.get(source).containsKey(destination);
        if (existe) {
            System.out.println("La relation existe : " + source + " -> " + destination);
        } else {
            System.out.println("La relation n'existe pas : " + source + " -> " + destination);
        }

        return existe;
    }


    /**
     * Parcours en profondeur du graphe depuis un noeud source
     *
     * @param source le noeud source
     */
    public void parcoursProfondeur(T source) {
        dejaVisites = new HashSet<>();
        parcoursProfondeurRecursif(source);
        System.out.println();
    }

    /**
     * Parcours en profondeur du graphe depuis un noeud source
     *
     * @param noeud le noeud source ou courant dont on souhaite afficher les voisins
     */
    private void parcoursProfondeurRecursif(T noeud) {


        if (dejaVisites.contains(noeud)) {
            return;
        }   // si noeud déjà visité ==> return
        dejaVisites.add(noeud);

        // sinon affiche le noeud, puis appelle parcoursProfondeurRecursif pour tous ses voisins
        System.out.print(noeud + " ");

        HashMap<T, Integer> voisins = lstRelations.get(noeud);
        if (voisins == null) {
            return;
        }
        for (T voisin : voisins.keySet()) {

            parcoursProfondeurRecursif(voisin);
        }
    }

    /**
     * Verifie si un chemin existe entre deux noeuds
     *
     * @param source      le noeud source
     * @param destination le noeud destination
     * @return true si un chemin existe, false sinon
     */

    public boolean existeChemin(T source, T destination) {
        dejaVisites = new HashSet<>();
        boolean existeChemin = existeCheminRecursif(source, destination);
        if (existeChemin) {
            System.out.println("Il existe un chemin entre " + source + " et " + destination);
        } else {
            System.out.println("Il n'existe pas de chemin entre " + source + " et " + destination);
        }
        return existeChemin;

    }

    /**
     * Verifie si un chemin existe entre deux noeuds, en utilisant la recursivite
     *
     * @param source      le noeud source
     * @param destination le noeud destination
     * @return true si un chemin existe, false sinon
     */
    private boolean existeCheminRecursif(T source, T destination) {
        HashMap<T, Integer> allnode = lstRelations.get(source);

        if (source.equals(destination)) {
            return true;
        }
        if (allnode == null) {
            return false;
        } else {

            for (T noeud : allnode.keySet()) {
                if (noeud.equals(destination)) {
                    return true;
                }

            }
            for (T noeud : allnode.keySet()) {
                dejaVisites.add(noeud);
                if (noeud != null && !dejaVisites.contains(noeud)) {
                    return false;
                } else {
                    if (existeCheminRecursif(noeud, destination)) {
                        return true;
                    } else {
                        return false;
                    }
                }


            }
        }
        return false;
    }


    /**
     * Verifie si un cycle existe dans le graphe
     *
     * @return true si un cycle existe, false sinon
     */

    public boolean existeCycle() {
        dejaVisites = new HashSet<>();
        Set<T> tousLesNoeuds = lstRelations.keySet();

        for (T noeud : tousLesNoeuds) {
            if (!dejaVisites.contains(noeud) && existeCycleRecursif(noeud, null)) {
                System.out.println("Il existe un cycle dans le graphe.");
                return true;
            }
        }

        System.out.println("Il n'existe pas de cycle dans le graphe.");
        return false;
    }


    /**
     * Verifie si un cycle existe dans le graphe, en utilisant la recursivite
     *
     * @param noeud  le noeud courant
     * @param parent le noeud parent
     * @return true si un cycle existe, false sinon
     */
    private boolean existeCycleRecursif(T noeud, T parent) {
        dejaVisites.add(noeud);

        HashMap<T, Integer> voisins = lstRelations.get(noeud);
        if (voisins != null) {
            for (T voisin : voisins.keySet()) {
                if (!dejaVisites.contains(voisin)) {
                    if (existeCycleRecursif(voisin, noeud)) {
                        return true;
                    }
                } else if (!voisin.equals(parent)) {

                    return true;
                }
            }
        }

        dejaVisites.remove(noeud);
        return false;
    }


    /**
     * Affiche le chemin entre deux noeuds
     *
     * @param source      le noeud source
     * @param destination le noeud destination
     */
    public void afficherChemin(T source, T destination) {
        dejaVisites = new HashSet<>();
        List<T> chemin = new ArrayList<>();
        boolean cheminExiste = trouverChemin(source, destination, chemin);

        if (cheminExiste) {
            System.out.println("Chemin entre " + source + " et " + destination + ": ");

            // On enlève le noeud source du chemin
            chemin.remove(0);

            for (T node : chemin) {
                System.out.println("-->" + node);
            }
            System.out.println();
        } else {
            System.out.println("Pas de chemin entre " + source + " et " + destination);
        }
    }

    /**
     * Utilitaire pour trouver un chemin entre deux noeuds en utilisant la récursivité
     *
     * @param current     le noeud courant
     * @param destination le noeud destination
     * @param chemin      la liste pour stocker le chemin
     * @return true si un chemin existe, false sinon
     */
    private boolean trouverChemin(T current, T destination, List<T> chemin) {
        dejaVisites.add(current);
        chemin.add(current);

        if (current.equals(destination)) {
            return true;
        }

        HashMap<T, Integer> neighbors = lstRelations.get(current);
        if (neighbors != null) {
            for (T neighbor : neighbors.keySet()) {
                if (!dejaVisites.contains(neighbor)) {
                    if (trouverChemin(neighbor, destination, chemin)) {
                        return true;
                    }
                }
            }
        }

        //supprime le noeud courant de la liste
        chemin.removeLast();
        return false;
    }


    /**
     * Affiche les chemins les plus courts entre deux noeuds en utilisant l'algorithme de Dijkstra
     *
     * @param source      le noeud source
     * @param destination le noeud destination
     */
    public void afficherCheminsPlusCourts(T source, T destination) {
        // Vérifier si le graphe contient les nœuds source et destination
        if (!lstRelations.containsKey(source) || !lstRelations.containsKey(destination)) {
            System.out.println("Les nœuds source ou destination ne sont pas présents dans le graphe.");
            return;
        }

        // Initialiser les distances et les chemins
        Map<T, Integer> distances = new HashMap<>();
        Map<T, List<T>> chemins = new HashMap<>();
        PriorityQueue<NodeDistance<T>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(NodeDistance::getDistance));

        for (T node : lstRelations.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
            chemins.put(node, new ArrayList<>());
        }

        distances.put(source, 0);
        priorityQueue.offer(new NodeDistance<>(source, 0));

        while (!priorityQueue.isEmpty()) {
            NodeDistance<T> currentNode = priorityQueue.poll();

            if (currentNode.getDistance() > distances.get(currentNode.getNode())) {
                continue;
            }

            Map<T, Integer> neighbors = lstRelations.get(currentNode.getNode());
            if (neighbors != null) {
                for (Map.Entry<T, Integer> neighborEntry : neighbors.entrySet()) {
                    T neighbor = neighborEntry.getKey();
                    int newDistance = distances.get(currentNode.getNode()) + neighborEntry.getValue();

                    if (newDistance < distances.get(neighbor)) {
                        distances.put(neighbor, newDistance);
                        List<T> newPath = new ArrayList<>(chemins.get(currentNode.getNode()));
                        newPath.add(currentNode.getNode());
                        chemins.put(neighbor, newPath);
                        priorityQueue.offer(new NodeDistance<>(neighbor, newDistance));
                    }
                }
            }

        }

        // Afficher les chemins les plus courts
        List<T> shortestPath = chemins.get(destination);
        System.out.println("Chemin le plus court entre " + source + " et " + destination + ": " + shortestPath);
        System.out.println("Distance totale : " + distances.get(destination));
    }

    private static class NodeDistance<T> {
        private final T node;
        private final int distance;

        public NodeDistance(T node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public T getNode() {
            return node;
        }

        public int getDistance() {
            return distance;
        }
    }
}




