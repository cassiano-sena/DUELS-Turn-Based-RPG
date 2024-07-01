public class Mage extends Classes {
    public Mage(String name) {
        super("Mago", 100, 5, 20, 10);
    }
    public void useSkill() {
        System.out.println(name + " lança Bola de Fogo!");
    }
}
