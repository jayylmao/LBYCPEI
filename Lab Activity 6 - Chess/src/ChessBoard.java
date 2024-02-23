/*
 * Name:
 * Section Leader:
 * File: ChessBoard.java
 * ------------------
 * This class represents the ChessBoard. Its job is to keep track of where all
 * of the pieces are. Since we just learned about two-dimensional arrays, it 
 * might be a good idea to use one here (just a hint). Currently, it doesn't do 
 * anything, but it does have four methods for you to fill in. These are the only
 * required methods in this class. As long as these work, feel free to do whatever
 * else you want to get this class working.
 */

public class ChessBoard extends DrawableObject{

	/** Constant that sets the size of the chess board */
	public static final int BOARD_SIZE = 8;

	// The constructor will need to initialize whatever data structure you’re going
	// to use to store the ChessPieces and their locations.
	private ChessPiece[][] board;

	// The job of the constructor would be to initialize this Array to all nulls,
	// as initially, there aren't any pieces on the board.
	
	/** Constructor for the ChessBoard class (do whatever you want with this) */
	public ChessBoard()
	{
		// You fill this in.
		board = new ChessPiece[BOARD_SIZE][BOARD_SIZE];

		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = null;
			}
		}

		// Note: In Java, each class variable, instance variable, or array component is
		//initialized with a default value when it is created
		//For all reference types, the default value is null.

		for (int i = 0; i < BOARD_SIZE; i++) {
			addPiece(new Pawn(1, i, ChessPiece.BLACK));
			addPiece(new Pawn(6, i, ChessPiece.WHITE));
		}

		addPiece(new King(0, 4, ChessPiece.BLACK));
		addPiece(new King(7, 4, ChessPiece.WHITE));

		addPiece(new Queen(0, 3, ChessPiece.BLACK));
		addPiece(new Queen(7, 3, ChessPiece.WHITE));

		addPiece(new Bishop(0, 2, ChessPiece.BLACK));
		addPiece(new Bishop(0, 5, ChessPiece.BLACK));

		addPiece(new Bishop(7, 2, ChessPiece.WHITE));
		addPiece(new Bishop(7, 5, ChessPiece.WHITE));

		addPiece(new Knight(0, 1, ChessPiece.BLACK));
		addPiece(new Knight(0, 6, ChessPiece.BLACK));

		addPiece(new Knight(7, 1, ChessPiece.WHITE));
		addPiece(new Knight(7, 6, ChessPiece.WHITE));

		addPiece(new Rook(0, 0, ChessPiece.BLACK));
		addPiece(new Rook(0, 7, ChessPiece.BLACK));

		addPiece(new Rook(7, 0, ChessPiece.WHITE));
		addPiece(new Rook(7, 7, ChessPiece.WHITE));
	}
	
	/** Returns the ChessPiece currently residing at the specified row and 
	 * column. If no piece exists at the specified location, should return 
	 * null.
	 */
	public ChessPiece pieceAt(int row, int col)
	{
		if (isValidPosition(row, col)) return board[row][col];
		else return null;
	}
	
	/** Adds the specified ChessPiece to the ChessBoard (hint: ChessPieces know their
	 * own rows and columns. You can use this to figure out where to place the piece)
	 */
	public void addPiece(ChessPiece piece)
	{
		// If the user attempts to add a piece to a location where one already exists,
		// addPiece should overwrite the old piece with the new one.

		if (isValidPosition(piece.getRow(), piece.getCol())) board[piece.getRow()][piece.getCol()] = piece;
	}
	
	/** Removes the piece at the specified location from the board.
	 */
	public void removePiece(int row, int col)
	{
		if (isValidPosition(row, col)) board[row][col] = null;
	}

	// checks if a given position is valid for a piece to move to.
	private boolean isValidPosition(int row, int col) { return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE; }
}
