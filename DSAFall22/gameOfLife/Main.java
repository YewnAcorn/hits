public class Main
{
        public static void main(String args[]) 
        {
                GameBoard board_a = new GameBoard();
                board_a.cellInit();

                for(int i = 1; i < board_a.getLength() - 1; ++i)
                {
                        for(int j = 1; j < board_a.getLength() - 1; ++j)
                        {
                                Cell o = new Cell();
                                o = board_a.getCell(i, j);
                                board_a.count(o);
                                o.setStatus();
                        }
                }

                GameBoard board_b = new GameBoard();

                for(int i = 1; i < board_b.getLength() - 1; ++i)
                {
                        for(int j = 1; j < board_b.getLength() - 1; ++j)
                        {
                                board_b.setCell(i, j, board_a.getCell(i, j));
                        }
                }

        }

}
