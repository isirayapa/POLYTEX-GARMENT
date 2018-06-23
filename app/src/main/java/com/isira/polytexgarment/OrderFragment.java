package com.isira.polytexgarment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;


/**
 * A simple {@link Fragment} subclass.
 * Reference :- https://stackoverflow.com/questions/24078275/how-to-add-a-row-dynamically-in-a-tablelayout-in-android
 */
public class OrderFragment extends Fragment {
    TableLayout t1;
    Button button;
    final int sdk = android.os.Build.VERSION.SDK_INT;


    public OrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        // Inflate the layout for this fragment
        t1 = (TableLayout) view.findViewById(R.id.lo_table_second);
        button = (Button) view.findViewById(R.id.btn_raw_add);


        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                TableRow tr_head = new TableRow(getContext());
                tr_head.setId(10);
                tr_head.setLayoutParams(new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));

                for (int i=11;i<24;i++){
                    EditText new_box = new EditText(getContext());
                    new_box.setId(i);
                    if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                        new_box.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.table_border) );
                    } else {
                        new_box.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.table_border));
                    }
                    tr_head.addView(new_box);// add the column to the table row here
                }

                t1.addView(tr_head, new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.FILL_PARENT,                    //part4
                        TableLayout.LayoutParams.MATCH_PARENT));

            }
        });



        return view;
    }

}
