package tictactoe;

import java.util.Scanner;

public class GAME {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Board mainGame = new Board();
        boolean isXTurn = true;
        boolean quit = false;
        
        while (!quit) {
            if (mainGame.IsBoardFull()) {
            	quit = true;
            }
            else
            {
            	while (true) {
                    int x, y;
                    if (isXTurn) System.out.println("X turn");
                    else System.out.println("O turn");
                    mainGame.DisplayBoard();
                    System.out.print("Enter x, y: ");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    
                    if (mainGame.IsAValidMove(x, y)) {
                        mainGame.addNewMove(x, y, isXTurn);
                        mainGame.DisplayBoard();
                        break;
                    } 
                    else System.out.println("Re-enter the number!");
                }
                if (mainGame.CheckWin()) {
                	if (isXTurn) System.out.println("X Win!");
                    else System.out.println("O Win!");
                	quit = true;
                } 
                else {
                	if (mainGame.IsBoardFull()) {
                		System.out.println("Out of move!!");
                		System.out.println("No one wins");
                		quit = true;
                	}
                	
                	if (isXTurn) isXTurn = false;
                    else isXTurn = true;
                }

            }
        }
		
		scanner.close();
	}
}
