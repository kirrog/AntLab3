import java.io.Serializable;
import java.time.LocalDateTime;


public class Shot implements Serializable {

    private double x;
    private double y;
    private double r;

    private boolean Hit;

    private LocalDateTime start;
    private long scriptTime;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean isHit() {
        return Hit;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public long getScriptTime() {
        return scriptTime;
    }

    public Shot(double xIn, double yIn, double rIn, boolean grIn, LocalDateTime startIn, long scriptTimeIn) {
        x = xIn;
        y = yIn;
        r = rIn;
        Hit = grIn;
        start = startIn;
        scriptTime = scriptTimeIn;
    }

    public Shot(double xIn, double yIn, double rIn) {
        x = xIn;
        y = yIn;
        r = rIn;
        calculateShot();
    }

    public void calculateShot() {
        start = LocalDateTime.now();
        scriptTime = System.nanoTime();
        Hit = check(x, y, r);
        scriptTime = System.nanoTime() - scriptTime;
    }

    public static boolean check(double x, double y, double r) {
        if ((y == 0 && Math.abs(x) <= r) || (x == 0 && Math.abs(y) <= r)) {
            return true;
        }
        if (y > 0) {
            if (x > 0) {
                return (x * x + y * y <= r * r);
            } else {
                return false;
            }
        } else {
            if (x > 0) {
                return ((x + (-y)) <= r);
            } else {
                return ((-x <= r) && (-y <= r));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("X: ");
        stringBuilder.append(this.getX());
        stringBuilder.append(" Y: ");
        stringBuilder.append(this.getY());
        stringBuilder.append(" R: ");
        stringBuilder.append(this.getR());
        stringBuilder.append("\nHit: ");
        stringBuilder.append(this.isHit());
        stringBuilder.append(" Start: ");
        stringBuilder.append(this.getStart());
        stringBuilder.append(" Time: ");
        stringBuilder.append(this.getScriptTime());
        return stringBuilder.toString();
    }
}
