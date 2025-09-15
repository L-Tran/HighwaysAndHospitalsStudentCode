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
            return n * hospitalCost;
        }
        // Every City starts with a hospital
        int total = n * hospitalCost;
        // Keep track of if a city has a hospital
        boolean[] hasHospital = new boolean[n];
        for (boolean b: hasHospital) {
            b = true;
        }
        // Keep merging cities until cannot merge anymore
        for (int i = 0; i < cities.length; i++) {
            int city1 = cities[i][0];
            int city2 = cities[i][1];
            // If they both have a hospital connected them
            if (hasHospital[city1] && hasHospital[city2]) {
                total += highwayCost - hospitalCost;
                hasHospital[city1] = false;
            }
        }
        return total;
    }
}
