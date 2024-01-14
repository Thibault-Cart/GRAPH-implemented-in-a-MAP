/**
 * Graphe de type abstrait T mis dans une Map
 *
 * @author Ch. Stettler - HEG-Genève puis modifier par Thibault Cart
 */

public class DemoGraphe {

    public static void main(String[] args) {
        // TEST GRAPH NORMAL
        // creation du graphe
        Graphe gr = new GrapheMap();
        // Ajout relation
        gr.addRelation(0, 1);
        gr.addRelation(0, 3);
        gr.addRelation(1, 2);
        gr.addRelation(1, 4);
        gr.addRelation(3, 1);
        gr.addRelation(3, 4);
        gr.addRelation(3, 6);
        gr.addRelation(6, 5);
        gr.addRelation(7, 6);
        gr.addRelation(5, 3); // !! crée un cycle (une boucle )


        System.out.println(gr.existeRelation(0, 1));
        System.out.println(gr.existeRelation(0, 4));
        System.out.println("TEST CHEMIN EXISTE");
        System.out.println(gr.existeChemin(0, 7));
        System.out.println(gr.existeChemin(6, 4));
        System.out.println(gr.existeChemin(3, 2));
        System.out.println(gr.existeChemin(5, 2));
        System.out.println(gr.existeChemin(6, 2));
        System.out.println(gr.existeChemin(5, 12));
        System.out.println("Parcours en profondeur depuis 0");
        gr.parcoursProfondeur(0);
        System.out.println("\nParcours en profondeur depuis 7");
        gr.parcoursProfondeur(7);

        System.out.println("Verification de cycle");
        gr.existeCycle();

        gr.deleteRelation(5, 3);
        System.out.println("Verification de cycle apres suppression de la relation 5 -> 3");
        gr.existeCycle();

        gr.afficherChemin(0, 6);
        gr.afficherChemin(0, 4);
        gr.afficherChemin(3, 5);

        System.out.println("TEST GRAPH AVEC POIDS");

        // TEST GRAPH AVEC POIDS
        // creation du graphe
        GraphDistance gr2 = new GraphDistance();
        // Ajout relation
        gr2.addRelation(0, 1, 25);
        gr2.addRelation(0, 3, 5);
        gr2.addRelation(1, 2, 12);
        gr2.addRelation(1, 4, 22);
        gr2.addRelation(3, 1, 16);
        gr2.addRelation(3, 4, 2);
        gr2.addRelation(3, 6, 7);
        gr2.addRelation(6, 5, 15);
        gr2.addRelation(7, 6, 22);
        gr2.addRelation(5, 3, 6); // !! crée un cycle (une boucle )


        System.out.println(gr2.existeRelation(0, 1));
        System.out.println(gr2.existeRelation(0, 4));
        System.out.println("TEST CHEMIN EXISTE");
        System.out.println(gr2.existeChemin(0, 7));
        System.out.println(gr2.existeChemin(6, 4));
        System.out.println(gr2.existeChemin(3, 2));
        System.out.println(gr2.existeChemin(5, 2));
        System.out.println(gr2.existeChemin(6, 2));
        System.out.println(gr2.existeChemin(5, 12));
        System.out.println("Parcours en profondeur depuis 0");
        gr2.parcoursProfondeur(0);
        System.out.println("\nParcours en profondeur depuis 7");
        gr2.parcoursProfondeur(7);

        gr2.afficherChemin(0, 2);
        gr2.afficherCheminsPlusCourts(0, 2);

    }


}
