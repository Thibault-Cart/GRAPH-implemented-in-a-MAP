<h1>GrapheMap - Implémentation d'un Graphe de Type Abstrait (T) avec une Structure de Map</h1><p>Cette bibliothèque Java propose une implémentation d'un graphe de type abstrait où les relations entre les nœuds sont stockées dans une structure de Map.t.</p><h2>Fonctionnalités</h2><h3>1. Constructeur</h3><ul><li><code>public GrapheMap()</code>: Initialise le graphe avec une structure de Map pour stocker les relations.</li></ul><h3>2. Ajout de Relation</h3><ul><li><code>public void addRelation(T source, T destination)</code>: Ajoute une relation entre deux nœuds dans le graphe. Si les nœuds ne sont pas déjà présents, ils sont ajoutés à la structure de la Map.</li></ul><h3>3. Suppression de Relation</h3><ul><li><code>public void deleteRelation(T source, T destination)</code>: Supprime une relation entre deux nœuds dans le graphe.</li></ul><h3>4. Vérification de l'Existence d'une Relation</h3><ul><li><code>public boolean existeRelation(T source, T destination)</code>: Vérifie si une relation existe entre deux nœuds.</li></ul><h3>5. Parcours en Profondeur</h3><ul><li><code>public void parcoursProfondeur(T source)</code>: Réalise un parcours en profondeur du graphe à partir d'un nœud source.</li></ul><h3>6. Vérification de l'Existence d'un Chemin</h3><ul><li><code>public boolean existeChemin(T source, T destination)</code>: Vérifie si un chemin existe entre deux nœuds dans le graphe.</li></ul><h3>7. Détection de Cycle</h3><ul><li><code>public boolean existeCycle()</code>: Vérifie s'il existe un cycle dans le graphe.</li></ul>

