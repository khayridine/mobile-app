package tn.essat.gestiondesmatieres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AjouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajou);


        Button b2=findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1= findViewById(R.id.e1);
                String s1 = e1.getText().toString();
                EditText e2= findViewById(R.id.e2);
                String s2  = e2.getText().toString();

                Mabase bd = new Mabase(getApplicationContext(),"essat.db",null,1);
                SQLiteDatabase base1 =bd.getWritableDatabase();

                ContentValues cr = new ContentValues();
                cr.put("Titre", s1);
                cr.put("Niveau", s2);
                base1.insert("matiere", null, cr);

                Intent i1 =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i1);

            }
        });
    }


}