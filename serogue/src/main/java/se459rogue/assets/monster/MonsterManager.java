package se459rogue.assets.monster;

import java.util.List;
import java.util.Random;

import se459rogue.assets.level.Level;
import se459rogue.assets.player.PlayerManager;
import se459rogue.assets.room.Room;
import se459rogue.assets.util.Position;

public class MonsterManager {
   
    
    public void addMonster(int level, List<Room>rooms){
       
        for(int x = 0; x < rooms.size(); x++){
            Random monsterChance = new Random();

            if(monsterChance.nextInt() % 2 == 0){
                rooms.get(x).setMonster(selectMonster(level));
                setStartingPostion(rooms.get(x).getMonster(), rooms.get(x));
            }
        }
        
    }

    private Monster selectMonster(int level){
        Monster monster = new Monster();
        Random random = new Random();
        Random pathFinding = new Random();
        String lowerSymbolRangeFull = "BCEHIKLORSZ";
        String lowerSymbolRangeMid = "BEHIKLORSZ";
        String lowerSymbolRange = "BEHKS";
        String allOtherSymbol = "ADFGJMNPQTUVWXY";
        char symbol = 'A';
        int path = pathFinding.nextInt(2);

        if(level >=0 && level <=6){
            if(level >=2 && level <=5){
                symbol = lowerSymbolRangeMid.charAt(random.nextInt(lowerSymbolRangeMid.length()));
            }else if(level >=0  && level <=1){
                symbol = lowerSymbolRange.charAt(random.nextInt(lowerSymbolRange.length())); 
            }else{
                symbol = lowerSymbolRangeFull.charAt(random.nextInt(lowerSymbolRangeFull.length())); 
            }
        }else{
            symbol = allOtherSymbol.charAt(random.nextInt(allOtherSymbol.length())); 
        }

        switch (symbol) {
            case 'A':
                monster.setSymbol("A");
                monster.setAttack(0);
                monster.setDefence(9);
                monster.setExp(20);
                monster.setHealth(25);
                monster.setPathfinding(path);
                break;
            case 'B':
                monster.setSymbol("B");
                monster.setAttack(2);
                monster.setDefence(8);
                monster.setExp(1);
                monster.setHealth(8);
                monster.setPathfinding(path);
                break;
            case 'C':
                monster.setSymbol("C");
                monster.setAttack(3);
                monster.setDefence(7);
                monster.setExp(25);
                monster.setHealth(18);
                monster.setPathfinding(path);
                break;
            case 'D':
                monster.setSymbol("D");
                monster.setAttack(16);
                monster.setDefence(1);
                monster.setExp(6800);
                monster.setHealth(45);
                monster.setPathfinding(path);
                break;
            case 'E':
                monster.setSymbol("E");
                monster.setAttack(2);
                monster.setDefence(10);
                monster.setExp(2);
                monster.setHealth(4);
                monster.setPathfinding(path);
                break;
            case 'F':
                monster.setSymbol("F");
                monster.setAttack(1);
                monster.setDefence(3);
                monster.setExp(80);
                monster.setHealth(36);
                monster.setPathfinding(path);
                break;
            case 'G':
                monster.setSymbol("G");
                monster.setAttack(10);
                monster.setDefence(-2);
                monster.setExp(2000);
                monster.setHealth(58);
                monster.setPathfinding(path);
                break;
            case 'H':
                monster.setSymbol("H");
                monster.setAttack(4);
                monster.setDefence(10);
                monster.setExp(3);
                monster.setHealth(4);
                monster.setPathfinding(path);
                break;
            case 'I':
                monster.setSymbol("I");
                monster.setAttack(2);
                monster.setDefence(10);
                monster.setExp(15);
                monster.setHealth(4);
                monster.setPathfinding(path);
                break;
            case 'J':
                monster.setSymbol("J");
                monster.setAttack(13);
                monster.setDefence(-4);
                monster.setExp(4000);
                monster.setHealth(57);
                monster.setPathfinding(path);
                break;
            case 'K':
                monster.setSymbol("K");
                monster.setAttack(2);
                monster.setDefence(10);
                monster.setExp(1);
                monster.setHealth(4);
                monster.setPathfinding(path);
                break;
            case 'L':
                monster.setSymbol("L");
                monster.setAttack(2);
                monster.setDefence(8);
                monster.setExp(10);
                monster.setHealth(13);
                monster.setPathfinding(path);
                break;
            case 'M':
                monster.setSymbol("M");
                monster.setAttack(7);
                monster.setDefence(9);
                monster.setExp(200);
                monster.setHealth(36);
                monster.setPathfinding(path);
                break;
            case 'N':
                monster.setSymbol("N");
                monster.setAttack(0);
                monster.setDefence(2);
                monster.setExp(37);
                monster.setHealth(13);
                monster.setPathfinding(path);
                break;
            case 'O':
                monster.setSymbol("O");
                monster.setAttack(4);
                monster.setDefence(5);
                monster.setExp(5);
                monster.setHealth(4);
                monster.setPathfinding(path);
                break;
            case 'P':
                monster.setSymbol("P");
                monster.setAttack(10);
                monster.setDefence(8);
                monster.setExp(120);
                monster.setHealth(36);
                monster.setPathfinding(path);
                break;
            case 'Q':
                monster.setSymbol("Q");
                monster.setAttack(4);
                monster.setDefence(9);
                monster.setExp(32);
                monster.setHealth(13);
                monster.setPathfinding(path);
                break;
            case 'R':
                monster.setSymbol("R");
                monster.setAttack(3);
                monster.setDefence(8);
                monster.setExp(9);
                monster.setHealth(9);
                monster.setPathfinding(path);
                break;
            case 'S':
                monster.setSymbol("S");
                monster.setAttack(3);
                monster.setDefence(3);
                monster.setExp(1);
                monster.setHealth(9);
                monster.setPathfinding(path);
                break;
            case 'T':
                monster.setSymbol("T");
                monster.setAttack(7);
                monster.setDefence(7);
                monster.setExp(120);
                monster.setHealth(27);
                monster.setPathfinding(path);
                break;
            case 'U':
                monster.setSymbol("U");
                monster.setAttack(14);
                monster.setDefence(13);
                monster.setExp(190);
                monster.setHealth(31);
                monster.setPathfinding(path);
                break;
            case 'V':
                monster.setSymbol("V");
                monster.setAttack(6);
                monster.setDefence(10);
                monster.setExp(350);
                monster.setHealth(36);
                monster.setPathfinding(path);
                break;
            case 'W':
                monster.setSymbol("W");
                monster.setAttack(3);
                monster.setDefence(7);
                monster.setExp(55);
                monster.setHealth(22);
                monster.setPathfinding(path);
                break;
            case 'X':
                monster.setSymbol("X");
                monster.setAttack(7);
                monster.setDefence(4);
                monster.setExp(100);
                monster.setHealth(31);
                monster.setPathfinding(path);
                break;
            case 'Y':
                monster.setSymbol("Y");
                monster.setAttack(3);
                monster.setDefence(5);
                monster.setExp(50);
                monster.setHealth(18);
                monster.setPathfinding(path);
                break;
            case 'Z':
                monster.setSymbol("Z");
                monster.setAttack(2);
                monster.setDefence(3);
                monster.setExp(6);
                monster.setHealth(9);
                monster.setPathfinding(path);
                break;
            default:
                break;
        }
         
        return monster; 
    }

