public class Warrior extends Classes {
    public Warrior(String name) {
        super("Guerreiro", 150, 20, 15, 10);
    }

    public void useSkill() {
        System.out.println(name + " usa Corte Poderoso!");
    }
}
