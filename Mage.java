public class Mage extends Classes {
    public Mage(String name) {
        super("Mago", 110, 5, 5, 5,20);
    }
    public void useSkill() {
        System.out.println(name + " lança Bola de Fogo!");
    }
}
