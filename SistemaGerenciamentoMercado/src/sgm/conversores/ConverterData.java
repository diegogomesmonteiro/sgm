package sgm.conversores;

public class ConverterData {
    public static String converterParaBD(String data){
        String dia, mes, ano;
        dia = data.substring(0, 2);
        mes = data.substring(3, 5);
        ano = data.substring(6, 10);
        return ano+"-"+mes+"-"+dia;
    }
    
    public static String converterParaUsu(String data){
        String dia, mes, ano;
        dia = data.substring(8, 10);
        mes = data.substring(5,7);
        ano = data.substring(0,4);
        return dia+"/"+mes+"/"+ano;
    }
    
}
