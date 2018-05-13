import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int map_size = 4;
        int[] player ={1,1};
        boolean is_p;
        int dx ,dy;
        int moved_x , moved_y ;


        while(true){
            for (int i = 0; i <map_size; i++){
                for (int j = 0; j<map_size; j++){
                    is_p = false;
                    if (i ==player[1] && j == player[0]){
                        System.out.print("P");
                        is_p = true;
                    }
                    if(!is_p){
                        System.out.print("*");
                    }
                }
                System.out.println();
            }
            Scanner scanner = new Scanner (System.in);
            String move = scanner.next();

            dx =0; dy = 0;
            switch (move){
                case "a" :
                case "A":
                    dx = -1;
                    break;
                case "d":
                case "D":
                    dx = 1;
                    break;
                case "w":
                case "W":
                    dy =-1;
                    break;
                case "s":
                case "S":
                    dy =1;
                    break;
                default:
                    System.out.println("enter  a,s,d,w");
                    break;
            }

            moved_x = player[0] +dx;
            moved_y = player[1] +dy;

            if( moved_x >= map_size ){
                player[0] =0;
            }
            else if (moved_x < 0){
                player[0] = map_size -1;
            }
            else if (moved_y <0){
                player[1] = map_size -1;
            }
            else if (moved_y >= map_size){
                player[1] = 0;
            }
            else{
                player[0] = moved_x;
                player[1] = moved_y;
            }

        }
    }
}
