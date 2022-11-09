package lld.minesweeper.entity;


import java.util.*;

public class Board {
    private UUID id;
    transient int size;
    private final Cell[][] cells;

    transient Set<Integer> set= new HashSet<>();
    transient Map<UUID,Points> map= new HashMap<>();

    public Board(int size) {
        this.id=UUID.randomUUID();
        this.size = size;
        this.cells  = new Cell[size][size] ;
        initiateCell();
    }

    private void initiateCell() {
        for (int i=0;i< cells.length;i++) {
            for (int j=0;j<cells.length;j++) {
                cells[i][j]= new Cell();
            }
        }
    }

    public void print(){
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                if (Type.P==value.getType()){
                    System.out.print(map.get(value.getSpecialEntityId()).value+""+value + " ");
                }else {

                    System.out.print(value + "  ");
                }
            }
            System.out.println();
        }
    }

    public void addBomb(int bomb, int size) {
        Random random= new Random();
        for (int i = 0; i < bomb; i++) {
            int r= random.nextInt(size);
            int c= random.nextInt(size);
            int tt=(r*10)+c;
            if (set.contains(tt)){
                i--;
                continue;
            }
            set.add(tt);
            System.out.println(r+" "+c);
           Cell cell= this.cells[r][c];
           cell.setType(Type.B);
            this.cells[r][c]=cell;
        }
    }

    public void addPoints(int points, int size) {
        Random random= new Random();
        for (int i = 0; i < points; i++) {
            int r= random.nextInt(size);
            int c= random.nextInt(size);
            int tt=(r*10)+c;
            if (set.contains(tt)){
                i--;
                continue;
            }
            set.add(tt);
            System.out.println(r+" "+c);
            Cell cell= this.cells[r][c];
            cell.setType(Type.P);
            Points p=new Points((r+c)%3);
            map.put(p.getId(),p);
            cell.setSpecialEntityId(p.getId());
            this.cells[r][c]=cell;
        }
    }
}
