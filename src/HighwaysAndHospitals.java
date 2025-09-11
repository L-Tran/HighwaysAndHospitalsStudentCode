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
        int highways = 0;
        int hospitals = n;
        if (hospitalCost > highwayCost) {
            return n * hospitalCost;
        }
        // Every City starts with a hospital
        int total = n * hospitalCost;
        // Keep merging cities until cannot merge anymore
        for (int i = 0; i < cities.length; i++) {

        }





        return 0;
    }
}
