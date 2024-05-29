package tn.essat.gestiondesmatieres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyListAdapter extends BaseAdapter {
    private Context context ;
    private List<Matiere> liste ;

    public  MyListAdapter(Context context, List<Matiere> liste) {
        this.context = context;
        this.liste = liste;
    }



    @Override
    public int getCount() {
        return liste.size();
    }

    @Override
    public Object getItem(int i) {
        return liste.get(i);
    }

    @Override
    public long getItemId(int i) {
        return liste.get(i).getId() ;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_mylistadapter, parent, false);
        }

        Matiere etd=liste.get(position);

        TextView tx1=view.findViewById(R.id.tx1);
        TextView tx2=view.findViewById(R.id.tx2);


        tx1.setText(etd.getTitre());
        tx2.setText(etd.getNiveau());


        return view;

    }
}