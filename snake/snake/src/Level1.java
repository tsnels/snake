public class Level1 {

    static final int UNIT_SIZE = 25;

    int wallX[] = new int[]{
            UNIT_SIZE * 1, UNIT_SIZE * 2, UNIT_SIZE * 3, UNIT_SIZE * 4, UNIT_SIZE * 5, UNIT_SIZE * 6,
            UNIT_SIZE * 10, UNIT_SIZE * 11, UNIT_SIZE * 12, UNIT_SIZE * 13, UNIT_SIZE * 14, UNIT_SIZE * 15,
            UNIT_SIZE * 20, UNIT_SIZE * 21, UNIT_SIZE * 22, UNIT_SIZE * 23, UNIT_SIZE * 24, UNIT_SIZE * 25,
            UNIT_SIZE * 30, UNIT_SIZE * 31, UNIT_SIZE * 32, UNIT_SIZE * 33, UNIT_SIZE * 34, UNIT_SIZE * 35
    };
    //    int wallX2[] = new int[]{UNIT_SIZE * 17, UNIT_SIZE * 18, UNIT_SIZE * 19, UNIT_SIZE * 20, UNIT_SIZE * 21, UNIT_SIZE * 22};
    int wallY[] = new int[]{UNIT_SIZE * 10, UNIT_SIZE * 20};

    public int[] getWallX() {
        return wallX;
    }

    public int[] getWallY() {
        return wallY;
    }
}
