import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Collections;

public class ModeleP4 {
  private List<List<Integer>> plateau;

  private int hauteur = 6;
  private int largeur = 7;
  private Boolean etatPartie = null;

  private String JoueurActuel = "J1";

  /**
   * Initialise le plateau 
   */
  public ModeleP4(){
    plateau = new ArrayList<>();
    for (int i=0;i<largeur;i++){
      plateau.add(new ArrayList<>());
      for (int j=0;j<hauteur;j++){
        plateau.get(i).add(0);
      }
    }
  }

  //**Permet de poser un jeton dans la colonne donné en paramètre */
  public void jouer(int colonne){
    if (!(colPleinne(colonne))){
      int ligne = ligneVide(colonne);
      if (JoueurActuel.equals("J1")){
        plateau.get(colonne).set(ligne,1);
      }
      else {
        plateau.get(colonne).set(ligne,2);
      }
      victoire(ligne,colonne);
      changerJoueur();
    }
  }


  public boolean colPleinne(int colonne){
    return plateau.get(colonne).size() < hauteur;
  }
  
  public int getJeton(int ligne, int colonne){
    return plateau.get(ligne).get(colonne);
  }

  public String convert(int num){
    if(num == 1){
      return "J1";
    } else {return "J2";}
  }

  public void changerJoueur(){
    if (JoueurActuel.equals("J1")){JoueurActuel = "J2";}
    else {JoueurActuel = "J1";}
  }


  public int ligneVide(int colonne){
    for (int i=0;i<hauteur;i++){
      if (plateau.get(colonne).get(i)==0){
        return i;
      }
    }
    return 42;
  }

  public boolean victoire(int ligne, int colonne){
    return true;
  }

  public boolean victoireDiag(int ligne, int colonne){
    int parcours_lig = ligne;
    int parcours_col = colonne;
    int cpt = 1;
    while (parcours_lig < hauteur && parcours_col < largeur && convert(getJeton(ligne+1, colonne+1)).equals(JoueurActuel)){
      parcours_lig++;
      parcours_col++;
      cpt++;
      System.out.println(getJeton(ligne, colonne));
      if (cpt == 4) {return true;}
      }
    parcours_lig = ligne;
    parcours_col = colonne;
    while (parcours_lig > 0 && parcours_lig < hauteur && parcours_col > 0 && parcours_col < largeur && convert(getJeton(ligne-1, colonne-1)).equals(JoueurActuel)){
        parcours_lig--;
        parcours_col--;
        cpt++;
        System.out.println(getJeton(ligne, colonne));
        if (cpt == 4) {return true;}
      }
    return false;                                                                 
  }






  @Override
  public String toString(){
    String res = "Plateau P4 \n";
    for (List<Integer> col : plateau){
      res += col + "\n";
    }
    return res;
  }




}
