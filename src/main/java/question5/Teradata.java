package question5;

import java.util.*;

class Teradata {
    private List<Storage> storages;

    public Teradata() {
        storages = new ArrayList<>();
    }

    public void addStorage(Storage storage) {
        storages.add(storage);
    }

    public Storage getStorage(int id) {
        return storages.get(id - 1);
    }

    public boolean canTransmitPacket(Storage source, Storage destination, double threshold) {
        Set<Storage> visited = new HashSet<>();
        return dfs(source, destination, threshold, visited);
    }

    private boolean dfs(Storage current, Storage destination, double threshold, Set<Storage> visited) {
        if (current == destination) {
            return true;
        }

        visited.add(current);
        for (Map.Entry<Storage, Double> entry : current.connections.entrySet()) {
            Storage neighbor = entry.getKey();
            double probability = entry.getValue();
            if (!visited.contains(neighbor) && probability >= threshold) {
                if (dfs(neighbor, destination, threshold, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}