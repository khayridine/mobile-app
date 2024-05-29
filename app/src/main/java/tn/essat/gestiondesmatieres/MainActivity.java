package tn.essat.gestiondesmatieres;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Matiere> liste =new ArrayList<>();

        Mabase bd = new Mabase(getApplicationContext(),"essat.db",null,1); //
        SQLiteDatabase base =bd.getWritableDatabase();
        Cursor cr = base.query("matiere", new String[]{"id", "titre", "niveau"}, null, null, null, null, null);

        cr.moveToFirst();
        while (cr.isAfterLast() == false)
        {
            liste.add (new Matiere (cr.getInt(0),cr.getString(1),cr.getString(2)));
            cr.moveToNext();
        }


        ListView lv = findViewById(R.id.lv1);
        MyListAdapter adp=new MyListAdapter(getApplicationContext(),liste);
        lv.setAdapter(adp);


        Button b1=findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 =new Intent(getApplicationContext(), AjouActivity.class);// lien
                startActivity(i1);// lance
            }
        });
    }






}