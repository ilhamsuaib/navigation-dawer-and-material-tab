package id.duza.navigationdrawer.fragment;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import id.duza.navigationdrawer.R;
import id.duza.navigationdrawer.activity.DetailEventActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabStauFragment extends Fragment {


    public TabStauFragment() {
        // Required empty public constructor
    }

    ListView listEvent;
    String[] events = {
            "Nonton bareng Barca-PSG",
            "Barca bantai PSG",
            "Jalan-jalan pagi",
            "Jalan-jalan malam",
            "Jalan-jalan malam",
            "Jalan-jalan malam",
            "Jalan-jalan malam",
            "Jalan-jalan malam",
            "Jalan-jalan malam",
            "Jalan-jalan malam",
            "Jalan-jalan malam",
            "DLL"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab_stau, container, false);

        listEvent = (ListView) v.findViewById(R.id.list_event);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, events);

        listEvent.setAdapter(adapter);

        listEvent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailEventActivity.class);
                intent.putExtra("nama_event", events[position]);
                startActivity(intent);
            }
        });

        listEvent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Delete");
                builder.setMessage("Anda yakin akan menghapus "+events[position]+"?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                Dialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });

        return v;
    }

}
