public class OpponentMaker{
    static Opponent makeRandomOpponent(){
        Opponent opponent;
        String name;
        int randomType;
        int randomHealth;
        
        randomType = (int) Math.round(Math.random() * 10);
        randomHealth = (int) 100 + 50 * Math.round(Math.random() * 3);

        switch(randomType){
            case 0:
                name = "BUG CATCHER";
                break;
            case 1:
                name = "MISTY";
                break;
            case 2:
                name = "TEAM ROCKET";
                break;
            case 3:
                name = "FISHERMAN";
                break;
            case 4:
                name = "GARY";
                break;
            default:
                name = "TRAINER";
                break;
        }
    
        opponent = new Opponent(name, randomHealth, randomType);
        return opponent;        
    }
