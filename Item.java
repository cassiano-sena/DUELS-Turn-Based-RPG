import java.util.*;

public class Item {
    private int id;
    private String name;
    private String description = "";
    protected List<Attack> itemActions;
//    private final Map<Integer, Class<? extends Item>> itemClassMap = new HashMap<>();
//
//    {
//        itemClassMap.put(1, Sword.class);
//        itemClassMap.put(2, Axe.class);
//        itemClassMap.put(3, Hammer.class);
//        itemClassMap.put(4, ShortBow.class);
//        itemClassMap.put(5, HandCrossbow.class);
//        itemClassMap.put(6, LongBow.class);
//        itemClassMap.put(7, MagicStaff.class);
//        itemClassMap.put(8, ElectricStaff.class);
//        itemClassMap.put(9, FireStaff.class);
//        itemClassMap.put(10, Dagger.class);
//        itemClassMap.put(11, DualKnives.class);
//        itemClassMap.put(12, Rapier.class);
//    }

//    public Item getItem(int itemId) {
//        Class<? extends Item> itemClass = itemClassMap.get(itemId);
//        if (itemClass != null) {
//            try {
//                return itemClass.getDeclaredConstructor().newInstance();
//            } catch (Exception e) {
//                e.printStackTrace(); // Trate adequadamente a exceção, se necessário
//            }
//        }
//        return null; // Retorna null se o ID de item não estiver mapeado para nenhuma classe
//    }

    public Item(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.itemActions = new ArrayList<>();
    }

    public void displayInfo() {
        System.out.println("Item ID: " + id);
        System.out.println("Nome: " + name);
        System.out.println("Descrição: " + description);
        System.out.println("Ações:");
        for (Attack action : itemActions) {
            System.out.println(action.getDescription() + "\n");
            System.out.println(action.getDamageFormula() + "\n");
            System.out.println(action.getHitChance() + "\n");
            System.out.println(action.getEffect() + "\n\n");
        }
        System.out.println();
    }

    public List<Attack> getItemActions() {
        return itemActions;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }

    public Item getRandomItem() {
        Random random = new Random();
        int itemId = random.nextInt(12) + 1; // Gera um número aleatório de 1 a 12 (número máximo de tipos de armas)

        switch (itemId) {
            case 1:
                return new Sword();
            case 2:
                return new Axe();
            case 3:
                return new Hammer();
            case 4:
                return new ShortBow();
            case 5:
                return new HandCrossbow();
            case 6:
                return new LongBow();
            case 7:
                return new MagicStaff();
            case 8:
                return new ElectricStaff();
            case 9:
                return new FireStaff();
            case 10:
                return new Dagger();
            case 11:
                return new DualKnives();
            case 12:
                return new Rapier();
            default:
                throw new IllegalArgumentException("Item ID inválido: " + itemId);
        }
    }

    public static class Sword extends Item {
        public Sword() {
            super(1, "Espada", "Arma");
            this.itemActions = Arrays.asList(
                    new Attack(1, "Contra-ataque", "Sacrifica o turno para bloquear o próximo ataque e contra-atacar", "10 + FOR", 10, 100, "", 100, false, false),
                    new Attack(2, "Corte", "Corta em sua frente com uma força considerável", "10 + FOR", 10, 100,"25% de chance de sangramento", 10,false,false),
                    new Attack(3, "Finta", "Finge um ataque e surpreende atacando de outra forma", "10 + FOR", 10, 50,"50% de chance de atordoamento",10,false,false)
            );
        }

        public void counterAttack(Character attacker, Character target) {
            System.out.println("Realizando Contra-ataque!");
            target.calculateDamage(attacker, target);
        }

        public void slash(Character attacker, Character target) {
            System.out.println("Realizando Corte!");
            target.calculateDamage(attacker, target);
        }

        public void feint(Character attacker, Character target) {
            System.out.println("Realizando Finta!");
            target.calculateDamage(attacker, target);
        }
    }


