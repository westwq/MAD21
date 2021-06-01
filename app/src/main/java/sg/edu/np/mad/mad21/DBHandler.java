package sg.edu.np.mad.mad21;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    static final String TAG = "DataBase";
    static final String FILENAME = "DBHandler";

    public static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "moduleDB.db";
    public static String TABLE_ITELECTIVES = "ITElectives";
    public static String COLUMN_AREAOFINTEREST = "AreaOfInterest";
    public static String COLUMN_MODULES = "Modules";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_ELECTIVES_TABLE = "CREATE TABLE " + TABLE_ITELECTIVES +
                "(" + COLUMN_AREAOFINTEREST + " TEXT," + COLUMN_MODULES + " TEXT" + ")";

        db.execSQL(CREATE_ELECTIVES_TABLE);
        String varname1 = ""
                + "INSERT INTO \"ITElectives\" VALUES ('Cloud Computing','Advanced Databases;Cloud Architecture & Technologies;Developing Cloud Applications;Server & Cloud Security;Virtualisation and Data Centre Management;');";


        String varname2 = ""
                + "INSERT INTO \"ITElectives\" VALUES ('Data Science & Analytics','Big Data;Data Visualisation;Deep Learning;Descriptive Analytics;Machine Learning;Quantitative Analysis;');";


        String varname3 = ""
                + "INSERT INTO \"ITElectives\" VALUES ('Enterprice Solutioning & Marketing','Customer Decision Making & Negotiation Skills;Customer Experience Management;Enterprise Resource Planning;Infocomm Sales & Marketing Strategies;Technology for Financial Institutions;');";


        String varname4 = ""
                + "INSERT INTO \"ITElectives\" VALUES ('Games Programming','Artificial Intelligence for Games;');";

        db.execSQL(varname1);
        db.execSQL(varname2);
        db.execSQL(varname3);
        db.execSQL(varname4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITELECTIVES);
        onCreate(db);
    }

    public void addElectives(Electives electives)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_AREAOFINTEREST, electives.getAreaOfInterest());

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < electives.getModules().size(); i++) {
            str.append(electives.getModules().get(i) + ";");
        }

        String modulesString = str.toString();
        values.put(COLUMN_MODULES, modulesString);

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_ITELECTIVES, null, values);
        db.close();
    }

    public Electives findAreaOfInterest(String areaOfInterest)
    {
        String query = "SELECT * FROM " + TABLE_ITELECTIVES + " WHERE "
                + COLUMN_AREAOFINTEREST + "= \"" + areaOfInterest + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Electives queryData = new Electives();
        ArrayList<String> moduleList = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            queryData.setAreaOfInterest(cursor.getString(0));
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

    public ArrayList<Electives> getAll()
    {
        String query = "SELECT * FROM " + TABLE_ITELECTIVES ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<Electives> resultant = new ArrayList<>();

        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){

                Electives queryData = new Electives();
                queryData.setAreaOfInterest(cursor.getString(0));

                String str = cursor.getString(1);
                String[] list = str.split(";");
                ArrayList<String> moduleList = new ArrayList<>();
                for(int i = 0; i < list.length; i++)
                {
                    moduleList.add(list[i]);
                }

                queryData.setModules(moduleList);
                resultant.add(queryData);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return resultant;

    }

    public boolean deleteAreaOfInterest(String areaOfInterest)
    {
        boolean result = false;

        String query = "SELECT * FROM " + TABLE_ITELECTIVES + " WHERE "
                + COLUMN_AREAOFINTEREST + "= \"" + areaOfInterest + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Electives delElective = new Electives();

        if(cursor.moveToFirst())
        {
            delElective.setAreaOfInterest(cursor.getString(0));
            db.delete(TABLE_ITELECTIVES, COLUMN_AREAOFINTEREST
                    + "= ?", new String[]{String.valueOf(delElective.getAreaOfInterest())});
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
}
