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
        p.victoireDiag(1,1);
        System.out.println(p.victoireDiag(1,1));
        System.out.println(p.toString());
    }
}
