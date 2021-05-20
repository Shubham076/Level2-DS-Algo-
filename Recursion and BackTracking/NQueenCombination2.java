public class NQueenCombination2 {
    //apllication of combination1 (when cell choses queen);
    //cq = current queen tq = total queen, asf answer so far
    // box chooses the queen
    public static void queensCombinations(int cq, int tq, int row, int col, String asf){
        // write your code here

        if(row == tq){
            if(cq == tq){
                System.out.print(asf);
            }
            return;
        }
        int nr = row;
        int nc = col;
        String yesAns = asf;
        String noAns = asf;

        if(col == tq - 1){
            nr = row + 1;
            nc = 0;
            yesAns += "q\n";
            noAns += "-\n";
        }
        else{
            nc = col + 1;
            yesAns += "q";
            noAns += "-";
        }

        queensCombinations(cq + 1, tq, nr, nc, yesAns);
        queensCombinations(cq, tq, nr, nc, noAns);

    }
    public static void main(String[] args) throws Exception {
        int n = 2;
        queensCombinations(0, n, 0, 0, "");
    }
}
