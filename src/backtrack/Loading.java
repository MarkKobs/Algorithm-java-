package backtrack;

/**
 * Created by mk on 2017/10/12.
 * 理论分析：集装箱问题类似于一个特殊的01背包问题
 *
 */
public class Loading {
    static int n;//集装箱数量
    static int[] w;//每个集装箱的重量
    static int c;//第一艘船的载重量
    static int cw;//当前重量
    static int bestw;//最大载重量
    static int r;//剩余集装箱重量
    public static int maxLoading(int[] ww,int cc){
        n=ww.length-1;
        w=ww;
        c=cc;
        cw=0;
        bestw=0;
        r=0;//剩余集装箱的重量
        //初始化箱子的重量为：所有重物的重量
        for(int i=1;i<=n;i++){
            r+=w[i];
        }
        backtrack(1);
        return bestw;
    }
    public static void backtrack(int i){
        if(i>n){//到叶子节点，结束
            if(cw>bestw){
                bestw=cw;
            }
            return;
        }
        //搜索子树
        r-=w[i];//查找到一个节点（集装箱）就向下搜索（并更新剩余集装箱重量）
        if(cw+w[i]<=c&&cw+r>bestw){//搜索左子树，constraints
            //x[i]=1
            cw+=w[i];
            backtrack(i+1);
            cw-=w[i];
        }
        if(cw+r>bestw){//搜索右子树,bounds
            backtrack(i+1);
        }
        r+=w[i];
    }
    public static void main(String[] args){
        int[] paks={2,6,4,1,5};
        Loading loading=new Loading();
        int bestw=loading.maxLoading(paks,10);
        System.out.println("best weight on ship 1:"+String.valueOf(bestw));

    }
}
