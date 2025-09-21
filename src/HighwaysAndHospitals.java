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
        if (hospitalCost < highwayCost) {
            return ((long) n * hospitalCost);
        }

        int totalComponents = 0;
        int[] roots = new int[n + 1];

        // Find the root of each city
        for (int[] highway: cities) {
            int root = highway[0];
            int x = highway[0];

            // Find the top most root
            while(x != 0) {
                x = roots[x];
            }
            // Set all nodes' roots in between the original city to the topmost node
            while(root != 0) {
                int temp = roots[root];
                roots[root] = x;
                root = temp;

            }
        }

        // Calculate number of components
        for(int i = 1; i < roots.length; i++) {
            if (roots[i] == 0) {
                totalComponents++;
            }
        }
        //return calculated cost of hospitals
        return (long) hospitalCost * totalComponents + (long) highwayCost * (n - totalComponents);
    }
}
