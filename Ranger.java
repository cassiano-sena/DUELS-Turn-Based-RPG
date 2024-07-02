public class Ranger extends Classes {
    public Ranger(String name) {
        super("Patrulheiro", 110, 5, 5, 20, 10);
    }
    public void useSkill() {
        System.out.println(name + " dispara Flecha Veloz!");
    }
}
