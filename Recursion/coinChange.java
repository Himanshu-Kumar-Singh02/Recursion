public class coinChange {
    
    public static int coinChangePermInf(int coins[], int tar, String asf){
        if(tar==0){
            System.out.println(asf);
            return 1;
        }
         int count=0;
        for(int i=0;i<coins.length;i++){
            if(tar-coins[i]>=0){
                count+=coinChangePermInf(coins,tar-coins[i],asf+coins[i]);
            }
        }
        return count;
    }

    public static int coinChangeCombInf(int coins[], int idx, int tar, String asf){
        if(tar==0){
            System.out.println(asf);
            return 1;
        }
         int count=0;
        for(int i=idx;i<coins.length;i++){
            if(tar-coins[i]>=0){
                count+=coinChangeCombInf(coins,i,tar-coins[i],asf+coins[i]);
            }
        }
        return count;
    }

    public static int coinChangePermSingle(int coins[], int tar, String asf){
        if(tar==0){
            System.out.println(asf);
            return 1;
        }
         int count=0;
        for(int i=0;i<coins.length;i++){
            if(coins[i]>=0&&tar-coins[i]>=0){
                int val = coins[i];
                coins[i]=-coins[i];
                count+=coinChangePermSingle(coins,tar-val,asf+val);
                coins[i]=-coins[i];
            }
        }
        return count;
    }

    public static int coinChangeCombSingle(int coins[], int idx, int tar, String asf){
        if(tar==0){
            System.out.println(asf);
            return 1;
        }
         int count=0;
        for(int i=idx;i<coins.length;i++){
            if(tar-coins[i]>=0){
                count+=coinChangeCombSingle(coins,i+1,tar-coins[i],asf+coins[i]);
            }
        }
        return count;
    }

    public static void main(String[]args){
        int coins[] = {2,3,5,7};
        int tar = 10;
        // int ans = coinChangePermInf(coins,tar,"");
        // int ans = coinChangeCombInf(coins,0,tar,"");
        // int ans = coinChangePermSingle(coins,tar,"");
        int ans = coinChangeCombSingle(coins,0,tar,"");
        System.out.println("count is -> "+ans);
     }
}