    public static class Axe extends Item {
        public Axe() {
            super(2, "Machado", "Arma");
            this.itemActions = Arrays.asList(
                    new Attack(1, "Ataque Selvagem", "Ataca ferozmente sem nenhum cuidado", "20 + FOR", 20,50, "50% de chance de receber 20 de dano", 10,false, false),
                    new Attack(2, "Machadada Forte", "Utiliza toda a inércia possível para causar dano", "10 + FOR", 10, 100, "25% de chance de atordoamento", 10,false, false),
                    new Attack(3, "Mutilar", "Mutila o inimigo de forma sádica", "10 + FOR", 10, 50, "25% de chance de sangramento", 10,false, false)
            );
        }

        public void wildAttack(Character attacker, Character target) {
            System.out.println("Realizando Ataque Selvagem!");
            target.calculateDamage(attacker, target);
        }

        public void strongAxe(Character attacker, Character target) {
            System.out.println("Realizando Machadada Forte!");
            target.calculateDamage(attacker, target);
        }

        public void maim(Character attacker, Character target) {
            System.out.println("Realizando Mutilar!");
            target.calculateDamage(attacker, target);
        }
    }

    public static class Hammer extends Item {
        public Hammer() {
            super(3, "Martelo", "Arma");
            this.itemActions = Arrays.asList(
                    new Attack(1, "Salto Atordoante", "Salta em direção ao oponente com seu martelo", "10 + FOR", 10, 50, "50% de chance de atordoamento", 10,false, false),
                    new Attack(2, "Martelo Pesado", "Balança o pesado martelo", "10 + FOR", 10,50, "50% de chance de acerto crítico", 10,false, false),
                    new Attack(3, "Carregar", "Sacrifica o turno carregando para um poderoso ataque", "30 + FOR", 10, 100, "crítico", 10,false, false)
            );
        }

        public void stunningLeap(Character attacker, Character target) {
            System.out.println("Realizando Salto Atordoante!");
            target.calculateDamage(attacker, target);
        }

        public void heavyHammer(Character attacker, Character target) {
            System.out.println("Realizando Martelo Pesado!");
            target.calculateDamage(attacker, target);
        }

        public void charge(Character attacker, Character target) {
            System.out.println("Realizando Carregar!");
            target.calculateDamage(attacker, target);
        }
    }

    public static class ShortBow extends Item {
        public ShortBow() {
            super(4, "Arco Curto", "Arma");
            this.itemActions = Arrays.asList(
                    new Attack(1, "Saraivada de Flechas", "Rapidamente direciona cinco flechas rápidas em direção ao inimigo", "(10 por flecha) + DES", 10, 33, "33% de chance de acerto para cada", 10,false, false),
                    new Attack(2, "Flecha Rápida", "Arremessa uma flecha rápida", "10 + DES", 10, 100, "100% de chance de acerto", 10,false, false),
                    new Attack(3, "Flecha Sonífera", "Arremessa uma flecha sonífera", "10 + DES", 10, 100, "20% de chance de adormecer", 10,false, false)
            );
        }

        public void volleyOfArrows(Character attacker, Character target) {
            System.out.println("Realizando Saraivada de Flechas!");
            target.calculateDamage(attacker, target);
        }

        public void fastArrow(Character attacker, Character target) {
            System.out.println("Realizando Flecha Rápida!");
            target.calculateDamage(attacker, target);
        }

        public void poisonArrow(Character attacker, Character target) {
            System.out.println("Realizando Flecha Envenenada!\n");
            System.out.println("10 de dano + destreza, 20% de chance de envenenar o inimigo.");
            target.calculateDamage(attacker, target);
        }

        public void keepDistance(Character attacker, Character target) {
            System.out.println("Realizando Manter Distância!\n");
            System.out.println("Ganha distância contra ataques corpo-a-corpo, se o inimigo não usa uma arma a distância, 75% de chance de desviar do ataque.");
            target.calculateDamage(attacker, target);
        }
    }

    public static class HandCrossbow extends Item {
        public HandCrossbow() {
            super(5, "Besta de Mão", "Arma");
            this.itemActions = Arrays.asList(
                    new Attack(1, "Flecha Precisa", "Dispara com precisão uma flecha em direção ao inimigo", "10 + DES", 10, 100, "50% de crítico", 10,false, false),
                    new Attack(2, "Flecha Envenenada", "Arremessa uma flecha envenenada", "10 + DES", 10, 100, "25% de chance de envenenamento", 10,false, false),
                    new Attack(3, "Flecha Pesada", "Arremessa uma flecha pesada em direção ao inimigo", "10 + DES", 10, 100, "20% de chance de atordoar", 10,false, false)
            );
        }

