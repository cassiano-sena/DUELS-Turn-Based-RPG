public class Mage extends Classes {
    public Mage(String name) {
        super("Mago", 100, 5, 20, 10); // Atributos específicos de Mago
    }

    public void useSkill() {
        System.out.println(name + " lança Bola de Fogo!");
        // Implementar lógica para "Bola de Fogo"
    }
}
