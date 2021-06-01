package sg.edu.np.mad.mad21;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/****************************************************
*   This is the Database Handler class.             *
*   DO NOT TAMPER WITH ANYTHING IN THIS CLASS       *
*   AS IT WILL AFFECT THE OUTPUT OF THE SOLUTION.   *
*****************************************************
*/

public class DBHandler extends SQLiteOpenHelper {
    public static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "moduleDB.db";
    public static String TABLE_ITELECTIVES = "ITElectives";
    public static String COLUMN_AREAOFINTEREST = "Titles";
    public static String COLUMN_MODULES = "Modules";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    /*
    This function creates the Database that is required by the application.
    It will also add predefined set of Dataset to the empty Database.
    DO NOT TAMPER WITH THIS.
    */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_ELECTIVES_TABLE = "CREATE TABLE " + TABLE_ITELECTIVES +
                "(" + COLUMN_AREAOFINTEREST + " TEXT," + COLUMN_MODULES + " TEXT" + ")";

        db.execSQL(CREATE_ELECTIVES_TABLE);
        String varName1 = ""
                + "INSERT INTO \"ITElectives\" VALUES ('Cloud Computing','Advanced Databases;Cloud Architecture & Technologies;Developing Cloud Applications;Server & Cloud Security;Virtualisation and Data Centre Management;');";


        String varName2 = ""
                + "INSERT INTO \"ITElectives\" VALUES ('Data Science & Analytics','Big Data;Data Visualisation;Deep Learning;Descriptive Analytics;Machine Learning;Quantitative Analysis;');";


        String varName3 = ""
                + "INSERT INTO \"ITElectives\" VALUES ('Enterprice Solutioning & Marketing','Customer Decision Making & Negotiation Skills;Customer Experience Management;Enterprise Resource Planning;Infocomm Sales & Marketing Strategies;Technology for Financial Institutions;');";


        String varName4 = ""
                + "INSERT INTO \"ITElectives\" VALUES ('Games Programming','Artificial Intelligence for Games;');";

        db.execSQL(varName1);
        db.execSQL(varName2);
        db.execSQL(varName3);
        db.execSQL(varName4);
    }

    /*
    This function upgrades the Database if there is a newer version
    supplied.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITELECTIVES);
        onCreate(db);
    }

    /*
    This function searches for the title requested in the Database
    and returns the respective title and modules found in the row
    via a cursor in the Database.

    Input : String of title
    Output: Object AreaOfInterest
    */
    public AreaOfInterest findTitle(String title)
    {
        String query = "SELECT * FROM " + TABLE_ITELECTIVES + " WHERE "
                + COLUMN_AREAOFINTEREST + "= \"" + title + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        AreaOfInterest queryData = new AreaOfInterest();
        ArrayList<String> moduleList = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            queryData.setTitle(cursor.getString(0));
            String str= cursor.getString(1);
            String[] list = str.split(";");


            for (int i = 0; i < list.length; i++)
            {
                moduleList.add(list[i]);
            }
            queryData.setModules(moduleList);

        }
        else
        {
            queryData = null;
        }
        cursor.close();
        db.close();
        return queryData;
    }

    /*
    This function queries for the table of interest in the Database
    and returns the entire table in the form of an arraylist of the data.

    Input: null
    Output: Arraylist of object AreaOfInterest
     */
    public ArrayList<AreaOfInterest> getAll()
    {
        String query = "SELECT * FROM " + TABLE_ITELECTIVES ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<AreaOfInterest> resultant = new ArrayList<>();

        while(cursor.moveToNext()){
            AreaOfInterest queryData = new AreaOfInterest();
            queryData.setTitle(cursor.getString(0));

            String str = cursor.getString(1);
            String[] list = str.split(";");
            ArrayList<String> moduleList = new ArrayList<>();
            for(int i = 0; i < list.length; i++)
            {
                moduleList.add(list[i]);
            }
            queryData.setModules(moduleList);
            resultant.add(queryData);
        }
        cursor.close();
        db.close();
        return resultant;

    }

}
