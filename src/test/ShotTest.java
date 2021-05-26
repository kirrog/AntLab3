import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShotTest {

    private double questionR[] = new double[]{1, 1.5, 2, 2.5, 3};

    private double questionXAxes[] = new double[]{0, 0, 0, 0, 0, 0, 0, 0.5, 1, 1.5, -0.5, -1, -1.5};
    private double questionYAxes[] = new double[]{0, 0.5, 1, 1.5, -0.5, -1, -1.5, 0, 0, 0, 0, 0, 0};

    private boolean answerAxes[] = new boolean[]{true, true, true, false, true, true, false, true, true, false, true, true, false};

    @Test
    void checkAxes() {
        boolean resultAnswer[] = new boolean[answerAxes.length];
        for (int j = 0; j < questionR.length; j++) {
            for (int i = 0; i < answerAxes.length; i++) {
                resultAnswer[i] = Shot.check(questionXAxes[i] * questionR[j], questionYAxes[i] * questionR[j], questionR[j]);
            }
            assertArrayEquals(answerAxes, resultAnswer);
        }
    }

    private double questionXCircle[] = new double[]{0.5, 0.5, 1, 1, 0.71, 0.5, 0.8660254};
    private double questionYCircle[] = new double[]{0.5, 1, 0.5, 1, 0.71, 0.8660254, 0.5};

    private boolean answerCircle[] = new boolean[]{true, false, false, false, false, true, true};

    @Test
    void checkCircle() {
        boolean resultAnswer[] = new boolean[answerCircle.length];
        for (int j = 0; j < questionR.length; j++) {
            for (int i = 0; i < answerCircle.length; i++) {
                resultAnswer[i] = Shot.check(questionXCircle[i] * questionR[j], questionYCircle[i] * questionR[j], questionR[j]);
            }
            assertArrayEquals(answerCircle, resultAnswer);
        }
    }

    private double questionXTriangle[] = new double[]{0.5, 0.5, 1, 1, 0.75, 0.25};
    private double questionYTriangle[] = new double[]{-0.5, -1, -0.5, -1, -0.25, -0.75};

    private boolean answerTriangle[] = new boolean[]{true, false, false, false, true, true};

    @Test
    void checkTriangle() {
        boolean resultAnswer[] = new boolean[answerTriangle.length];
        for (int j = 0; j < questionR.length; j++) {
            for (int i = 0; i < answerTriangle.length; i++) {
                resultAnswer[i] = Shot.check(questionXTriangle[i] * questionR[j], questionYTriangle[i] * questionR[j], questionR[j]);
            }
            assertArrayEquals(answerTriangle, resultAnswer);
        }
    }

    private double questionXSquare[] = new double[]{-0.5, -0.5, -1, -1};
    private double questionYSquare[] = new double[]{-0.5, -1, -0.5, -1};

    private boolean answerSquare[] = new boolean[]{true, true, true, true};

    @Test
    void checkSquare() {
        boolean resultAnswer[] = new boolean[answerSquare.length];
        for (int j = 0; j < questionR.length; j++) {
            for (int i = 0; i < answerSquare.length; i++) {
                resultAnswer[i] = Shot.check(questionXSquare[i] * questionR[j], questionYSquare[i] * questionR[j], questionR[j]);
            }
            assertArrayEquals(answerSquare, resultAnswer);
        }
    }

    private double questionXVoid[] = new double[]{-0.5, -0.5, -1, -1};
    private double questionYVoid[] = new double[]{0.5, 1, 0.5, 1};

    private boolean answerVoid[] = new boolean[]{false, false, false, false};

    @Test
    void checkVoid() {
        boolean resultAnswer[] = new boolean[answerVoid.length];
        for (int j = 0; j < questionR.length; j++) {
            for (int i = 0; i < answerVoid.length; i++) {
                resultAnswer[i] = Shot.check(questionXVoid[i] * questionR[j], questionYVoid[i] * questionR[j], questionR[j]);
            }
            assertArrayEquals(answerVoid, resultAnswer);
        }
    }

    private double questionXRand[] = new double[]{0.775, 0.961, 0.035, 0.313, 0.086, 0.082, 0.118, 0.811, 0.188, 0.156};
    private double questionYRand[] = new double[]{0.100, 0.158, 0.172, 0.420, 0.097, 0.449, 0.649, 0.289, 0.092, 0.602};

    private boolean answerRandPosPos[] = new boolean[]{true, true, true, true, true, true, true, true, true, true};
    private boolean answerRandNegPos[] = new boolean[]{false, false, false, false, false, false, false, false, false, false};
    private boolean answerRandPosNeg[] = new boolean[]{true, false, true, true, true, true, true, false, true, true};
    private boolean answerRandNegNeg[] = new boolean[]{true, true, true, true, true, true, true, true, true, true};

    @Test
    void checkRandPosPos() {
        boolean resultAnswer[] = new boolean[answerRandPosPos.length];
        for (int j = 0; j < questionR.length; j++) {
            for (int i = 0; i < answerRandPosPos.length; i++) {
                resultAnswer[i] = Shot.check(questionXRand[i] * questionR[j], questionYRand[i] * questionR[j], questionR[j]);
            }
            assertArrayEquals(answerRandPosPos, resultAnswer);
        }
    }

    @Test
    void checkRandNegPos() {
        boolean resultAnswer[] = new boolean[answerRandNegPos.length];
        for (int j = 0; j < questionR.length; j++) {
            for (int i = 0; i < answerRandNegPos.length; i++) {
                resultAnswer[i] = Shot.check(-questionXRand[i] * questionR[j], questionYRand[i] * questionR[j], questionR[j]);
            }
            assertArrayEquals(answerRandNegPos, resultAnswer);
        }
    }

    @Test
    void checkRandPosNeg() {
        boolean resultAnswer[] = new boolean[answerRandPosNeg.length];
        for (int j = 0; j < questionR.length; j++) {
            for (int i = 0; i < answerRandPosNeg.length; i++) {
                resultAnswer[i] = Shot.check(questionXRand[i] * questionR[j], -questionYRand[i] * questionR[j], questionR[j]);
            }
            assertArrayEquals(answerRandPosNeg, resultAnswer);
        }
    }

    @Test
    void checkRandNegNeg() {
        boolean resultAnswer[] = new boolean[answerRandNegNeg.length];
        for (int j = 0; j < questionR.length; j++) {
            for (int i = 0; i < answerRandNegNeg.length; i++) {
                resultAnswer[i] = Shot.check(-questionXRand[i] * questionR[j], -questionYRand[i] * questionR[j], questionR[j]);
            }
            assertArrayEquals(answerRandNegNeg, resultAnswer);
        }
    }

}