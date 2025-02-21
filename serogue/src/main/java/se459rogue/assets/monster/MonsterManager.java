package se459rogue.assets.monster;

import java.util.List;
import java.util.Random;

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
        String lowerSymbolRangeFull = "BCEHIKLORSZ";
        String lowerSymbolRangeMid = "BEHIKLORSZ";
        String lowerSymbolRange = "BEHKS";
        String allOtherSymbol = "ADFGJMNPQTUVWXY";
        char symbol = 'A';
        
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
                break;
            case 'B':
                monster.setSymbol("B");
                monster.setAttack(2);
                monster.setDefence(8);
                monster.setExp(1);
                monster.setHealth(8);
                break;
            case 'C':
                monster.setSymbol("C");
                monster.setAttack(3);
                monster.setDefence(7);
                monster.setExp(25);
                monster.setHealth(18);
                break;
            case 'D':
                monster.setSymbol("D");
                monster.setAttack(16);
                monster.setDefence(1);
                monster.setExp(6800);
                monster.setHealth(45);
                break;
            case 'E':
                monster.setSymbol("E");
                monster.setAttack(2);
                monster.setDefence(10);
                monster.setExp(2);
                monster.setHealth(4);
                break;
            case 'F':
                monster.setSymbol("F");
                monster.setAttack(1);
                monster.setDefence(3);
                monster.setExp(80);
                monster.setHealth(36);
                break;
            case 'G':
                monster.setSymbol("G");
                monster.setAttack(10);
                monster.setDefence(-2);
                monster.setExp(2000);
                monster.setHealth(58);
                break;
            case 'H':
                monster.setSymbol("H");
                monster.setAttack(4);
                monster.setDefence(10);
                monster.setExp(3);
                monster.setHealth(4);
                break;
            case 'I':
                monster.setSymbol("I");
                monster.setAttack(2);
                monster.setDefence(10);
                monster.setExp(15);
                monster.setHealth(4);
                break;
            case 'J':
                monster.setSymbol("J");
                monster.setAttack(13);
                monster.setDefence(-4);
                monster.setExp(4000);
                monster.setHealth(57);
                break;
            case 'K':
                monster.setSymbol("K");
                monster.setAttack(2);
                monster.setDefence(10);
                monster.setExp(1);
                monster.setHealth(4);
                break;
            case 'L':
                monster.setSymbol("L");
                monster.setAttack(2);
                monster.setDefence(8);
                monster.setExp(10);
                monster.setHealth(13);
                break;
            case 'M':
                monster.setSymbol("M");
                monster.setAttack(7);
                monster.setDefence(9);
                monster.setExp(200);
                monster.setHealth(36);
                break;
            case 'N':
                monster.setSymbol("N");
                monster.setAttack(0);
                monster.setDefence(2);
                monster.setExp(37);
                monster.setHealth(13);
                break;
            case 'O':
                monster.setSymbol("O");
                monster.setAttack(4);
                monster.setDefence(5);
                monster.setExp(5);
                monster.setHealth(4);
                break;
            case 'P':
                monster.setSymbol("P");
                monster.setAttack(10);
                monster.setDefence(8);
                monster.setExp(120);
                monster.setHealth(36);
                break;
            case 'Q':
                monster.setSymbol("Q");
                monster.setAttack(4);
                monster.setDefence(9);
                monster.setExp(32);
                monster.setHealth(13);
                break;
            case 'R':
                monster.setSymbol("R");
                monster.setAttack(3);
                monster.setDefence(8);
                monster.setExp(9);
                monster.setHealth(9);
                break;
            case 'S':
                monster.setSymbol("S");
                monster.setAttack(3);
                monster.setDefence(3);
                monster.setExp(1);
                monster.setHealth(9);
                break;
            case 'T':
                monster.setSymbol("T");
                monster.setAttack(7);
                monster.setDefence(7);
                monster.setExp(120);
                monster.setHealth(27);
                break;
            case 'U':
                monster.setSymbol("U");
                monster.setAttack(14);
                monster.setDefence(13);
                monster.setExp(190);
                monster.setHealth(31);
                break;
            case 'V':
                monster.setSymbol("V");
                monster.setAttack(6);
                monster.setDefence(10);
                monster.setExp(350);
                monster.setHealth(36);
                break;
            case 'W':
                monster.setSymbol("W");
                monster.setAttack(3);
                monster.setDefence(7);
                monster.setExp(55);
                monster.setHealth(22);
                break;
            case 'X':
                monster.setSymbol("X");
                monster.setAttack(7);
                monster.setDefence(4);
                monster.setExp(100);
                monster.setHealth(31);
                break;
            case 'Y':
                monster.setSymbol("Y");
                monster.setAttack(3);
                monster.setDefence(5);
                monster.setExp(50);
                monster.setHealth(18);
                break;
            case 'Z':
                monster.setSymbol("Z");
                monster.setAttack(2);
                monster.setDefence(3);
                monster.setExp(6);
                monster.setHealth(9);
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
}
