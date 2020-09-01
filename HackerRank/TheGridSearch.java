public class TheGridSearch {

    static boolean checkLines(String[] G, String [] P, int L, int C) {
        if (L + P.length > G.length) return false;
        if (C + P[0].length() > G[0].length()) return false;

        for (int l = L; l < L + P.length; l++) {
            for (int c = C; c < C + P[0].length(); c++) {
                if (G[l].charAt(c) != P[l - L].charAt(c - C)) {
                    return false;
                }
            }
        }
        return true;
    }

    static String gridSearch (String [] G, String [] P) {
        for (int l = 0; l < G.length; l++) {
            for (int c = 0; c < G[0].length(); c++) {
                if (G[l].charAt(c) == P[0].charAt(0) && checkLines(G, P, l, c)) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        /*String[] G = new String[] {
                "7283455864",
                "6731158619",
                "8988242643",
                "3830589324",
                "2229505813",
                "5633845374",
                "6473530293",
                "7053106601",
                "0834282956",
                "4607924137",
        };
        String [] P = new String[] {
                "9505",
                "3845",
                "3530",
        };*/

        String[] G = new String[] {
                "400453592126560",
                "114213133098692",
                "474386082879648",
                "522356951189169",
                "887109450487496",
                "252802633388782",
                "502771484966748",
                "075975207693780",
                "511799789562806",
                "404007454272504",
                "549043809916080",
                "962410809534811",
                "445893523733475",
                "768705303214174",
                "650629270887160",
        };
        String [] P = new String[] {
                "99",
                "99",
        };

        System.out.println(gridSearch(G, P));
    }

}
