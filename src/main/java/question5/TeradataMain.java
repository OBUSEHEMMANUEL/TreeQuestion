package question5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TeradataMain {
    public static void main(String[] args) {
        Teradata teradata = new Teradata();
        try {
            BufferedReader br = new BufferedReader(new FileReader("teradata-world-setup.txt"));
            int n = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < n; i++) {
                teradata.addStorage(new Storage(i + 1));
            }

            for (int i = 0; i < n - 1; i++) {
                String[] parts = br.readLine().trim().split(",");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                double p = Double.parseDouble(parts[2]) / 100.0;

                Storage storageU = teradata.getStorage(u);
                Storage storageV = teradata.getStorage(v);
                storageU.addConnection(storageV, p);
                storageV.addConnection(storageU, p);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String clientRequestFile = "client-request-1.txt";


            processClientRequest(clientRequestFile, teradata);

    }

    private static void processClientRequest(String filename, Teradata teradata) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            PrintWriter pw = new PrintWriter(filename.replace("request", "response"));

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.equals("END")) {
                    break;
                }

                String[] parts = line.split(",");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                double q = Double.parseDouble(parts[2]);

                Storage source = teradata.getStorage(a);
                Storage destination = teradata.getStorage(b);

                boolean result = teradata.canTransmitPacket(source, destination, q);
                pw.println(result ? "YES" : "NO");
            }

            br.close();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}