package question5;

import java.util.*;

class Storage {
    int id;
    Map<Storage, Double> connections;
    public Storage(int id) {
        this.id = id;
        this.connections = new HashMap<>();
    }

    public void addConnection(Storage storage, double probability) {
        connections.put(storage, probability);
    }
}





