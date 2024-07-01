public class Ranger extends Classes {
    public Ranger(String name) {
        super("Patrulheiro", 120, 10, 10, 20);
    }
    public void useSkill() {
        System.out.println(name + " dispara Flecha Veloz!");
    }
}