        public void preciseShot(Character attacker, Character target) {
            System.out.println("Realizando Flecha Precisa!\n");
            System.out.println("Uma flechada precisa que causa 10 de dano + destreza com 50% de chance de crítico.");
            target.calculateDamage(attacker, target);
        }

        public void poisonArrow(Character attacker, Character target) {
            System.out.println("Realizando Flecha Envenenada!\n");
            System.out.println("10 de dano + destreza, 25% de chance de envenenar o inimigo.");
            target.calculateDamage(attacker, target);
        }

        public void heavyArrow(Character attacker, Character target) {
            System.out.println("Realizando Flecha Pesada!\n");
            System.out.println("Uma flechada pesada que causa 10 de dano + destreza com 20% de chance de atordoar.");
            target.calculateDamage(attacker, target);
        }

        public void keepDistance(Character attacker, Character target) {
            System.out.println("Realizando Manter Distância!\n");
            System.out.println("Ganha distância contra ataques corpo-a-corpo, se o inimigo não usa uma arma a distância, 75% de chance de desviar do ataque.");
            target.calculateDamage(attacker, target);
        }
    }

    public static class LongBow extends Item {
        public LongBow() {
            super(6, "Arco Longo", "Arma");
            this.itemActions = Arrays.asList(
                    new Attack(1, "Flechada Forte", "Dispara com força uma flecha em direção ao inimigo", "20 + DES", 10, 100, "100% de chance de acerto", 10,false, false),
                    new Attack(2, "Flecha de Fogo", "Arremessa uma flecha de fogo", "10 + DES", 10, 100, "25% de chance de botar fogo", 10,false, false),
                    new Attack(3, "Headshot", "Sacrifica o turno para ter extrema precisão no turno seguinte", "30 + DES", 10, 100, "crítico", 10,false, false)
            );
        }

        public void strongArrow(Character attacker, Character target) {
            System.out.println("Realizando Flechada Forte!\n");
            System.out.println("Uma flechada forte que causa 20 de dano + destreza.");
            target.calculateDamage(attacker, target);
        }

        public void fireArrow(Character attacker, Character target) {
            System.out.println("Realizando Flecha de Fogo!\n");
            System.out.println("10 de dano + destreza, 25% de chance de botar fogo no inimigo.");
            target.calculateDamage(attacker, target);
        }

        public void headshot(Character attacker, Character target) {
            System.out.println("Realizando Headshot!\n");
            System.out.println("Sacrifica o turno, 30 de dano + destreza, crítico.");
            target.calculateDamage(attacker, target);
        }

        public void keepDistance(Character attacker, Character target) {
            System.out.println("Realizando Manter Distância!\n");
            System.out.println("Ganha distância contra ataques corpo-a-corpo, se o inimigo não usa uma arma a distância, 75% de chance de desviar do ataque.");
            target.calculateDamage(attacker, target);
        }
    }
    public static class MagicStaff extends Item {
        public MagicStaff() {
            super(7, "Cajado Mágico", "Arma");
            this.itemActions = Arrays.asList(
                    new Attack(1, "Magia do Sono", "Recita um encantamento adormecente", "", 0, 50, "50% de chance de acerto", 10,false, false),
                    new Attack(2, "Cometa Explosivo", "Arremessa um cometa mágico que pode explodir ao contato", "20 DMG, + 20 se o inimigo estiver dormindo (se estiver dormindo o inimigo acordará)", 10, 100, "100% de chance de acerto", 10,false, false),
                    new Attack(3, "Esfera Arcana", "Conjura uma esfera arcana rápida", "10 DMG, 20% de chance de atordoamento", 10, 100, "100% de chance de acerto", 10,false, false)
            );
        }

        public void sleepSpell(Character attacker, Character target) {
            System.out.println("Realizando Magia do Sono!");
            System.out.println("50% de chance de fazer o inimigo dormir.");
            target.calculateDamage(attacker, target);
        }

