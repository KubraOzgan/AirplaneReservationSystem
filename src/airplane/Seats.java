package airplane;

public class Seats {
	
	private int row, column;
	private char seats[][];
	
	public Seats(int row, int column) {
		this.row = row;
		this.column = column;
		this.createSeats(row, column);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public boolean taken() {
		return false;
	}

	public char getSeats(int row, char column) {
		int num = findSeatNum(row-1, column);
		//System.out.println(num);
		//return seats[row-1][column-1];
		return seats[row-1][num];
	}
	
	public char getSeats(int row, int column) {
		
		return seats[row-1][column];
	}

	public void setSeats(char seats[][]) {
		this.seats = seats;
	}
	
	public void createSeats(int row, int column) {
		this.seats = new char[row][column];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				seats[i][j] = (char)(j+65);
			}
		}
	}
	
	public void printSeats() {
		for(int i=0; i<row; i++) {
			System.out.print((i+1) + "- ");
			for(int j=0; j<column; j++) {
				System.out.print(seats[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void selectSeat(int row, char column) {
		
		//int num = findSeatNum(row-1, column);
		
		//this.seats[row-1][column-1] = 'X';
		int num = findSeatNum(row-1, column);
		
		this.seats[row-1][num] = 'X';
	}
	
	public int findSeatNum(int row, char column) {
		/*int num = -1;
		for(int i=0; i<seats[0].length; i++) {
			if(compareChars(column, seats[row][i])) {
				num = i;
				break;
			}
		}
		return num;*/
		
		int num = -1;
		for(int i=0; i<seats[0].length; i++) {
			if(compareChars(column, seats[row][i]) || seats[row][i] == 'X') {
				num = i;
			}
		}
		return num;
		
		
	}
	
	public static boolean compareChars(char c1, char c2){
		c1 = Character.toUpperCase(c1);
		c2 = Character.toUpperCase(c2);
		
        int comp = Character.compare(c1, c2);
        if(comp == 0){
            return true;
        }
		return false;
	}
	
	public void printSeatInfo() {
		String str = null;
		str = Character.toString((char)this.getColumn());
		System.out.println("Seat: " + this.getRow() + " " + str);
	}
}
