

public class misura {

    public double rter = 6371000,footfield = 109.73,soccerfield = 105,schoolbus = 12.1,cars = 4.45;
    int misint;
    double misdouble;
    boolean useint;
    static boolean metres = true;

    double[][] variables = {{rter, footfield,soccerfield,schoolbus,cars}, {0,0,0,0,0}};

    public misura(double mis){
        double mol = 0;
        if(metres){
            mol = 1;
        } else {
            mol = 3.28084;
        }
        if(mis %1 == 0) {
            misint = (int) mis;
            useint = true;
        }else{
            misdouble = mis;
            useint = false;
        }
        int counter = 0;
        for(double i : variables[0]){
            i = i * mol;
            if(mis >= i){
                i = mis /i;
                variables[1][counter] = 0;
            } else {
                i = i/mis;
                variables[1][counter]= 1;
            }
            variables[0][counter] = i;
            counter +=1;
        }
    }


}
