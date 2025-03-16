package se459rogue.assets.room;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import se459rogue.assets.util.Position;

public class RoomManager {
    private int minWidth = 150;
    private int maxWidth = 250;
    private int minHeight = 100;
    private int maxHeight = 200;

   
    
    /**
     *  A method used to create the the dungeon rooms
     *  Think of this like a grid, we create six rooms in total and divid the panel into six sections
     *  We made the panle 12 X 16(Our screen size is 768 X 576). So the top row is at position 16 and we change the x instead of the y
     *  For the bottom row, we need to change both the x and y position. This is how we get three rooms
     *  at the top and bottom. To get the x posistion I take 768 and dvide it by 3, for the y postion
     *  I take 576 and dvide by 3
     * @param grid
     * @return Room
     */
    public Room createRoom(int grid){
        //random number gen
        Random rand = new Random();

        Position roomPosition = new Position();
        
        int width = rand.nextInt(maxWidth - minWidth) + 35;
        int height = rand.nextInt(maxHeight - minHeight) +  35;

        switch(grid){
            case 0:
                roomPosition.setX(12);
                roomPosition.setY(16);
                break;
            case 1:
                roomPosition.setX(256);
                roomPosition.setY(16);
                break;
            case 2:
                roomPosition.setX(512);
                roomPosition.setY(16);
                break;
            case 3:
                roomPosition.setX(12);
                roomPosition.setY(192);
                break;
            case 4:
                roomPosition.setX(256);
                roomPosition.setY(250);
                break;
            case 5:
                roomPosition.setX(512);
                roomPosition.setY(192);
                break;
        }

        // room offset
        int offsetX = roomPosition.getX();
        offsetX += rand.nextInt(maxWidth - minWidth) % (maxWidth - width + 1);
        roomPosition.setX(offsetX);

        int offsetY = roomPosition.getY();
        offsetY += rand.nextInt(maxHeight - minHeight) % (maxHeight - height + 1);
        roomPosition.setY(offsetY + 100);
       
        Room room = new Room();
        List<Position> doorPos = new ArrayList<>();
        Position topDoor = new Position();
        Position bottomDoor = new Position();
        Position leftDoor = new Position();
        Position rightDoor = new Position();


        // Door Cordinates
        int topDoorPostionX = rand.nextInt(width - 3) + roomPosition.getX() + 1;
        int topDoorPostionY = roomPosition.getY();

        int bottomDoorPostionX = rand.nextInt(width - 3) + roomPosition.getX() + 1;
        int bottomDoorPostionY = roomPosition.getY() + height - 1;

        int leftDoorPostionX = roomPosition.getX();
        int leftDoorPostionY = rand.nextInt(height - 3) + roomPosition.getY() + 1;

        int rightDoorPostionX = roomPosition.getX() + width - 1;
        int rightDoorPostionY = rand.nextInt(height - 3) + roomPosition.getY() + 1;

        topDoor.setX(topDoorPostionX);
        topDoor.setY(topDoorPostionY);
        bottomDoor.setX(bottomDoorPostionX);
        bottomDoor.setY(bottomDoorPostionY);
        leftDoor.setX(leftDoorPostionX);
        leftDoor.setY(leftDoorPostionY);
        rightDoor.setX(rightDoorPostionX);
        rightDoor.setY(rightDoorPostionY);
        
        doorPos.add(topDoor);
        doorPos.add(bottomDoor);
        doorPos.add(leftDoor);
        doorPos.add(rightDoor);
        
        // Room Creation
        room.setPosition(roomPosition);
        room.setWidth(width);
        room.setHeight(height);
        room.setDoors(doorPos);
        
        return room;
    }

    /**
     * A method used to draw the provided room data to our game panel
     * @param room
     * @param graphics2d
     */
    public void drawRoom(Room room, Graphics2D graphics2d){
        boolean leftDoor = false;
        boolean rightDoor = false;

        graphics2d.setColor(Color.WHITE);
        graphics2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));

        // Draw the top of the room
        graphics2d.drawString("+", room.getDoors().get(0).getX(), room.getDoors().get(0).getY());
        graphics2d.drawString("-".repeat(room.getWidth()/8), room.getPosition().getX(), room.getPosition().getY());

        // Draw the left side wall and the floors of the room
        for(int i = 1; i < room.getHeight()/10; i++ ){
            graphics2d.drawString("|", room.getPosition().getX() - 4, room.getPosition().getY() + i*10);
            graphics2d.drawString(".".repeat(room.getWidth()/7), room.getPosition().getX(), room.getPosition().getY() + i*9);
            if(!leftDoor){
                graphics2d.drawString("+", room.getDoors().get(2).getX() - 4, room.getDoors().get(2).getY() + i*10);
                leftDoor = true;
            }
        }

        // Draw the right side wall
        for(int i = 1; i< room.getHeight()/10; i++){
            graphics2d.drawString("|", room.getPosition().getX() + room.getWidth() - 5, room.getPosition().getY() + i*10);
            if(!rightDoor){
                graphics2d.drawString("+", room.getDoors().get(3).getX() - 5, room.getDoors().get(3).getY() + i*10);
                rightDoor = true;
            }
        }

        // Draw the bottom of the room
        graphics2d.drawString("+", room.getDoors().get(1).getX(), room.getDoors().get(1).getY());
        graphics2d.drawString("-".repeat(room.getWidth()/8), room.getPosition().getX(), room.getPosition().getY() + room.getHeight());

        if(room.getMonster() !=null ){
            if(!room.getMonster().isDefeated()){
                drawMonster(room, graphics2d);
            }
        }

        if(room.getItem() !=null){
            if(!room.getItem().isCollected() && room.getItem().getName() != null){
                drawItem(room, graphics2d);
            }
        }

        if(room.getGold() != null){
            if(!room.getGold().isCollected()){
                drawGold(room, graphics2d);
            }
        }

        if(room.getFood() !=null){
            if(!room.getFood().isCollected()){
                drawFood(room, graphics2d);
            }
        }

    }

    private void drawMonster(Room room, Graphics2D graphics2d){
        graphics2d.setColor(Color.YELLOW);
        graphics2d.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        graphics2d.drawString(room.getMonster().getSymbol(), room.getMonster().getPosition().getX(), room.getMonster().getPosition().getY());
    }

    private void drawItem(Room room, Graphics2D graphics2d){
        graphics2d.setColor(Color.YELLOW);
        graphics2d.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        graphics2d.drawString(room.getItem().getName(), room.getItem().getPosition().getX(), room.getItem().getPosition().getY());
    }

    private void drawGold(Room room, Graphics2D graphics2d){
        graphics2d.setColor(Color.YELLOW);
        graphics2d.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        graphics2d.drawString(Integer.toString(room.getGold().getAmmount()), room.getGold().getPosition().getX(), room.getGold().getPosition().getY());
    }
    
    private void drawFood(Room room, Graphics2D graphics2d){
        graphics2d.setColor(Color.YELLOW);
        graphics2d.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        graphics2d.drawString("FO", room.getFood().getPosition().getX(), room.getFood().getPosition().getY());
    }

    //Implement later when we get to connecting rooms
    // private void connectDoors(Position d1, Position d2){
    //     Position temp = new Position();
    //     temp.setX(d1.getX());
    //     temp.setY(d1.getY());

    //     while (true) {
            
    //     }

    // }
}
