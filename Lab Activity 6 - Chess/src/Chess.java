/*
 * Name: Jay Michael T. Carlos
 * File: Chess.java
 * ------------------
 * This program plays the game Chess.
 */

import java.awt.Color;
import java.awt.event.*;

/** The main class responsible for managing the chess game */
public class Chess extends GraphicsProgram implements MouseListener {

	/** Object responsible for handling the graphical display on the screen */
	ChessDisplay display;

	/** Object that keeps track of the locations of all pieces */
	ChessBoard board;

	/** Method called before run responsible for initializing the ChessDisplay and
	 *  ChessBoard objects */
	public void init()
	{
		display = ChessDisplay.getInstance(this);			// This line is required, don't change it
		board = new ChessBoard();
		addMouseListeners();

		display.useRealChessLabels(false);			// Use this method to change how the board is labeled
															// on the screen. Passing in true will label the board
															// like an official chessboard; passing in false will
															// label the board like it is indexed in an array and
															// in ChessDisplay.
	}

	/** The main method that runs the program */
	public void run()
	{
		// You fill this in.
		display.draw(board);
	}

	ChessPiece piece = null;
	int moveCount = 0;
	int currentTurnColor = 0;
	boolean pieceHasMoved = false;

	public void mousePressed(MouseEvent event){
		// DISABLE MOUSE ON GAME END
		if (isInCheckMate(board, 0)) {
			ChessDisplay.println("Black is in checkmate. Game over.");
			return;
		} else if (isInCheckMate(board, 1)) {
			ChessDisplay.println("White is in checkmate. Game over.");
			return;
		} else if (isInStalemate(board, 0) || isInStalemate(board, 1)) {
			ChessDisplay.println("Stalemate. Game over.");
			return;
		}

		// GET LOCATION OF MOUSE CLICK
		int[] location = display.getLocation(event.getX(),event.getY());
		int x = location[0];
		int y = location[1];

		if (moveCount % 2 == 0)
			currentTurnColor = 1;
		else
			currentTurnColor = 0;

		ChessPiece selection = board.pieceAt(x,y);

		if (selection == null && piece == null){ // SELECT EMPTY
			display.unselectAll();
		} else if (selection != null && piece == null && selection.color == currentTurnColor) { // SELECT PIECE
			piece = selection;
			display.selectSquare(selection.row,selection.col,Color.BLUE);
		} else if (piece != null) { // SELECT EMPTY WHILE HOLDING PIECE
			movePiece(x, y, piece);
			piece = null;
			display.unselectAll();
		}

		// DETERMINE IF PIECE IS MOVED
		if (pieceHasMoved) {
			moveCount++;
			pieceHasMoved = false;
			if (isInCheck(board,0)) {
				ChessDisplay.println("Black is in check.");
			} else if (isInCheck(board, 1)) {
				ChessDisplay.println("White is in check.");
			}
		}

		// UPDATE GRAPHICS
		display.draw(board);
	}
	public void movePiece(int x, int y, ChessPiece piece){
		// ONLY MOVE IF LEGAL & WILL NOT CAUSE CHECK
		if (piece.canMoveTo(x,y,board) && !piece.moveWouldCauseCheck(x,y,board)){
			// PRINT MOVEMENT
			if (piece.getColor() == 0) {
				ChessDisplay.println("Black " + piece.getType() + " moved from (" + piece.row + "," + piece.col + ") to (" + x + "," + y + ").");
			} else {
				ChessDisplay.println("White "+ piece.getType() + " moved from (" + piece.row + "," + piece.col + ") to (" + x + "," + y + ").");
			}

			// ACTUALLY MOVE THE PIECE
			pieceHasMoved = true;
			board.removePiece(piece.row,piece.col);
			piece.moveTo(x,y);
			board.addPiece(piece);
		}
	}
}