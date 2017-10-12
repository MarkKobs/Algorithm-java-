package backtrack;

import java.time.LocalDate;

/**
 * Created by mk on 2017/10/12.
 * 理论分析：集装箱问题类似于一个特殊的01背包问题
 *
 */
public class Loading {
    static int n;//集装箱数量
    static int[] w;
    static int c;
    static int cw;
    static int bestw;
    public static int maxLoading(int[] ww,int cc){
        n=ww.length-1;
        w=ww;
        c=cc;
        cw=0;
        bestw=0;
        backtrack(1);
        return bestw;
    }
    public static void backtrack(int i){
        if(i>n){
            if(cw>bestw) bestw=cw;
            return;
        }
        if(cw+w[i]<=c){//搜索左子树
            cw+=w[i];
            backtrack(i+1);
            cw-=w[i];
        }
        //搜索右子树
        backtrack(i+1);
    }
    public static void main(String[] args){
        int[] paks={2,6,4,1,5};
        Loading loading=new Loading();
        int bestw=loading.maxLoading(paks,10);
        System.out.println("best weight on ship 1:"+String.valueOf(bestw));

    }

}
