public class lec02_RecursionTree{
    public static int coinChangePermutation(int coins[], int tar, String asf){
      if(tar==0){
          System.out.println(asf);
          return 1;
      }

      int count=0;
      for(int i=0;i<coins.length;i++){
          if(tar-coins[i]>=0){
              count+=coinChangePermutation(coins,tar-coins[i],asf+coins[i]);
          }
      }

      return count;
    }

    public static int coinChangeCombination(int coins[], int tar, int idx, String asf){
        if(tar==0){
            System.out.println(asf);
            return 1;
        }
  
        int count=0;
        for(int i=idx;i<coins.length;i++){
            if(tar-coins[i]>=0){
                count+=coinChangeCombination(coins,tar-coins[i],i,asf+coins[i]);
            }
        }
  
        return count;
      }

      public static int coinChangePermutationSingle(int coins[], int tar, String asf){
        if(tar==0){
            System.out.println(asf);
            return 1;
        }
  
        int count=0;
        for(int i=0;i<coins.length;i++){
            if(coins[i]>0&&tar-coins[i]>=0){
                int val = coins[i];
                coins[i]=-coins[i];
                count+=coinChangePermutationSingle(coins,tar-val,asf+val);
                coins[i]=-coins[i];
            }
        }
  
        return count;
      }
     
      public static int coinChangeCombinationSingle(int coins[], int tar, int idx, String asf){
        if(tar==0){
            System.out.println(asf);
            return 1;
        }
  
        int count=0;
        for(int i=idx;i<coins.length;i++){
            if(tar-coins[i]>=0){
                count+=coinChangeCombinationSingle(coins,tar-coins[i],i+1,asf+coins[i]);
            }
        }
  
        return count;
      }

    public static void main(String[]args){
       int coins[] = {2,3,5,7};
       int tar = 10;
    //    int ans = coinChangePermutation(coins,tar,"");
    //    int ans = coinChangeCombination(coins,tar,0,"");
    //    int ans = coinChangePermutationSingle(coins,tar,"");
       int ans = coinChangeCombinationSingle(coins,tar,0,"");
       System.out.println("count is -> "+ans);
    }
}