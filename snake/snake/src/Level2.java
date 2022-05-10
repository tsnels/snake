public class Level2 {


    static final int US = 25;

    int wallX[] = new int[]{
            US, US * 2, US * 3, US * 4, US * 5, US * 6, US * 7, US * 8, US * 9,
            US * 11, US * 12, US * 13, US * 14, US * 15, US * 16, US * 17, US * 18,
            US * 20, US * 21, US * 22, US * 23, US * 24, US * 25, US * 26, US *27,
            US *29, US *30, US *31, US *32, US *33, US *34, US *35, US *36, US *37,
            US *39, US *40, US *41, US *42, US *43, US *44, US *45, US *46, US *47
    };
    //    int wallX2[] = new int[]{UNIT_SIZE * 17, UNIT_SIZE * 18, UNIT_SIZE * 19, UNIT_SIZE * 20, UNIT_SIZE * 21, UNIT_SIZE * 22};
    int wallY[] = new int[]{US * 10, US * 20};

    public int[] getWallX() {
        return wallX;
    }

    public int[] getWallY() {
        return wallY;
    }

}
