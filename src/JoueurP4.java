public class JoueurP4 {

    private String pseudo;
    private String key_skins;

    public JoueurP4(String pseudo){
        this.pseudo = pseudo;
        this.key_skins = "";    
    }

    public JoueurP4(String pseudo, String key_skins){
        this.pseudo = pseudo;
        this.key_skins = key_skins;    
    }

    public String getPseudo(){return this.pseudo;}

    public String getSkins(){return this.key_skins;}
    
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
