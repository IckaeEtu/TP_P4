public class Exe {
    public static void main(String[] args) {
        ModeleP4 p = new ModeleP4();
        p.jouer(6);
        p.jouer(5);
        p.jouer(5);
        p.jouer(4);
        p.jouer(4); 
        p.jouer(3);
        p.jouer(4);
        p.jouer(3);
        p.jouer(3);
    

        System.out.println(p.victoireDiag2(0,6));
        System.out.println(p.victoire(2,4));
        System.out.println(p.convert(p.getJeton(5, 6)));
        System.out.println(p.getJoueurActuel());
        System.out.println(p.victoire(4,5));
        System.out.println(p.toString());
    }
}