        public void explosiveComet(Character attacker, Character target) {
            System.out.println("Realizando Cometa Explosivo!");
            System.out.println("20 de dano, +20 se o inimigo estiver dormindo. Se o inimigo estiver dormindo, ele acordará.");
            target.calculateDamage(attacker, target);
        }

        public void arcaneSphere(Character attacker, Character target) {
            System.out.println("Realizando Esfera Arcana!");
            System.out.println("10 de dano, 20% de chance de atordoamento.");
            target.calculateDamage(attacker, target);
        }
    }

    public static class ElectricStaff extends Item {
        public ElectricStaff() {
            super(8, "Cajado Elétrico", "Arma");
            this.itemActions = Arrays.asList(
                    new Attack(1, "Evocar Raio", "Conjura um raio", "20 DMG",10 ,100, "100% de chance de acerto", 10,false, false),
                    new Attack(2, "Trovão", "Evoca uma tempestade. Durante os próximos 3 turnos possui mais 20% de chance de atordoamento", "", 0, 100,"20% de chance de atordoamento", 0, false, false),
                    new Attack(3, "Cadeia Elétrica", "Emite uma cadeia elétrica entre o inimigo e o cajado", "10 DMG", 10, 100, "30% de chance de atordoamento", 10,false, false)
            );
        }

        public void castLightning(Character attacker, Character target) {
            System.out.println("Realizando Evocar Raio!");
            System.out.println("20 de dano.");
            target.calculateDamage(attacker, target);
        }

        public void thunder(Character attacker, Character target) {
            System.out.println("Realizando Trovão!");
            System.out.println("Durante os próximos 3 turnos possui mais 20% de chance de atordoamento.");
            target.calculateDamage(attacker, target);
        }

        public void electricChain(Character attacker, Character target) {
            System.out.println("Realizando Cadeia Elétrica!");
            System.out.println("10 de dano, 30% de chance de atordoamento.");
            target.calculateDamage(attacker, target);
        }
    }

    public static class FireStaff extends Item {
        public FireStaff() {
            super(9, "Cajado de Fogo", "Arma");
            this.itemActions = Arrays.asList(
                    new Attack(1, "Bola de Fogo", "Sacrifica o próximo turno e arremessa uma bola de fogo", "40 DMG", 40, 100, "100% de chance de acerto", 10,false, true),
                    new Attack(2, "Armadura de Fogo", "Os próximos 5 ataques sofridos causam 5 de dano ao inimigo", "", 10, 100, "100% de chance de acerto", 10,false, false),
                    new Attack(3, "Lança-Chamas", "Evoca um cone de chamas", "20 DMG, 20% de chance de botar fogo", 10, 100, "100% de chance de acerto", 10,false, false)
            );
        }

        public void fireball(Character attacker, Character target) {
            System.out.println("Realizando Bola de Fogo!");
            System.out.println("Sacrifica o próximo turno, arremessa uma bola de fogo que causa 40 de dano.");
            target.calculateDamage(attacker, target);
        }

        public void armorOfFire(Character attacker, Character target) {
            System.out.println("Realizando Armadura de Fogo!");
            System.out.println("Os próximos 5 ataques sofridos causam 5 de dano ao atacante.");
            target.calculateDamage(attacker, target);
        }

        public void flamethrower(Character attacker, Character target) {
            System.out.println("Realizando Lança-Chamas!");
            System.out.println("Evoca um cone de chamas que causa 20 de dano, 20% de chance de botar fogo.");
            target.calculateDamage(attacker, target);
        }
    }

    public static class Dagger extends Item {
        public Dagger() {
            super(10, "Adaga", "Arma");
            this.itemActions = Arrays.asList(
                    new Attack(1, "Corte", "Faz um corte rápido", "5 + DES", 5, 100, "100% de chance de acerto", 10,false, false),
                    new Attack(2, "Ataque Furtivo", "Sai da camuflagem para causar um golpe preciso de surpresa", "10 + DES, Crítico", 10, 100, "100% de chance de acerto", 100,false, false),
                    new Attack(3, "Furtividade", "Sacrifica o turno para ficar camuflado", "", 0, 100, "100% de chance de acerto", 0,false, false),
                    new Attack(4, "Imbuir com veneno", "Aplica veneno à lâmina, os próximos 3 ataques tem 30% de envenenar", "", 0, 100, "30% de chance de envenenar por 3 turnos", 0,false, false)
            );
        }

