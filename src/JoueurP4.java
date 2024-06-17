public class JoueurP4 {
    /*
     * Le nom du joueur
     */
    private String pseudo;
    /*
     * une liste de 0 et de 1 qui définissent si un joueur à des skins ou non
     */
    private String key_skins;

    /*
     * Constructeur qui crée un nouveau joueur sans skins
     * @param le nom du joueur
     */
    public JoueurP4(String pseudo){
        this.pseudo = pseudo;
        this.key_skins = "";    
    }

    /*
     * Un constructeur qui crée un nouveau joueur qui a déjà des skins
     * @param le nom du joueur
     * @param la clé permettant de savoir quels skins l'on possède
     */
    public JoueurP4(String pseudo, String key_skins){
        this.pseudo = pseudo;
        this.key_skins = key_skins;    
    }

    /*Les getters */
    public String getPseudo(){return this.pseudo;}

    public String getSkins(){return this.key_skins;}

    /*
     * Vérifie si un joueur possède un certain skin à un certain indice, en vérifiant qu'il y a un 1 à l'indice donné
     * @param l'indice du skin demandé
     * @return true si le skins est possèdé et false sinon
     */
    public boolean aSkin(int ind){
        int cpt = 0;
        for(char c: getSkins().toCharArray()){
            if(cpt==ind){
                if(c=='1'){return true;}
                else{return false;}
            }
            else{cpt+=1;}
        }
        return false;
    }

}
