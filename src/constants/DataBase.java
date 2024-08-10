package constants;

public class DataBase {
    public static final String BASE = "jdbc:mysql://localhost:3306/";
    public static final String DB_NAME = "amazonviewer";
    public static final String USER = "root";
    public static final String PASSWORD = "aDMin_8x954j-95";
    public static final String URL = BASE + DB_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static final String TMATERIAL = "material";
    public static final String TMATERIAL_ID = "id";
    public static final String TMATERIAL_NAME = "name";

    public static final String TMOVIE = "movie";
    public static final String TMOVIE_ID = "id";
    public static final String TMOVIE_TITLE = "title";
    public static final String TMOVIE_GENRE = "genre";
    public static final String TMOVIE_CREATOR = "creator";
    public static final String TMOVIE_DURATION = "duration";
    public static final String TMOVIE_YEAR = "year";

    public static final String TUSER = "user";
    public static final String TUSER_ID = "id";
    public static final String TUSER_NAME = "name";

    public static final String TVIEWED = "user";
    public static final String TVIEWED_ID = "id";
    public static final String TVIEWED_ID_MATERIAL = "id_material";
    public static final String TVIEWED_ID_ELEMENT = "id_element";
    public static final String TVIEWED_ID_USER = "id_user";
}
