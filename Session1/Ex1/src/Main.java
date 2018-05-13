import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int map_size = 4;
        int[] player ={1,1};
        boolean is_p;
        int dx ,dy;


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


            if(player[0] +dx >=map_size || player[0] +dx <0 || player[1] +dy <0 || player[1] +dy >=map_size ){
                System.out.println("can not move");
            }
            else{
                player[0] = player[0] + dx;
                player[1] = player[1] + dy;
            }

        }
    }
}
