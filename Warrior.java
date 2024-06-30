public class Warrior extends Classes {
    public Warrior(String name) {
        super("Guerreiro", 150, 20, 15, 10); // Atributos específicos de Guerreiro
    }

    public void useSkill() {
        System.out.println(name + " usa Corte Poderoso!");
        // Implementar lógica para "Corte Poderoso"
    }
}