    private void setStartingPostion(Monster monster, Room room){
        Position monsterPostion = new Position();
        Random random = new Random();
        monsterPostion.setX( (random.nextInt(room.getWidth()) % room.getWidth() - 2) + room.getPosition().getX() + 1);
        monsterPostion.setY((random.nextInt(room.getHeight()) % room.getHeight() - 2) + room.getPosition().getY() + 1);
        monster.setPosition(monsterPostion);
    }

    public  void moveMonster(Level level, PlayerManager player){
        for(int x = 0; x < level.getNumberOfRooms(); x++){
            if(level.getRooms().get(x).getMonster() != null){
                if(level.getRooms().get(x).getMonster().getPathfinding() == 0){
                    pafthFindingRandom(level.getRooms().get(x).getMonster().getPosition(), level.getRooms().get(x));
                }else{
                    pathFindingSeek(level.getRooms().get(x).getMonster().getPosition(), player.getPosition(), level.getRooms().get(x));
                }
            }
        }
    }
    
    //monster moves to the player
    private void pathFindingSeek(Position start, Position destination, Room room){
        if( ( Math.abs( (start.getX() -1)  - destination.getX()) < Math.abs(start.getX() - destination.getX()))){
            room.getMonster().getPosition().setX(start.getX() - 1);    
        }else if( ( Math.abs((start.getX() + 1) - destination.getX()) < Math.abs(start.getX() - destination.getX()))){
            room.getMonster().getPosition().setX(start.getX() + 1);
        }else if(( Math.abs( (start.getY() + 1)  - destination.getY()) < Math.abs(start.getY() - destination.getY()) )){
            room.getMonster().getPosition().setY(start.getY() + 1);
        }else if(( Math.abs( (start.getY() -1)  - destination.getY()) < Math.abs(start.getY() - destination.getY()) )){
            room.getMonster().getPosition().setY(start.getY() - 1);
        }
    }

    //monster moves randomly
    private void pafthFindingRandom(Position start, Room room){
        Random random = new Random();
        switch (random.nextInt(5)) {
            /*Go Up */
            case 0:
                room.getMonster().getPosition().setY(start.getY() - 1);
                break;
            /*Go Down */
            case 1:
                room.getMonster().getPosition().setY(start.getY() + 1);
                break;
            /*Go Left */
            case 2:
                room.getMonster().getPosition().setX(start.getX() - 1);
                break;
            /*Go Right */
            case 3:
                room.getMonster().getPosition().setX(start.getX() + 1);
                break;
            /*Do Nothing */
            case 4:
                break;
            default:
                break;
        }
    }

    
}
