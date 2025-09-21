import java.util.Arrays;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 * <p>
 * Completed by: Logan Tran
 */

public class HighwaysAndHospitals {

    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // If its more cost-effective for every city to have a hospital
        if (hospitalCost < highwayCost) {
            return (long) n * hospitalCost;
        }

        // Initialize variables
        int totalComponents = 0;
        int[] roots = new int[n + 1];
        Arrays.fill(roots, -1);

        // Find the root of each city
        for (int[] highway : cities) {
            // Initialize each city in highway
            int A = highway[0];
            int B = highway[1];

            // Find root of cities with Union search
            int x = getRoot(A, roots);
            int y = getRoot(B, roots);

            // Get order value of roots
            int orderValue1 = roots[x];
            int orderValue2 = roots[y];

            // If the roots are different
            if (x != y) {
                // If a root has a more advantages order (lower in this case)
                if (orderValue1 < orderValue2) {
                    // Change order value and root
                    roots[x] += roots[y] - 1;
                    roots[y] = x;
                }
                // Same as above but opposite case
                else {
                    roots[y] += roots[x] - 1;
                    roots[x] = y;
                }
            }
        }

        // Calculate number of components
        for (int i = 1; i < roots.length; i++) {
            if (roots[i] < 0) {
                totalComponents++;
            }
        }

        //return calculated cost of hospitals
        return (long) hospitalCost * totalComponents + (long) highwayCost * (n - totalComponents);
    }

    // Get the root of a node using union-find
    public static int getRoot(int x, int[] roots) {
        int root = x;

        // Find the top most root
        while (roots[root] > 0) {
            root = roots[root];
        }

        // Set all nodes' roots in between the original city to the topmost node (path compression)
        while (roots[root] > 0) {
            int temp = roots[root];
            roots[root] = root;
            root = temp;
        }
        return root;
    }
}
