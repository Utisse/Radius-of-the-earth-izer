import java.text.DecimalFormat;

public class main {
	static String rter = "",footfield = "",soccerfield = "",schoolbus = "",cars = "";
    static String[][] englishvoc = {{"The radius of the Earth ","The length of an American Football field","The length of a Soccer field ","The length of a school bus ","The length of a car "},{" is "," times ", " times bigger than ","Length in ","metres","Calculate","Please insert a number","Italiano","feet"}};
    static String[][] italianvoc = {{"Il raggio della terra ","La lunghezza di un campo da football americano ","La lunghezza di un campo da calcio ","La lunghezza di uno scuolabus","La lunghezza di una macchina "},{" è "," volte "," volte più grande di "," Lunghezza in ","metri","Calcola","Perfavore inserisci un numero","English","piedi"}};
    static String[][] nomemisura = {{"Il raggio della terra ","La lunghezza di un campo da football americano ","La lunghezza di un campo da calcio ","La lunghezza di uno scuolabus","La lunghezza di una macchina "},{rter,footfield,soccerfield,schoolbus,cars},{" è "," volte "," volte più grande di "," Lunghezza in ","metri","Calcola","Perfavore inserisci un numero","English","piedi"}};
    static String[][] listaunitadimisura = {{"m","ft"},{"metri","piedi"}};
    static String[] unitadimisura = {"m","metri"};
    static DecimalFormat twodigs = new DecimalFormat("#.00");

	public static void programstart(double input) {
		double misura = input ;
		misura m = new misura(misura);
		int counter = 0;
		for(double i : m.variables[1]){
			if(m.variables[1][counter] == 0){
				if(m.useint) {
					nomemisura[1][counter] = m.misint +unitadimisura[0]+ nomemisura[2][0] + twodigs.format(m.variables[0][counter]) + nomemisura[2][1] + nomemisura[0][counter].toLowerCase();
				} else {
					nomemisura[1][counter] = m.misdouble +unitadimisura[0]+ nomemisura[2][0] + twodigs.format(m.variables[0][counter]) + nomemisura[2][1] + nomemisura[0][counter].toLowerCase();
				}
			} else {
				if(m.useint) {
					nomemisura[1][counter] = nomemisura[0][counter] + nomemisura[2][0] + twodigs.format(m.variables[0][counter]) + nomemisura[2][2] + m.misint+unitadimisura[0];
				} else{
					nomemisura[1][counter] = nomemisura[0][counter] + nomemisura[2][0] + twodigs.format(m.variables[0][counter]) + nomemisura[2][2] + m.misdouble+unitadimisura[0];
				}
			}
			//System.out.println(nomemisura[1][counter]);
			counter += 1;

		}

	}
}

