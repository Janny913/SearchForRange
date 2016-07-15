/**
 * Created by jianiyang on 16/7/14.
 */
//the array is sorted, so the duplicate of target will show adjacently;
public class SearchForRange {
    public int[] searchRange(int[] A, int target){
        int[] res ={-1, -1};
        if(A == null || A.length == 0)
            return res;

        int ll = 0;
        int lr = A.length - 1;
        while(ll <= lr){
            int m =(ll + lr)/2;
            if(A[m] < target){
                ll = m + 1;
            }else{
                lr = m -1;
            }
        }

        int rl = 0;
        int rr = A.length - 1;
        while(rl <= rr){
            int m =(rl + rr)/2;
            if(A[m] <= target){ //这里有个等号和之前不同是因为,之前用来确定第一个target在的位置,而这个等号能保证再次遇到target之后能往后走
                rl = m + 1;
            }else{
                rr = m - 1;
            }
        }

        if(ll <= rr){
            res[0] = ll;
            res[1] = rr;

        }
        return res;
    }

    public static void main(String[] args){
        int[] A = {5,7,7,8,8,10,11};
        int target = 8;
        SearchForRange res = new SearchForRange();
        int[] output = res.searchRange(A, target);
        for(int k : output)
            System.out.println(k);
    }
}
