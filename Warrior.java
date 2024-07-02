public class Warrior extends Classes {
    public Warrior(String name) {
        super("Guerreiro", 120, 20, 15, 10, 5);
    }

    public void useSkill() {
        System.out.println(name + " usa Corte Poderoso!");
    }
}
