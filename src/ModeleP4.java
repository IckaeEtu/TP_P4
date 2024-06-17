import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Collections;

public class ModeleP4 {
  private List<List<Integer>> plateau;

  private int hauteur = 6;
  private int largeur = 7;
  private Boolean etatPartie = null;

  private String joueurActuel = "J1";

  /**
   * Initialise le plateau
   */
  public ModeleP4() {
    plateau = new ArrayList<>();
    for (int i = 0; i < largeur; i++) {
      plateau.add(new ArrayList<>());
      for (int j = 0; j < hauteur; j++) {
        plateau.get(i).add(0);
      }
    }
  }

  // **Permet de poser un jeton dans la colonne donné en paramètre */
  public void jouer(int colonne) {
    if (!(colPleinne(colonne))) {
      int ligne = ligneVide(colonne);
      if (joueurActuel.equals("J1")) {
        plateau.get(colonne).set(ligne, 1);
      } else {
        plateau.get(colonne).set(ligne, 2);
      }
      //victoire(ligne, colonne);
      changerJoueur();
    }
  }
  /**Renvoie si la collone est pleine 
   * @param colonne l'indice de la colonne 
   * @return true ou false
   * */
  public boolean colPleinne(int colonne) {
    return plateau.get(colonne).size() < hauteur;
  }
  /**
   * renvoi le jeton a l'emplacement ligne,colonne
   * @param ligne le numéros de la ligne
   * @param colonne le numéros de la colonne
   * @return  la valeur du jeton 0,1 joueur 1,2 joueur 2
   */
  public int getJeton(int ligne, int colonne) {
    return plateau.get(colonne).get(ligne);
  }

  /**
   * convertis la valeur d'un jeton en un joueur
   * @param num 0,1,2 un jeton
   * @return J1 pour 1 et J2 pour 2 sinon NON
   */
  public String convert(int num) {
    if (num == 1) {
      return "J1";
    } else if (num == 2) {
      return "J2";
    }
    return "Non";
  }
  
  /**
   * permet de vérifier que le jeton est la valeur voulus, c-à-d 1 si J1 vient jouer 2 sinon
   * @param joueur J1 ou J2
   * @return true ou false si c'est la valeur voulut
   */
  public boolean lautreJoueur(String joueur) {
    if (joueur.equals("J2") && joueurActuel.equals("J1")) {
      return true;
    }
    if (joueur.equals("J1") && joueurActuel.equals("J2")) {
      return true;
    }
    return false;
  }

