

import java.util.LinkedList;

public class ShotsStorage {

    private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ShotsStorage.class);

    private LinkedList<Shot> shotMapList = new LinkedList<>();

    public boolean addShot(Shot shot) {
        shotMapList.add(shot);
        return true;
    }

    public Shot[] getShots() {
        return (Shot[])shotMapList.toArray();
    }

}
