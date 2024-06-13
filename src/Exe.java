public class Exe {
    public static void main(String[] args) {
        ModeleP4 p = new ModeleP4();
        p.jouer(0);
        p.jouer(0);
        p.jouer(1);
        p.jouer(0);
        p.jouer(1); 
        p.jouer(0);
        p.jouer(2);
        p.jouer(3);
        p.jouer(2);
        p.jouer(0);
    
        System.out.println(p.convert(p.getJeton(5, 6)));
        System.out.println(p.getJoueurActuel());
        p.jouer(2);
        p.jouer(4);
        System.out.println(p.victoireColonne() );
        System.out.println(p.toString());

    }
}
