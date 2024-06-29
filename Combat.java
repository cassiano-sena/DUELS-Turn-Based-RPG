public class Combat {
    int turns; // total amount of turns that have elapsed
    int order[]; // dictates the order of action during combat
    int orderCounter[]; // indicates whose action it is

    public void turnOrder(int dexterity, int dexterity2){
        boolean faster = dexterity > dexterity2;
        if(faster){
            order[0]=dexterity;
            order[1]=dexterity2;
        }
        else{
            order[1] = dexterity;
            order[0] = dexterity2;
        }
    }
}
