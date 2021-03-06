
package br.usjt;

import android.provider.BaseColumns;

import java.util.Locale;

public final class LatLongCont {

    private LatLongCont(){
    }

    public static class LocalizacaoTable implements BaseColumns {
        public static final String TABLE_NAME = "localizacao";
        public static final String COLUMN_NAME_ID = "id_localizacao";
        public static final String COLUMN_NAME_LATITUDE = "latitude";
        public static final String COLUMN_NAME_LONGITUDE = "longitude";
        public static final String DROP_TABLE = String.format("DROP TABLE %s", LocalizacaoTable.TABLE_NAME);
    }

    public static String createTableLocalizacao(){
        return String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT);",
                LocalizacaoTable.TABLE_NAME,
                LocalizacaoTable.COLUMN_NAME_ID,
                LocalizacaoTable.COLUMN_NAME_LATITUDE,
                LocalizacaoTable.COLUMN_NAME_LONGITUDE
        );
    }

    public static String insertLocalizacao(LatLongLocalizacao localizacao){
        String template = "INSERT INTO %s (%s, %s) VALUES ('%s','%s');";
        return String.format(
                Locale.getDefault(),
                template,
                LocalizacaoTable.TABLE_NAME,
                LocalizacaoTable.COLUMN_NAME_LATITUDE,
                LocalizacaoTable.COLUMN_NAME_LONGITUDE,
                localizacao.getLatitude(),
                localizacao.getLongitude()
        );
    }



}
