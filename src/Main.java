import java.util.*;

public class Main {
    public static void main(String[] args) {
        int map_size = 4;
        int[][] enemies = new int[2][2]; // 2 enemy x 2 toa do x,y
        int[][] speed_enemies = {{1,0},{0,1}}; // enemy 0 di tu trai sang phai, enemy 1 di tu tren xuong duoi


        int[] player = {3,2};
        boolean is_p, is_e, is_g;
        int dx,dy;


        List<int[]> filled_pos = new ArrayList<>(); // luu ca vi tri da co character
        filled_pos.add(player);

        Random random= new Random();
        // random vi tri 2 enemy

        int num_enemies = 0;
        int[] enemy = new int[2];
        while (num_enemies <enemies.length){
            enemy[0] = random.nextInt(4);
            enemy[1] = random.nextInt(4);

            boolean same = false;
            for (int[] pos:filled_pos) {

                if(Arrays.equals(enemy,pos)){
                    same = true;
                    break;
                }
            }

            if (!same){
                int[] new_enemy = {enemy[0],enemy[1]};
                // nếu ko tạo biến mới add thẳng enemy vào filled_pos thì vòng lặp sau enemy đã add lấy giá trị của enemy mới
                // dẫn đến lặp vô tận do same luôn true
                enemies[num_enemies]= new_enemy;
                num_enemies +=1;
                filled_pos.add(new_enemy);
//                System.out.println(enemy[0]);
//                System.out.println(enemy[1]);
            }

        }

        // random vi tri hop qua

        int [] gift = new int[2];
        while(true){
            gift[0] = random.nextInt(4);
            gift[1] = random.nextInt(4);
            boolean same = false;
            for (int[]pos: filled_pos){
                if(Arrays.equals(pos, gift)){
                    same =true;
                    break;
                }
            }
            if(!same){
                break;
            }
        }


        boolean end_game = false;

        while(true){
            //hiển thị map
            for (int i = 0; i < map_size; i++){
                for (int j = 0; j< map_size; j++){
                    is_p = false;
                    is_e = false;
                    is_g = false;
                    for (int[] enemy_pos: enemies) {
                        if(enemy_pos[0]==j && enemy_pos[1]==i){
                            System.out.print("X");
                            is_e = true;
                            break;
                        }

                    }
                    if (player[1] == i && player[0]==j && !is_e){
                        System.out.print("P");
                        is_p = true;
                    }
                    if (gift[1] == i && gift[0]==j && !is_e && !is_p){
                        System.out.print("G");
                        is_g = true;
                    }
                    if (!is_p && !is_e&& !is_g){
                        System.out.print("*");
                    }
                }
                System.out.println();
            }

            // kiểm tra vị trí các character
            for (int[] enemy_pos:enemies) {
                if(Arrays.equals(enemy_pos, player)){
                    System.out.println("you lose!!!");
                    end_game = true;
                    break;
                }
            }
            if(end_game){
                break;
            }
            if (player[0]== gift[0]&& player[1]==gift[1]){
                System.out.println("you win!!!");
                break;
            }




            // điều khiển player
            Scanner scanner = new Scanner(System.in);
            String move = scanner.next();

            dx = 0; dy =0;
            if(move.equalsIgnoreCase("a")){
                dx = -1;
            }
            else if (move.equalsIgnoreCase("d")){
                dx = 1;
            }
            else if (move.equalsIgnoreCase("w")){
                dy = -1;
            }
            else if (move.equalsIgnoreCase("s")){
                dy = 1;
            }
            else{
                System.out.println("enter a,s,w,d");
            }


            // kiểm tra ko cho player và enemy chạy ngang qua nhau
            //player di chuyển sang trái, player cùng hàng với enemy 0
            boolean pass = false;
            if (dx <0){
                //player đứng bên phải enemy0 và di chuyển sang trái
                if (enemies[0][0]< player[0]  && player[1]== enemies[0][1]&& enemies[0][0] + speed_enemies[0][0] > player[0] + dx ){
                    player[0] = enemies[0][0];
                    pass = true;
                }
            }
            // player đứng dưới enemy1 và di chuyển lên trên
            else if (dy <0){
                if ( enemies[1][1]< player[0] && player[0]== enemies[1][0]&& enemies[1][1] + speed_enemies[1][1] > player[1] + dy ){
                    player[1] = enemies[1][1];
                    pass = true;
                }
            }

            if(!pass) {
                // di chuyển các nhân vật
                move_char(player,dx,dy,map_size);
                move_char(enemies[0],speed_enemies[0][0],speed_enemies[0][1],map_size); // enemy 0 di tu trai sang phai, enemy 1 di tu tren xuong duoi
                move_char(enemies[1],speed_enemies[1][0],speed_enemies[1][1],map_size);
            }


        }
    }

    // hàm di chuyển các nhân vật
    public static void move_char(int[] character, int dx, int dy, int map_length) {
        int moved_x = character[0] +dx;
        int  moved_y = character[1] +dy;
        if( moved_x >= map_length ){
            character[0] =0;
        }
        else if (moved_x < 0){
            character[0] = map_length -1;
        }
        else if (moved_y <0){
            character[1] = map_length -1;
        }
        else if (moved_y >= map_length ){
            character[1] = 0;
        }
        else{
            character[0] = moved_x;
            character[1] = moved_y;
        }
    }
}