  /**
   * échange la valeur de joueur actuel entre J1 et J2
   */
  public void changerJoueur() {
    if (joueurActuel.equals("J1")) {
      joueurActuel = "J2";
    } else {
      joueurActuel = "J1";
    }
  }
  /**
   * permet de savoir le joueur actuel, a qui c'est le tour
   * @return le joueur actuel
   */
  public String getJoueurActuel() {
    return this.joueurActuel;
  }
  /**
   * Renvoie le première indice de dans la colonne qui est vide
   * @param colonne indice d'une colonne du plateau
   * @return l'indice de la première ligne vide
   */
  public int ligneVide(int colonne) {
    for (int i = 0; i < hauteur; i++) {
      if (plateau.get(colonne).get(i) == 0) {
        return i;
      }
    }
    return 42;
  }
  /**
   * test toutes les conditions de victoire
   * @param ligne coordonée ligne
   * @param colonne coordonée colonne
   * @return true ou fales si une condition est validée
   */
  public boolean victoire(int ligne, int colonne) {
    return victoireDiag1(ligne, colonne) || victoireDiag2(ligne, colonne) || victoireColonne()
        || victoireLigne(ligne, colonne);
  }
  /**
   * test la victoire sur une des diagonales
   * @param ligne coordonée ligne
   * @param colonne coordonée colonne
   * @return true ou false
   */
  public boolean victoireDiag1(int ligne, int colonne) {
    int parcours_lig = ligne;
    int parcours_col = colonne;
    int cpt = 1;
    while (parcours_lig < hauteur && parcours_col < largeur
        && (!(convert(getJeton(parcours_lig, parcours_col)).equals(joueurActuel)))) {
      parcours_lig++;
      parcours_col++;
      cpt++;
      if (cpt == 4) {
        return true;
      }
    }
    parcours_lig = ligne;
    parcours_col = colonne;
    while (parcours_lig > 0 && parcours_lig < hauteur && parcours_col > 0 && parcours_col < largeur
        && (!(convert(getJeton(parcours_lig, parcours_col)).equals(joueurActuel)))) {
      parcours_lig--;
      parcours_col--;
      cpt++;
      if (cpt == 4) {
        return true;
      }
    }
    return false;
  }
  /**
   * test la victoire sur l'autre diagonale
   * @param ligne coordonée ligne
   * @param colonne coordonée colonne
   * @return true ou false
   */
  public boolean victoireDiag2(int ligne, int colonne) {
    int parcours_lig = ligne;
    int parcours_col = colonne;
    int cpt = 0;
    while (parcours_lig >= 0 && parcours_lig < hauteur && parcours_col < largeur && parcours_col > 0
        && lautreJoueur(convert(getJeton(ligne, colonne)))) {
      parcours_lig++;
      parcours_col--;
      cpt++;
      if (cpt == 4) {
        return true;
      }
    }
    parcours_lig = ligne;
    parcours_col = colonne;
    while (parcours_lig > 0 && parcours_lig < hauteur && parcours_col >= 0 && parcours_col < largeur
        && lautreJoueur(convert(getJeton(ligne, colonne)))) {
      parcours_lig--;
      parcours_col++;
      cpt++;
      if (cpt == 4) {
        return true;
      }
    }
    return false;
  }
  /**
   * test la victoire sur la colonne
  * @return true si il y a 4 pion aligné dans la colonne, false sinon
   */
  public boolean victoireColonne() {
    int condi=0;
    for (List<Integer> col:plateau){
      for (Integer val:col){
        if (lautreJoueur(convert(val))){
          condi++;
        }
        else{
          condi=0;
        }
        if (condi==4){return true;}
      }
      condi=0;
    }
    return false;
  }
  /**
   * test la victoire sur la ligne
   * @param ligne indice de ligne
   * @param colonne indice de colonne
   * @return true si il y a 4 pion aligné dans la ligne, false sinon
   */
  public boolean victoireLigne(int ligne, int colonne) {
    int parcours_lig = ligne;
    int parcours_col = colonne;
    int cpt = 0;

    while (parcours_lig >= 0 && parcours_lig < hauteur && parcours_col < largeur && parcours_col > 0
        && lautreJoueur(convert(getJeton(ligne, colonne)))) {
      parcours_col--;
      cpt++;
      System.out.println(cpt);
      if (cpt == 4) {
        return true;
      }
    }
    parcours_lig = ligne;
    parcours_col = colonne;
    while (parcours_lig >= 0 && parcours_lig < hauteur && parcours_col >= 0 && parcours_col < largeur
        && lautreJoueur(convert(getJeton(ligne, colonne)))) {
      parcours_col++;
      cpt++;
      System.out.println(cpt);
      if (cpt == 4) {
        return true;
      }
    }
    return false;
  }
  /**
   * permet de vérfier si la grille est pleine
   * @return true si la grille est remplie, false sinon
   */
  public boolean grillePleine(){
    for (List<Integer> col:plateau){
      for (Integer val:col){
        if (val==0){return false;}
      }
    }
    return true;
  }

  /**
   * remet tout à l'état de base
   */
  public void reset(){
    plateau = new ArrayList<>();
    for (int i = 0; i < largeur; i++) {
      plateau.add(new ArrayList<>());
      for (int j = 0; j < hauteur; j++) {
        plateau.get(i).add(0);
      }
    }
  }

  /**
   * permet d'afficher la grille pour les test, la grille doit être tourné de 90°
   * dans le sens inverses des aiguilles d'une montre
   */
  @Override
  public String toString() {
    String res = "Plateau P4 \n";
    for (List<Integer> col : plateau) {
      res += col + "\n";
    }
    return res;
  }

}
