import java.util.ArrayList;

public class LiangBarsky {

    public static ArrayList<Integer> calc(ArrayList<Integer> line, ArrayList<Integer> rect){
        ArrayList<Integer> in = new ArrayList<>();
        int x1 = line.get(0);
        int y1 = line.get(1);
        int x2 = line.get(2);
        int y2 = line.get(3);
        int xmin = rect.get(0);
        int ymin = rect.get(1);
        int xmax = rect.get(2);
        int ymax = rect.get(3);

        int[] S = new int[]{-(y2 - y1), -(x2 - x1), y2 - y1, x2 - x1};
        int[] Q = new int[]{y1 - ymin, x1 - xmin, ymax - y1, xmax - x1 };
        double tvh = 0, tvih = 1;
        for(int i = 0; i < 4; ++i){
            if(S[i] > 0){
                tvih = Math.min((double)Q[i]/S[i], tvih);
            }
            else if(S[i] < 0){
                tvh = Math.max((double)Q[i]/S[i], tvh);
            }
            else {
                if(Q[i] < 0)
                    return in;
            }
        }

        int new_x1 = (int)(x1 + tvh * (x2 - x1));
        int new_x2 = (int)(x1 + tvih * (x2 - x1));

        int new_y1 = (int)(y1 + tvh * (y2 - y1));
        int new_y2 = (int)(y1 + tvih * (y2 - y1));

        if(new_x1 < xmin || new_x1 > xmax ||  new_x2 < xmin || new_x2 > xmax ||
                new_y1 < ymin || new_y1 > ymax ||  new_y2 < ymin || new_y2 > ymax){
            return in;
        }

        in.add(new_x1);
        in.add(new_y1);
        in.add(new_x2);
        in.add(new_y2);
        return in;
    }
}
