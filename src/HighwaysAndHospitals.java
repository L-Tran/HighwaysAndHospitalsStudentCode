import java.util.Arrays;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Logan Tran
 *
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // If its more cost-effective for every city to have a hospital
        if (hospitalCost > highwayCost) {
            return (long) n * hospitalCost;
        }

        int totalComponents = 0;
        int[] components = new int[n + 1];
        for (int i = 1; i < components.length; i++) {
            components[i] = i;
        }

        // Find the root of each city
        for (int i = 0; i < cities.length; i++) {
            // Change cities root
            int root = cities[i][0];
            while (components[root] != root) {
                root = components[root];
            }
            int city = cities[i][1];
            components[city] = root;
        }

        // Calculate number of components
        for(int x: components) {
            if (x == -1) {
                totalComponents++;
            }
        }
        //return calculated cost of hospitals
        return (long) hospitalCost * totalComponents + (long) highwayCost * (n - totalComponents);
    }
}
