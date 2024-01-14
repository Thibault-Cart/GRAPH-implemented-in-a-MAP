/**
 * Graphe de type abstrait T mis dans une Map
 *
 * @author Ch. Stettler - HEG-Genève puis modifier par Thibault Cart
 */



interface Graphe<T> {
    void addRelation(T source, T destination);
    void deleteRelation(T source, T destination);

    boolean existeRelation(T source, T destination);

    void parcoursProfondeur(T source);

    boolean existeChemin(T source, T destination);

    boolean existeCycle();

    void afficherChemin(T source, T destination);

}