![Diagramme sans nom drawio](https://github.com/Thibault-Cart/GRAPH-implemented-in-a-MAP/assets/49438882/0e1a533c-68cd-4dea-bd46-e1657e3cbdd1)

<h2>Utilisation</h2><pre><div class="bg-black rounded-md"><div class="flex items-center relative text-gray-200 bg-gray-800 dark:bg-token-surface-primary px-4 py-2 text-xs font-sans justify-between rounded-t-md"><span>java</span><span class="" data-state="closed"><button class="flex gap-1 items-center"><svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" class="icon-sm"><path fill-rule="evenodd" clip-rule="evenodd" d="M12 4C10.8954 4 10 4.89543 10 6H14C14 4.89543 13.1046 4 12 4ZM8.53513 4C9.22675 2.8044 10.5194 2 12 2C13.4806 2 14.7733 2.8044 15.4649 4H17C18.6569 4 20 5.34315 20 7V19C20 20.6569 18.6569 22 17 22H7C5.34315 22 4 20.6569 4 19V7C4 5.34315 5.34315 4 7 4H8.53513ZM8 6H7C6.44772 6 6 6.44772 6 7V19C6 19.5523 6.44772 20 7 20H17C17.5523 20 18 19.5523 18 19V7C18 6.44772 17.5523 6 17 6H16C16 7.10457 15.1046 8 14 8H10C8.89543 8 8 7.10457 8 6Z" fill="currentColor"></path></svg>Copy code</button></span></div><div class="p-4 overflow-y-auto"><code class="!whitespace-pre hljs language-java"><span class="hljs-comment">// Exemple d'utilisation du GrapheMap</span>

graphe.addRelation(<span class="hljs-number">1</span>, <span class="hljs-number">2</span>);
graphe.addRelation(<span class="hljs-number">2</span>, <span class="hljs-number">3</span>);
graphe.addRelation(<span class="hljs-number">3</span>, <span class="hljs-number">1</span>);

graphe.parcoursProfondeur(<span class="hljs-number">1</span>);
<span class="hljs-type">boolean</span> <span class="hljs-variable">existeChemin</span> <span class="hljs-operator">=</span> graphe.existeChemin(<span class="hljs-number">1</span>, <span class="hljs-number">3</span>);
<span class="hljs-type">boolean</span> <span class="hljs-variable">existeCycle</span> <span class="hljs-operator">=</span> graphe.existeCycle();
</code></div></div></pre><p>Ce code permet de créer un graphe, d'ajouter des relations, de réaliser un parcours en profondeur, de vérifier l'existence d'un chemin entre deux nœuds, et de détecter la présence d'un cycle dans le graphe.</p></div></div></div><div class="mt-1 flex justify-start gap-3 empty:hidden"><div class="text-gray-400 flex self-end lg:self-center justify-center lg:justify-start mt-0 -ml-1 visible"><span class="" data-state="closed"><button class="flex items-center gap-1.5 rounded-md p-1 text-xs hover:text-gray-950 dark:text-gray-400 dark:hover:text-gray-200 disabled:dark:hover:text-gray-400 md:invisible md:group-hover:visible md:group-[.final-completion]:visible"><svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" class="icon-md"><path fill-rule="evenodd" clip-rule="evenodd" d="M12 4C10.8954 4 10 4.89543 10 6H14C14 4.89543 13.1046 4 12 4ZM8.53513 4C9.22675 2.8044 10.5194 2 12 2C13.4806 2 14.7733 2.8044 15.4649 4H17C18.6569 4 20 5.34315 20 7V19C20 20.6569 18.6569 22 17 22H7C5.34315 22 4 20.6569 4 19V7C4 5.34315 5.34315 4 7 4H8.53513ZM8 6H7C6.44772 6 6 6.44772 6 7V19C6 19.5523 6.44772 20 7 20H17C17.5523 20 18 19.5523 18 19V7C18 6.44772 17.5523 6 17 6H16C16 7.10457 15.1046 8 14 8H10C8.89543 8 8 7.10457 8 6Z" fill="currentColor"></path></svg></button></span><div class="flex"><span class="" data-state="closed"><button class="p-1 rounded-md disabled:dark:hover:text-gray-400 dark:hover:text-gray-200 dark:text-gray-400 text-gray-400 hover:text-gray-950 md:invisible md:group-hover:visible md:group-[.final-completion]:visible"><svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" class="icon-md"><path fill-rule="evenodd" clip-rule="evenodd" d="M12.1318 2.50389C12.3321 2.15338 12.7235 1.95768 13.124 2.00775L13.5778 2.06447C16.0449 2.37286 17.636 4.83353 16.9048 7.20993L16.354 8.99999H17.0722C19.7097 8.99999 21.6253 11.5079 20.9313 14.0525L19.5677 19.0525C19.0931 20.7927 17.5124 22 15.7086 22H6C4.34315 22 3 20.6568 3 19V12C3 10.3431 4.34315 8.99999 6 8.99999H8C8.25952 8.99999 8.49914 8.86094 8.6279 8.63561L12.1318 2.50389ZM10 20H15.7086C16.6105 20 17.4008 19.3964 17.6381 18.5262L19.0018 13.5262C19.3488 12.2539 18.391 11 17.0722 11H15C14.6827 11 14.3841 10.8494 14.1956 10.5941C14.0071 10.3388 13.9509 10.0092 14.0442 9.70591L14.9932 6.62175C15.3384 5.49984 14.6484 4.34036 13.5319 4.08468L10.3644 9.62789C10.0522 10.1742 9.56691 10.5859 9 10.8098V19C9 19.5523 9.44772 20 10 20ZM7 11V19C7 19.3506 7.06015 19.6872 7.17071 20H6C5.44772 20 5 19.5523 5 19V12C5 11.4477 5.44772 11 6 11H7Z" fill="currentColor"></path></svg></button></span><span class="" data-state="closed"><button class="p-1 rounded-md disabled:dark:hover:text-gray-400 dark:hover:text-gray-200 dark:text-gray-400 text-gray-400 hover:text-gray-950 md:invisible md:group-hover:visible md:group-[.final-completion]:visible"><svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" class="icon-md"><path fill-rule="evenodd" clip-rule="evenodd" d="M11.8727 21.4961C11.6725 21.8466 11.2811 22.0423 10.8805 21.9922L10.4267 21.9355C7.95958 21.6271 6.36855 19.1665 7.09975 16.7901L7.65054 15H6.93226C4.29476 15 2.37923 12.4921 3.0732 9.94753L4.43684 4.94753C4.91145 3.20728 6.49209 2 8.29589 2H18.0045C19.6614 2 21.0045 3.34315 21.0045 5V12C21.0045 13.6569 19.6614 15 18.0045 15H16.0045C15.745 15 15.5054 15.1391 15.3766 15.3644L11.8727 21.4961ZM14.0045 4H8.29589C7.39399 4 6.60367 4.60364 6.36637 5.47376L5.00273 10.4738C4.65574 11.746 5.61351 13 6.93226 13H9.00451C9.32185 13 9.62036 13.1506 9.8089 13.4059C9.99743 13.6612 10.0536 13.9908 9.96028 14.2941L9.01131 17.3782C8.6661 18.5002 9.35608 19.6596 10.4726 19.9153L13.6401 14.3721C13.9523 13.8258 14.4376 13.4141 15.0045 13.1902V5C15.0045 4.44772 14.5568 4 14.0045 4ZM17.0045 13V5C17.0045 4.64937 16.9444 4.31278 16.8338 4H18.0045C18.5568 4 19.0045 4.44772 19.0045 5V12C19.0045 12.5523 18.5568 13 18.0045 13H17.0045Z" fill="currentColor"></path></svg></button></span></div></div></div></div></div></div>
