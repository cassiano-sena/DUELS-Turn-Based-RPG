import java.util.ArrayList;
import java.util.List;

public class AttackList {
    public static final List<Attack> AttackList = new ArrayList<>();

    static {
        AttackList.add(new Attack(1, "Contra-ataque", "Sacrifica o turno para bloquear o próximo ataque e contra-atacar", "FOR", 10, 50, "",0, 100, true, false, 1));
        AttackList.add(new Attack(2, "Corte", "Corta em sua frente com uma força considerável", "FOR", 10, 50,"sangramento",25, 10,false,false, 1));
        AttackList.add(new Attack(3, "Finta", "Finge um ataque e surpreende atacando de outra forma", "FOR", 10, 50,"atordoamento",50,10,false,false,2));



        AttackList.add(new Attack(4, "Ataque Selvagem", "Ataca ferozmente sem nenhum cuidado", "FOR", 20,50, "ricochete",20, 10,false, false, 1));
        AttackList.add(new Attack(5, "Machadada Forte", "Utiliza toda a inércia possível para causar dano", "FOR", 10, 100, "atordoamento",25, 10,false, false, 1));
        AttackList.add(new Attack(6, "Mutilar", "Mutila o inimigo de forma sádica", "FOR", 10, 50, "sangramento",100, 10,false, false,1));



        AttackList.add(new Attack(7, "Salto Atordoante", "Salta em direção ao oponente com seu martelo", "FOR", 10, 50, "atordoamento",50, 10,false, false, 1));
        AttackList.add(new Attack(8, "Martelo Pesado", "Balança o pesado martelo", "FOR", 20,50, "",0, 100,false, false, 1));
        AttackList.add(new Attack(9, "Carregar", "Sacrifica o turno carregando para um poderoso ataque", "FOR", 20, 70, "",0, 100,true, false, 1));



        AttackList.add(new Attack(10, "Saraivada de Flechas", "Rapidamente direciona cinco flechas rápidas em direção ao inimigo", "DES", 3, 33, "",0, 10,false, false, 5));
        AttackList.add(new Attack(11, "Flecha Rápida", "Arremessa uma flecha rápida", "DES", 10, 100, "",0, 10,false, false, 1));
        AttackList.add(new Attack(12, "Flecha Sonífera", "Arremessa uma flecha sonífera", "10 + DES", 10, 100, "sono", 20, 10,false, false, 1));
        AttackList.add(new Attack(13, "Manter Distância", "Ganha distância contra ataques corpo-a-corpo, se o inimigo não usa uma arma a distância", "", 0, 75, "", 0, 0,false, false, 1));



        AttackList.add(new Attack(14, "Flecha Precisa", "Dispara com precisão uma flecha em direção ao inimigo", "DES", 10, 100, "",0, 50,false, false, 1));
        AttackList.add(new Attack(15, "Flecha Envenenada", "Arremessa uma flecha envenenada", "10 + DES", 10, 100, "veneno",25, 10,false, false, 1));
        AttackList.add(new Attack(16, "Flecha Pesada", "Arremessa uma flecha pesada em direção ao inimigo", "10 + DES", 10, 100, "atordoar",20, 10,false, false, 1));



        AttackList.add(new Attack(17, "Flechada Forte", "Dispara com força uma flecha em direção ao inimigo", "DES", 10, 100, "",0, 10,false, false, 1));
        AttackList.add(new Attack(18, "Flecha de Fogo", "Arremessa uma flecha de fogo", "10 + DES", 10, 100, "fogo",0, 10,false, false, 1));
        AttackList.add(new Attack(19, "Headshot", "Sacrifica o turno para ter extrema precisão no turno seguinte", "30 + DES", 10, 100, "",0, 100,true, false, 1));



        AttackList.add(new Attack(20, "Magia do Sono", "Recita um encantamento adormecente", "INT", 0, 50, "sono",50, 10,false, false, 1));
        AttackList.add(new Attack(21, "Cometa Explosivo", "Arremessa um cometa mágico que pode explodir ao contato", "INT", 10, 60, "",0, 50,false, false, 1));
        AttackList.add(new Attack(22, "Esfera Arcana", "Conjura uma esfera arcana rápida", "INT", 10, 100, "atordoamento",20, 10,false, false, 1));



        AttackList.add(new Attack(23, "Evocar Raio", "Conjura um raio", "INT",20 ,100, "",0, 50,false, false, 1));
        AttackList.add(new Attack(24, "Trovão", "Evoca uma tempestade.", "INT", 10, 100,"atordoamento",50, 0, false, false, 1));
        AttackList.add(new Attack(25, "Cadeia Elétrica", "Emite uma cadeia elétrica entre o inimigo e o cajado", "INT", 10, 100, "atordoamento",30, 10,false, false,1));



        AttackList.add(new Attack(26, "Bola de Fogo", "Sacrifica o próximo turno e arremessa uma bola de fogo", "INT",40, 50, "",0, 30,false, true, 1));
        AttackList.add(new Attack(27, "Armadura de Fogo", "Os próximos 5 ataques sofridos causam 5 de dano ao inimigo", "INT", 0, 100, "espinhos",100, 10,false, false, 1));
        AttackList.add(new Attack(28, "Lança-Chamas", "Evoca um cone de chamas", "INT", 10, 50, "fogo",50, 10,false, false, 1));



        AttackList.add(new Attack(29, "Corte", "Faz um corte rápido", "DES", 5, 100, "",0, 20,false, false, 1));
        AttackList.add(new Attack(30, "Ataque Furtivo", "Sai da camuflagem para causar um golpe preciso de surpresa", "DES", 5, 100, "",0, 100,false, false, 1));
        AttackList.add(new Attack(31, "Furtividade", "Fica camuflado", "", 0, 100, "camuflado",100, 0,false, false, 1));
        AttackList.add(new Attack(32, "Imbuir com veneno", "Aplica veneno à lâmina", "", 10, 100, "veneno",50, 0,false, false, 1));



        AttackList.add(new Attack(33, "Enxurrada de Cortes", "Série de 5 ataques rápidos", "DES", 10, 50, "",0, 10,false, false, 5));
        AttackList.add(new Attack(34, "Lacerar", "Cruza as lâminas e causa uma ferida aberta", "DES", 10, 50, "sangramento",50, 10,false, false, 1));
        AttackList.add(new Attack(35, "Imbuir com chamas", "Aplica óleo inflamável à lâmina", "", 10, 100, "fogo",30, 10,false, false, 1));



        AttackList.add(new Attack(36, "Ataque Perfurante", "Faz uma estocada poderosa", "DES", 10, 100, "",0, 10,false, false, 1));
        AttackList.add(new Attack(37, "Ataque Decisivo", "Ataca com confiança", "DES", 10, 100, "",0, 10,false, false, 1));
        AttackList.add(new Attack(38, "Ripostar", "Sacrifica o turno para defletir o próximo ataque do inimigo, recupera o fôlego em um sucesso", "", 10, 50, "curar",50, 10,true, false, 1));
    }

    public static void printAttackDetails() {
        for (Attack attack : AttackList) {
            attack.printDetails();
            System.out.println();
        }
    }

    public static Attack getAttackById(int attackId) {
        int index = attackId - 1;
        if (index >= 0 && index < AttackList.size()) {
            return AttackList.get(index);
        } else {
            return null;
        }
    }


}