        public void cut(Character attacker, Character target) {
            System.out.println("Realizando Corte!");
            System.out.println("Causa 5 + destreza de dano.");
            target.calculateDamage(attacker, target);
        }

        public void sneakAttack(Character attacker, Character target) {
            System.out.println("Realizando Ataque Furtivo!");
            System.out.println("Apenas se estiver furtivo, causa 10 + destreza de dano, ataque crítico garantido.");
            target.calculateDamage(attacker, target);
        }

        public void stealth(Character attacker, Character target) {
            System.out.println("Realizando Furtividade!");
            System.out.println("Sacrifica o turno para ficar furtivo.");
            target.calculateDamage(attacker, target);
        }

        public void imbueWithPoison(Character attacker, Character target) {
            System.out.println("Realizando Imbuir com Veneno!");
            System.out.println("30% de chance de envenenar.");
            target.calculateDamage(attacker, target);
        }
    }

    public static class DualKnives extends Item {
        public DualKnives() {
            super(11, "Facas Duplas", "Arma");
            this.itemActions = Arrays.asList(
                    new Attack(1, "Enxurrada de Cortes", "Série de 5 ataques rápidos", "(2 por ataque) + DES", 10, 100, "100% de chance de acerto", 10,false, false),
                    new Attack(2, "Lacerar", "Cruza as lâminas e causa uma ferida aberta", "10 + DES, Crítico", 10, 100, "100% de chance de acerto", 10,false, false),
                    new Attack(3, "Imbuir com chamas", "Aplica óleo inflamável à lâmina, os próximos 3 ataques tem 30% de botar fogo", "", 0, 100, "30% de incandescer", 10,false, false)
            );
        }

        public void flurryOfSlashes(Character attacker, Character target) {
            System.out.println("Realizando Enxurrada de Cortes!");
            System.out.println("Série de 5 ataques rápidos, causando (2 por ataque) + destreza no valor total.");
            target.calculateDamage(attacker, target);
        }

        public void lacerate(Character attacker, Character target) {
            System.out.println("Realizando Lacerar!");
            System.out.println("Cruza as lâminas e causa 10 + destreza de dano, 20% de chance de causar sangramento.");
            target.calculateDamage(attacker, target);
        }

        public void imbueWithFlames(Character attacker, Character target) {
            System.out.println("Realizando Imbuir com Chamas!");
            System.out.println("Embui as lâminas com óleo inflamável, os próximos 3 turnos possuem 20% de chance de queimar o inimigo.");
            target.calculateDamage(attacker, target);
        }
    }

    public static class Rapier extends Item {
        public Rapier() {
            super(12, "Rapieira", "Arma");
            this.itemActions = Arrays.asList(
                    new Attack(1, "Ataque Perfurante", "Faz uma estocada poderosa", "10 + DES", 10, 100, "100% de chance de acerto", 10,false, false),
                    new Attack(2, "Ataque Decisivo", "Ataca com confiança, fazendo o inimigo perder o turno (não pode ser usado sucessivamente)", "10 + DES", 10, 100, "100% de chance de acerto", 10,false, false),
                    new Attack(3, "Ripostar", "Sacrifica o turno para defletir o próximo ataque do inimigo, recupera o fôlego em um sucesso", "10 + DES, +5hp", 10, 50, "50% de chance de acerto", 10,false, false)
            );
        }

        public void thrust(Character attacker, Character target) {
            System.out.println("Realizando Ataque Perfurante!");
            System.out.println("Causa 10 + destreza de dano.");
            target.calculateDamage(attacker, target);
        }

        public void decisiveStrike(Character attacker, Character target) {
            System.out.println("Realizando Ataque Decisivo!");
            System.out.println("Causa 10 + destreza de dano, o turno do inimigo é ignorado, não pode ser usado sucessivamente.");
            target.calculateDamage(attacker, target);
        }

        public void riposte(Character attacker, Character target) {
            System.out.println("Realizando Ripostar!");
            System.out.println("Sacrifica o turno para defletir o próximo ataque do inimigo, 50% de chance de acerto, curando 5 hp num sucesso.");
            target.calculateDamage(attacker, target);
        }
    }
}
