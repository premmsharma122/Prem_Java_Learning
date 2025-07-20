public class backtracking {
   /*  public static void updatearr(int arr[], int val , int i ){
        // base case
        if(i==arr.length){
            printarr(arr);
            return;
        }

        //recursion..
        arr[i] =val;
        updatearr(arr, val+1, i+1);
        arr[i] -=2; // backtracking step.

    }
    public static void printarr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
        
    public static void subSetstring(String str, String ans, int i){
        //Base case
        if(i== str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
           
            return;
        }

        //Yes Choice
        subSetstring(str, ans+str.charAt(i), i+1);

        //No Choice 
        subSetstring(str, ans, i+1);

    }
        

    public static void permutString(String str, String ans){
        // Base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        // Recursion 
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i+1);
            permutString(newStr, ans+curr);
        }
           
            public static boolean isSafe(char board[][], int row, int col){
                // vertical up
                for(int i =row-1; i>=0; i--){
                    if(board[i][col] == 'Q'){
                        return false;
                    }
                }
                // Diagonal left
                for(int i= row-1, j=col-1; i>=0 && j>=0;  i--,j--){
                    if(board[i][j]=='Q'){
                        return false;
                    }
                }

                // Diagonal right
                for(int i=row-1, j=col+1; i>=0 && j< board.length; i--,j--){
                    if(board[i][j]== 'Q'){
                        return  false;
                    }
                }
                return true;
            }
            public static void nQuesns(char board[][], int row){
                //base case
                if(row == board.length){
                    printArr(board);
                    return;
                }
                // column loop
                for(int j=0; j<board.length; j++){
                    if(isSafe(board, row, j)){
                        board[row][j] = 'Q';
                        nQuesns(board, row+1);
                        board[row][j]= 'X'; // backtracking step;
                    }
                }
            }
            public static void printArr(char arr[][]){
                for(int i=0; i<arr.length; i++){
                    for(int j=0; j<arr.length; j++){
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
            } */
           public static int gridWay(int i, int j, int n, int m){
            //base case
            if(i==n-1 && j==m-1){
                return 1;
            }
            else if(i==n || j==m){
                return 0;
            }
            int w1 = gridWay(i+1, j, n, m);
            int w2 = gridWay(i, j+1, n, m);
            return w1 + w2;

        }
    
    public static void main(String args[]){
       /*  int arr[] = new int[5];
        updatearr(arr, 1, 0);
        printarr(arr);
       
        String str = "abc";
        subSetstring(str, "", 0);
         

         String str = "abc";
         permutString(str, "");
        int n=4;
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                board[i][j] ='X';

            }
        }
        nQuesns(board, 0);
*/
        int n=3, m=3;
        System.out.println(gridWay(0, 0, n, m));
    }
}

