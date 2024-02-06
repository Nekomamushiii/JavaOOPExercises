package mlc.advanced.examprep1;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        char[][] board = new char[n][n];
        int posX = -1;
        int posY = -1;
        for(int i = 0; i < n ; i ++) {
            String row = scanner.nextLine();
            int j = 0;
            for(char ch : row.toCharArray()) {
                if(ch == 'f') {
                    posX = i;
                    posY = j;
                }
                board[i][j++] = ch;
            }
        }
        for(; c > 0; c--) {
            String command = scanner.nextLine();
            int newX = posX;
            int newY = posY;
            switch(command) {
                case "up":
                    newX = up(board, posX, posY, n);
                    break;
                case "down":
                    newX = down(board, posX, posY, n);
                    break;
                case "right":
                    newY = right(board, posX, posY, n);
                    break;
                case "left":
                    newY = left(board, posX, posY, n);
                    break;
                default: break;
            }
            if(board[newX][newY] != 'F') {
                board[posX][posY] = '-';
                board[newX][newY] = 'f';
                posX = newX;
                posY = newY;
            } else {
                if(board[posX][posY] != 'B')
                    board[posX][posY] = '-';
                board[newX][newY] = 'f';
                break;
            }
        }
        if(c == 0)
            System.out.println("Player lost!");
        else
            System.out.println("Player won!");

        for(int i = 0 ; i < n; i ++) {
            for(int j = 0; j < n; j ++)
                System.out.print(board[i][j]);
            System.out.println();
        }
    }

    public static int left(char[][] arr, int x, int y, int n) {
        y--;
        if(y < 0)
            y = n -1;
        if (arr[x][y] == 'T')
            y++;
        else if(arr[x][y] == 'B')
            y--;
        if(y < 0)
            y = n -1;
        if(y >= n)
            y = 0;
        return y;
    }

    public static int right(char[][] arr, int x, int y, int n) {
        y++;
        if(y >= n)
            y = 0;
        if (arr[x][y] == 'T')
            y--;
        else if(arr[x][y] == 'B') {
            System.err.println("hehre" + x + y);
            y++;
        }

        if(y < 0)
            y = n -1;
        if(y >= n)
            y = 0;
        return y;
    }

    public static int down(char[][] arr, int x, int y, int n) {
        x++;
        if(x >= n)
            x = 0;
        if (arr[x][y] == 'T')
            x--;
        else if(arr[x][y] == 'B')
            x++;
        if(x < 0)
            x = n -1;
        if(x >= n)
            x = 0;
        return x;
    }

    public static int up(char[][] arr, int x, int y, int n) {
        x--;
        if(x < 0)
            x = n -1;
        if (arr[x][y] == 'T')
            x++;
        else if(arr[x][y] == 'B')
            x--;
        if(x < 0)
            x = n -1;
        if(x >= n)
            x = 0;
        return x;
    }
}
