package tictactoe;

public class Cell {
	public CellStatus Status;
	
	Cell() {
		this.Status = CellStatus.EMPTY;
	}
	
	public CellStatus getCellStatus() {
		return Status;
	}
	
	public void SetEmpty() { 
		this.Status = CellStatus.EMPTY;
	}
	
	public void SetO() { 
		this.Status = CellStatus.O;
	}
	
	public void SetX() { 
		this.Status = CellStatus.X;
	}
}
