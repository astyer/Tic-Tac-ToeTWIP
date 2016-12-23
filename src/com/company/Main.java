package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        char board[][] = {{'_','_','_'}, {'_','_','_'}, {'_','_','_'}};

        int pxrow;
        int pxcolumn;
        int porow;
        int pocolumn;

        System.out.println("Welcome to Tic-Tac-Toe!");
        while(true)
        {
            System.out.println("Choose a game mode number:");
            System.out.println("1. Player vs. Player");
            System.out.println("2. Player vs. Computer");
            System.out.println("3. Computer vs. Computer");
            int mode = input.nextInt();

            if(mode == 1)
            {
                System.out.println("To choose a location to play first enter the row number and then enter the column number");
                System.out.println("The numbers correspond to the locations on the board as follows:");
                System.out.println("(1,1)(1,2)(1,3)");
                System.out.println("(2,1)(2,2)(2,3)");
                System.out.println("(3,1)(3,2)(3,3)");

                printboard(board);

                while(true)
                {
                    while(true)
                    {
                        System.out.println("Player X, enter the row you want to play in:");
                        pxrow = (input.nextInt()) - 1;
                        System.out.println("Player X, enter the column you want to play in:");
                        pxcolumn = (input.nextInt()) - 1;
                        if(board[pxrow][pxcolumn] != 'X' && board[pxrow][pxcolumn] != 'O')
                        {
                            board[pxrow][pxcolumn] = 'X';
                            break;
                        }
                        System.out.println("That spot is already filled, try again");
                    }

                    printboard(board);

                    if(xcheckwin(board))
                    {
                        System.out.println("Player X wins!");
                        break;
                    }

                    else if(checktie(board))
                    {
                        System.out.println("Tie Game!");
                        break;
                    }

                    while(true)
                    {
                        System.out.println("Player O, enter the row you want to play in:");
                        porow = (input.nextInt()) - 1;
                        System.out.println("Player O, enter the column you want to play in:");
                        pocolumn = (input.nextInt()) - 1;
                        if (board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                        {
                            board[porow][pocolumn] = 'O';
                            break;
                        }
                        System.out.println("That spot is already filled, try again");
                    }

                    printboard(board);

                    if(ocheckwin(board))
                    {
                        System.out.println("Player O wins!");
                        break;
                    }
                }
                clearboard(board);
            }

            if(mode == 2)
            {
                System.out.println("To choose a location to play first enter the row number and then enter the column number");
                System.out.println("The numbers correspond to the locations on the board as follows:");
                System.out.println("(1,1)(1,2)(1,3)");
                System.out.println("(2,1)(2,2)(2,3)");
                System.out.println("(3,1)(3,2)(3,3)");

                printboard(board);

                System.out.println("Computer plays as X");
                board[0][0] = 'X';

                printboard(board);

                while(true)
                {
                    System.out.println("Player, enter the row you want to play in:");
                    porow = (input.nextInt()) - 1;
                    System.out.println("Player, enter the column you want to play in:");
                    pocolumn = (input.nextInt()) - 1;
                    if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                    {
                        board[porow][pocolumn] = 'O';
                        break;
                    }
                    System.out.println("That spot is already filled, try again");
                }

                printboard(board);

                System.out.println("Computer's turn:");
                board = checkfinisher(board);
                if(xcheckwin(board))
                {
                    printboard(board);
                    System.out.println("Computer Wins!");
                }
                board = checkblock(board);
                if(board[0][2] == 'O' || board[0][1] == 'O')
                {
                    board[1][0] = 'X';
                    printboard(board);
                    while(true)
                    {
                        System.out.println("Player, enter the row you want to play in:");
                        porow = (input.nextInt()) - 1;
                        System.out.println("Player, enter the column you want to play in:");
                        pocolumn = (input.nextInt()) - 1;
                        if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                        {
                            board[porow][pocolumn] = 'O';
                            break;
                        }
                        System.out.println("That spot is already filled, try again");
                    }

                    printboard(board);

                    System.out.println("Computer's turn:");
                    board = checkfinisher(board);
                    if(xcheckwin(board))
                    {
                        printboard(board);
                        System.out.println("Computer Wins!");
                    }
                    board = checkblock(board);
                    if(board[2][0] == 'O')
                    {
                        board[1][1] = 'X';
                        printboard(board);
                        while(true)
                        {
                            System.out.println("Player, enter the row you want to play in:");
                            porow = (input.nextInt()) - 1;
                            System.out.println("Player, enter the column you want to play in:");
                            pocolumn = (input.nextInt()) - 1;
                            if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                            {
                                board[porow][pocolumn] = 'O';
                                break;
                            }
                            System.out.println("That spot is already filled, try again");
                        }

                        printboard(board);

                        System.out.println("Computer's turn:");
                        board = checkfinisher(board);
                        if(xcheckwin(board))
                        {
                            printboard(board);
                            System.out.println("Computer Wins!");
                        }
                    }
                }
                else if(board[1][0] == 'O')
                {
                    board[0][1] = 'X';
                    printboard(board);
                    while(true)
                    {
                        System.out.println("Player, enter the row you want to play in:");
                        porow = (input.nextInt()) - 1;
                        System.out.println("Player, enter the column you want to play in:");
                        pocolumn = (input.nextInt()) - 1;
                        if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                        {
                            board[porow][pocolumn] = 'O';
                            break;
                        }
                        System.out.println("That spot is already filled, try again");
                    }

                    printboard(board);

                    System.out.println("Computer's turn:");
                    board = checkfinisher(board);
                    if(xcheckwin(board))
                    {
                        printboard(board);
                        System.out.println("Computer Wins!");
                    }
                    board = checkblock(board);
                    if(board[0][2] == 'O')
                    {
                        board[1][1] = 'X';
                        printboard(board);
                        while(true)
                        {
                            System.out.println("Player, enter the row you want to play in:");
                            porow = (input.nextInt()) - 1;
                            System.out.println("Player, enter the column you want to play in:");
                            pocolumn = (input.nextInt()) - 1;
                            if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                            {
                                board[porow][pocolumn] = 'O';
                                break;
                            }
                            System.out.println("That spot is already filled, try again");
                        }

                        printboard(board);

                        System.out.println("Computer's turn:");
                        board = checkfinisher(board);
                        if(xcheckwin(board))
                        {
                            printboard(board);
                            System.out.println("Computer Wins!");
                        }
                    }
                }
                else if(board[1][1] == 'O')
                {
                    board[0][1] = 'X';
                    printboard(board);
                    while(true)
                    {
                        System.out.println("Player, enter the row you want to play in:");
                        porow = (input.nextInt()) - 1;
                        System.out.println("Player, enter the column you want to play in:");
                        pocolumn = (input.nextInt()) - 1;
                        if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                        {
                            board[porow][pocolumn] = 'O';
                            break;
                        }
                        System.out.println("That spot is already filled, try again");
                    }

                    printboard(board);

                    System.out.println("Computer's turn:");
                    board = checkfinisher(board);
                    if(xcheckwin(board))
                    {
                        printboard(board);
                        System.out.println("Computer Wins!");
                    }
                    board = checkblock(board);
                    printboard(board);

                    while(true)
                    {
                        System.out.println("Player, enter the row you want to play in:");
                        porow = (input.nextInt()) - 1;
                        System.out.println("Player, enter the column you want to play in:");
                        pocolumn = (input.nextInt()) - 1;
                        if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                        {
                            board[porow][pocolumn] = 'O';
                            break;
                        }
                        System.out.println("That spot is already filled, try again");
                    }

                    printboard(board);

                    System.out.println("Computer's turn:");
                    board = checkfinisher(board);
                    if(xcheckwin(board))
                    {
                        printboard(board);
                        System.out.println("Computer Wins!");
                    }
                    board = checkblock(board);
                    printboard(board);
                    while(true)
                    {
                        System.out.println("Player, enter the row you want to play in:");
                        porow = (input.nextInt()) - 1;
                        System.out.println("Player, enter the column you want to play in:");
                        pocolumn = (input.nextInt()) - 1;
                        if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                        {
                            board[porow][pocolumn] = 'O';
                            break;
                        }
                        System.out.println("That spot is already filled, try again");
                    }

                    printboard(board);

                    System.out.println("Computer's turn:");
                    board = checkfinisher(board);
                    if(xcheckwin(board))
                    {
                        printboard(board);
                        System.out.println("Computer Wins!");
                    }
                    board = checkblock(board);
                    if(board[2][1] == 'O')
                    {
                        board[2][2] = 'X';
                        if(checktie(board))
                        {
                            printboard(board);
                            System.out.println("Tie game!");
                        }
                    }
                    if(board[2][2] == 'O')
                    {
                        board[2][1] = 'X';
                        if(checktie(board))
                        {
                            printboard(board);
                            System.out.println("Tie game!");
                        }
                    }
                }
                else if(board[1][2] == 'O')
                {
                    board[1][1] = 'X';
                    printboard(board);
                    while(true)
                    {
                        System.out.println("Player, enter the row you want to play in:");
                        porow = (input.nextInt()) - 1;
                        System.out.println("Player, enter the column you want to play in:");
                        pocolumn = (input.nextInt()) - 1;
                        if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                        {
                            board[porow][pocolumn] = 'O';
                            break;
                        }
                        System.out.println("That spot is already filled, try again");
                    }

                    printboard(board);

                    System.out.println("Computer's turn:");
                    board = checkfinisher(board);
                    if(xcheckwin(board))
                    {
                        printboard(board);
                        System.out.println("Computer Wins!");
                    }
                    board = checkblock(board);
                    if(board[2][2] == 'O')
                    {
                        board[0][2] = 'X';
                        printboard(board);
                        while(true)
                        {
                            System.out.println("Player, enter the row you want to play in:");
                            porow = (input.nextInt()) - 1;
                            System.out.println("Player, enter the column you want to play in:");
                            pocolumn = (input.nextInt()) - 1;
                            if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                            {
                                board[porow][pocolumn] = 'O';
                                break;
                            }
                            System.out.println("That spot is already filled, try again");
                        }

                        printboard(board);

                        System.out.println("Computer's turn:");
                        board = checkfinisher(board);
                        if(xcheckwin(board))
                        {
                            printboard(board);
                            System.out.println("Computer Wins!");
                        }
                    }
                }
                else if(board[2][0] == 'O')
                {
                    board[0][1] = 'X';
                    printboard(board);
                    while(true)
                    {
                        System.out.println("Player, enter the row you want to play in:");
                        porow = (input.nextInt()) - 1;
                        System.out.println("Player, enter the column you want to play in:");
                        pocolumn = (input.nextInt()) - 1;
                        if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                        {
                            board[porow][pocolumn] = 'O';
                            break;
                        }
                        System.out.println("That spot is already filled, try again");
                    }

                    printboard(board);

                    System.out.println("Computer's turn:");
                    board = checkfinisher(board);
                    if(xcheckwin(board))
                    {
                        printboard(board);
                        System.out.println("Computer Wins!");
                    }
                    board = checkblock(board);
                    if(board[0][2] == 'O')
                    {
                        board[1][1] = 'X';
                        printboard(board);
                        while(true)
                        {
                            System.out.println("Player, enter the row you want to play in:");
                            porow = (input.nextInt()) - 1;
                            System.out.println("Player, enter the column you want to play in:");
                            pocolumn = (input.nextInt()) - 1;
                            if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                            {
                                board[porow][pocolumn] = 'O';
                                break;
                            }
                            System.out.println("That spot is already filled, try again");
                        }

                        printboard(board);

                        System.out.println("Computer's turn:");
                        board = checkfinisher(board);
                        if(xcheckwin(board))
                        {
                            printboard(board);
                            System.out.println("Computer Wins!");
                        }
                    }
                }
                else if(board[2][1] == 'O')
                {
                    board[0][2] = 'X';
                    printboard(board);
                    while(true)
                    {
                        System.out.println("Player, enter the row you want to play in:");
                        porow = (input.nextInt()) - 1;
                        System.out.println("Player, enter the column you want to play in:");
                        pocolumn = (input.nextInt()) - 1;
                        if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                        {
                            board[porow][pocolumn] = 'O';
                            break;
                        }
                        System.out.println("That spot is already filled, try again");
                    }

                    printboard(board);

                    System.out.println("Computer's turn:");
                    board = checkfinisher(board);
                    if(xcheckwin(board))
                    {
                        printboard(board);
                        System.out.println("Computer Wins!");
                    }
                    board = checkblock(board);
                    if(board[0][1] == 'O')
                    {
                        board[1][1] = 'X';
                        printboard(board);
                        while(true)
                        {
                            System.out.println("Player, enter the row you want to play in:");
                            porow = (input.nextInt()) - 1;
                            System.out.println("Player, enter the column you want to play in:");
                            pocolumn = (input.nextInt()) - 1;
                            if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                            {
                                board[porow][pocolumn] = 'O';
                                break;
                            }
                            System.out.println("That spot is already filled, try again");
                        }

                        printboard(board);

                        System.out.println("Computer's turn:");
                        board = checkfinisher(board);
                        if(xcheckwin(board))
                        {
                            printboard(board);
                            System.out.println("Computer Wins!");
                        }
                    }
                }
                else if(board[2][2] == 'O')
                {
                    board[0][2] = 'X';
                    printboard(board);
                    while(true)
                    {
                        System.out.println("Player, enter the row you want to play in:");
                        porow = (input.nextInt()) - 1;
                        System.out.println("Player, enter the column you want to play in:");
                        pocolumn = (input.nextInt()) - 1;
                        if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                        {
                            board[porow][pocolumn] = 'O';
                            break;
                        }
                        System.out.println("That spot is already filled, try again");
                    }

                    printboard(board);

                    System.out.println("Computer's turn:");
                    board = checkfinisher(board);
                    if(xcheckwin(board))
                    {
                        printboard(board);
                        System.out.println("Computer Wins!");
                    }
                    board = checkblock(board);
                    if(board[0][1] == 'O')
                    {
                        board[2][0] = 'X';
                        printboard(board);
                        while(true)
                        {
                            System.out.println("Player, enter the row you want to play in:");
                            porow = (input.nextInt()) - 1;
                            System.out.println("Player, enter the column you want to play in:");
                            pocolumn = (input.nextInt()) - 1;
                            if(board[porow][pocolumn] != 'X' && board[porow][pocolumn] != 'O')
                            {
                                board[porow][pocolumn] = 'O';
                                break;
                            }
                            System.out.println("That spot is already filled, try again");
                        }

                        printboard(board);

                        System.out.println("Computer's turn:");
                        board = checkfinisher(board);
                        if(xcheckwin(board))
                        {
                            printboard(board);
                            System.out.println("Computer Wins!");
                        }
                    }
                }
                clearboard(board);
            }
            if(mode == 3)
            {
                printboard(board);

                System.out.println("Computer 1's turn:");
                board[0][0] = 'X';
                printboard(board);

                System.out.println("Computer 2's turn:");
                board[1][1] = 'O';
                printboard(board);

                System.out.println("Computer 1's turn:");
                board[0][1] = 'X';
                printboard(board);

                System.out.println("Computer 2's turn:");
                board[0][2] = 'O';
                printboard(board);

                System.out.println("Computer 1's turn:");
                board[2][0] = 'X';
                printboard(board);

                System.out.println("Computer 2's turn:");
                board[1][0] = 'O';
                printboard(board);

                System.out.println("Computer 1's turn:");
                board[1][2] = 'X';
                printboard(board);

                System.out.println("Computer 2's turn:");
                board[2][1] = 'O';
                printboard(board);

                System.out.println("Computer 1's turn:");
                board[2][2] = 'X';
                printboard(board);
                System.out.println("Tie game!");

                clearboard(board);
            }
            System.out.println("Would you like to play again? (input yes or no)");
            String repeat = input2.nextLine();
            if(!repeat.equalsIgnoreCase("yes"))
            {
                System.out.println("Thanks for playing!");
                break;
            }
        }
    }

    private static boolean xcheckwin(char board[][])
    {
        if(board[0][0]=='X' && board[0][1]=='X' && board[0][2]=='X'||
                board[1][0]=='X' && board[1][1]=='X' && board[1][2]=='X'||
                board[2][0]=='X' && board[2][1]=='X' && board[2][2]=='X'||
                board[0][0]=='X' && board[1][0]=='X' && board[2][0]=='X'||
                board[0][1]=='X' && board[1][1]=='X' && board[2][1]=='X'||
                board[0][2]=='X' && board[1][2]=='X' && board[2][2]=='X'||
                board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X'||
                board[2][0]=='X' && board[1][1]=='X' && board[0][2]=='X')
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    private static boolean ocheckwin(char board[][])
    {
        if(board[0][0]=='O' && board[0][1]=='O' && board[0][2]=='O'||
                board[1][0]=='O' && board[1][1]=='O' && board[1][2]=='O'||
                board[2][0]=='O' && board[2][1]=='O' && board[2][2]=='O'||
                board[0][0]=='O' && board[1][0]=='O' && board[2][0]=='O'||
                board[0][1]=='O' && board[1][1]=='O' && board[2][1]=='O'||
                board[0][2]=='O' && board[1][2]=='O' && board[2][2]=='O'||
                board[0][0]=='O' && board[1][1]=='O' && board[2][1]=='O'||
                board[2][0]=='O' && board[1][1]=='O' && board[0][2]=='O')
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    private static boolean checktie(char board[][])
    {
        if(board[0][0] !='_' &&
                board[0][1] !='_' &&
                board[0][2] !='_' &&
                board[0][2] !='_' &&
                board[1][0] !='_' &&
                board[1][1] !='_' &&
                board[2][0] !='_' &&
                board[2][1] !='_' &&
                board[2][2] !='_')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static void printboard(char board[][])
    {
        for(int row = 0; row < board.length; row++)
        {
            for (int column = 0; column < board[row].length; column++)
            {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }

    private static void clearboard(char board[][])
    {
        board[0][0] ='_';
        board[0][1] ='_';
        board[0][2] ='_';
        board[1][0] ='_';
        board[1][1] ='_';
        board[1][2] ='_';
        board[2][0] ='_';
        board[2][1] ='_';
        board[2][2] ='_';
    }

    private static char[][] checkblock(char board[][])
    {
        if(board[0][1] == 'O' && board[0][2] == 'O' && board[0][0] == '_')
            board[0][0] = 'X';
        else if((board[0][0] == 'O' && board[0][2] == 'O' && board[0][1] == '_')||(board[1][1] == 'O' && board[2][1] == 'O' && board[0][1] == '_'))
            board[0][1] = 'X';
        else if((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == '_')||(board[1][2] == 'O' && board[2][2] == 'O' && board[0][2] == '_')||(board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == '_'))
            board[0][2] = 'X';
        else if((board[0][0] == 'O' && board[2][0] == 'O' && board[1][0] == '_')||(board[1][1] == 'O' && board[1][2] == 'O' && board[1][0] == '_'))
            board[1][0] = 'X';
        else if((board[0][0] == 'O' && board[2][2] == 'O' && board[1][1] == '_')||(board[1][0] == 'O' && board[1][2] == 'O' && board[1][1] == '_')||(board[2][0] == 'O' && board[0][2] == 'O' && board[1][1] == '_')||(board[0][1] == 'O' && board[2][1] == 'O' && board[1][1] == '_'))
            board[1][1] = 'X';
        else if((board[0][2] == 'O' && board[2][2] == 'O' && board[1][2] == '_')||(board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == '_'))
            board[1][2] = 'X';
        else if((board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == '_')||(board[2][1] == 'O' && board[2][2] == 'O' && board[2][0] == '_')||(board[1][1] == 'O' && board[0][2] == 'O' && board[2][0] == '_'))
            board[2][0] = 'X';
        else if((board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == '_')||(board[2][0] == 'O' && board[2][2] == 'O' && board[2][1] == '_'))
            board[2][1] = 'X';
        else if((board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == '_')||(board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == '_')||(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == '_'))
            board[2][2] = 'X';
        return board;
    }

    private static char[][] checkfinisher(char board[][])
    {
        if(board[0][1] == 'X' && board[0][2] == 'X' && board[0][0] == '_')
            board[0][0] = 'X';
        else if((board[0][0] == 'X' && board[0][2] == 'X' && board[0][1] == '_')||(board[1][1] == 'X' && board[2][1] == 'X' && board[0][1] == '_'))
            board[0][1] = 'X';
        else if((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == '_')||(board[1][2] == 'X' && board[2][2] == 'X' && board[0][2] == '_')||(board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == '_'))
            board[0][2] = 'X';
        else if((board[0][0] == 'X' && board[2][0] == 'X' && board[1][0] == '_')||(board[1][1] == 'X' && board[1][2] == 'X' && board[1][0] == '_'))
            board[1][0] = 'X';
        else if((board[0][0] == 'X' && board[2][2] == 'X' && board[1][1] == '_')||(board[1][0] == 'X' && board[1][2] == 'X' && board[1][1] == '_')||(board[2][0] == 'X' && board[0][2] == 'X' && board[1][1] == '_')||(board[0][1] == 'X' && board[2][1] == 'X' && board[1][1] == '_'))
            board[1][1] = 'X';
        else if((board[0][2] == 'X' && board[2][2] == 'X' && board[1][2] == '_')||(board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == '_'))
            board[1][2] = 'X';
        else if((board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == '_')||(board[2][1] == 'X' && board[2][2] == 'X' && board[2][0] == '_')||(board[1][1] == 'X' && board[0][2] == 'X' && board[2][0] == '_'))
            board[2][0] = 'X';
        else if((board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == '_')||(board[2][0] == 'X' && board[2][2] == 'X' && board[2][1] == '_'))
            board[2][1] = 'X';
        else if((board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == '_')||(board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == '_')||(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == '_'))
            board[2][2] = 'X';
        return board;
    }
}












