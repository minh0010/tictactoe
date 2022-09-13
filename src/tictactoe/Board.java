package tictactoe;

public class Board {
	public Cell[][] mainboard= new Cell[3][3];
	
	Board() {
		for (int i = 0 ; i < 3 ; ++i) {
			for (int j = 0 ; j < 3 ; ++j) {
				mainboard[i][j] = new Cell();
			}
		}
		
		for (int i = 0 ; i < 3 ; ++i) {
			for (int j = 0 ; j < 3 ; ++j) {
				mainboard[i][j].SetEmpty();
			}
		}
	}
	
	public boolean IsBoardFull() {
		
		// duyet toan bo cac o choi
		for (int i = 0 ; i < 3 ; ++i) {
			for (int j = 0 ; j < 3 ; ++j) {
				
				// phat hien co o con trong tra lai ket qua
				if (mainboard[i][j].getCellStatus().equals(CellStatus.EMPTY)) {
					return false;
				}
			}
		}
		
		// toan bo cac o da duoc xep day
		return true;
	}
	
	public boolean CheckWin() {
		
		// kiem tra ngang, doc
		for (int i = 0; i < 3; i++) {
            int sumOfRows = 0;
            int sumOfColumn = 0;
            for (int j = 0; j < 3; j++) {
                if (mainboard[i][j].getCellStatus().equals(CellStatus.X)) sumOfRows += 1;
                if (mainboard[i][j].getCellStatus().equals(CellStatus.O)) sumOfRows -= 1;

                if (mainboard[j][i].getCellStatus().equals(CellStatus.X)) sumOfColumn += 1;
                if (mainboard[j][i].getCellStatus().equals(CellStatus.O)) sumOfColumn -= 1;
            }
            if (sumOfRows == 3 || sumOfRows == -3 || sumOfColumn == 3 || sumOfColumn == -3) {
                return true;
            }
        }

        //Kiem tra duong cheo
        int sumOfDiagonal_1 = 0; //duong cheo 1
        int sumOfDiagonal_2 = 0; //duong cheo 2
        for (int i = 0; i < 3; i++) {
            //Neu la X
            if (mainboard[i][i].getCellStatus().equals(CellStatus.X)) sumOfDiagonal_1 += 1;
            if (mainboard[i][3 - i - 1].getCellStatus().equals(CellStatus.X)) sumOfDiagonal_2 += 1;

            //Neu la O
            if (mainboard[i][i].getCellStatus().equals(CellStatus.O)) sumOfDiagonal_1 -= 1;
            if (mainboard[i][3 - i - 1].getCellStatus().equals(CellStatus.O)) sumOfDiagonal_2 -= 1;
        }
        if (sumOfDiagonal_1 == 3 || sumOfDiagonal_1 == -3 || sumOfDiagonal_2 == 3 || sumOfDiagonal_2 == -3) 
        	return true;
        
        return false;
	}
	
	public void addNewMove(int x, int y, boolean isXTurn) {
		// luot cua X
		if (isXTurn) {
			mainboard[x][y].SetX();
		}
		// luot cua O
		else {
			mainboard[x][y].SetO();
		}
	}
	
	public boolean IsAValidMove(int x, int y) {
		// toa do x y khong phu hop voi kich thuoc mang 
		if (x < 0 || x >= 3 || y < 0 || y >= 3) {
			return false;
		}
		
		// vi tri da duoc su dung hay chua
		return (mainboard[x][y].getCellStatus().equals(CellStatus.EMPTY)) ? true : false;
	}
	
	public void DisplayBoard() {
		for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (mainboard[i][j].getCellStatus().equals(CellStatus.X)) System.out.print("[X]");
                else if (mainboard[i][j].getCellStatus().equals(CellStatus.O)) System.out.print("[O]");
                else System.out.print("[ ]");
            }
            System.out.println();
        }
        System.out.println("----------");
	}
}
