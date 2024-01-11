/**
 * Graphe de type abstrait T mis dans une Map
 *
 * @author Ch. Stettler - HEG-Genève puis modifier par Thibault Cart
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class GrapheMap<T> implements Graphe<T> {
    private Map<T, Set<T>> lstRelations;

    private Set<T> dejaVisites;


    /**
     * Constructeur
     */
    public GrapheMap() {
        lstRelations = new HashMap<>();
    }


    /**
     * Ajoute une relation entre deux noeuds
     *
     * @param source      le noeud source
     * @param destination le noeud destination
     */
    @Override
    public void addRelation(T source, T destination) {

        //verifie si la source et la destination sont deja dans la liste
        if (!lstRelations.keySet().contains(source)) {
            lstRelations.put(source, null);
        }
        if (!lstRelations.keySet().contains(destination)) {
            lstRelations.put(destination, null);
        }
        // recupere la liste des relations de la source
        Set<T> relations = lstRelations.get(source);
        // si la liste est null, on la cree
        if (relations == null) {
            relations = new HashSet<>();
            // on ajoute la destination a la liste
            relations.add(destination);
            // on ajoute la liste a la source
            lstRelations.put(source, relations);
        } else {
            // sinon on ajoute la destination a la liste
            relations.add(destination);
        }
        System.out.println("Relation ajoutée : " + source + " -> " + destination);
    }


    /**
     * Supprime une relation entre deux noeuds
     *
     * @param source      le noeud source
     * @param destination le noeud destination
     */
    @Override
    public void deleteRelation(T source, T destination) {
        //si la source ou la destination n'existe pas dans la liste, on ne fait rien
        if (!lstRelations.keySet().contains(source) || !lstRelations.keySet().contains(destination)) {
            return;
        }

        // recupere la liste des relations de la source
        Set<T> relations = lstRelations.get(source);
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
    @Override
    public boolean existeRelation(T source, T destination) {
        boolean existe = lstRelations.get(source) != null && lstRelations.get(source).contains(destination);
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
    @Override
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

        Set<T> voisins = lstRelations.get(noeud);
        if (voisins == null) {
            return;
        }
        for (T voisin : voisins) {

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
    @Override
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
        Set<T> allnode = lstRelations.get(source);

        if (source.equals(destination)) {
            return true;
        }
        if (allnode == null) {
            return false;
        } else {

            for (T noeud : allnode) {
                if (noeud.equals(destination)) {
                    return true;
                }

            }
            for (T noeud : allnode) {
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

    @Override
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

        Set<T> voisins = lstRelations.get(noeud);
        if (voisins != null) {
            for (T voisin : voisins) {
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

}


