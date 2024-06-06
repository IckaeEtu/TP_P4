public class Exe {
    public static void main(String[] args) {
        ModeleP4 p = new ModeleP4();
        p.jouer(0);
        p.jouer(0);
        p.jouer(0);
        p.jouer(1);
        p.jouer(5);
        p.jouer(0);
        p.jouer(0);
        p.jouer(0);
        p.jouer(1);
        p.jouer(2);
        p.jouer(2);
        p.jouer(3);
        p.jouer(3);
        p.jouer(3);
        p.jouer(2);
        p.jouer(4);
        p.jouer(3);
        System.out.println(p.victoireDiag1(0,0));
        System.out.println(p.victoire(0,0));
        System.out.println(p.convert(p.getJeton(0, 0)));
        System.out.println(p.getJoueurActuel());
        System.out.println(p.victoire(1,1));
        System.out.println(p.toString());
    }
}
