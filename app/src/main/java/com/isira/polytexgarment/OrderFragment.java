package com.isira.polytexgarment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 * Reference :- https://stackoverflow.com/questions/24078275/how-to-add-a-row-dynamically-in-a-tablelayout-in-android
 */
public class OrderFragment extends Fragment {
    TableLayout t1;
    Button button,btn_retrieve;
    EditText txt_fab_damage_1,edt_txt_cut_no;
    final int sdk = android.os.Build.VERSION.SDK_INT;
    public String cut_val;

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
        txt_fab_damage_1 = (EditText) view.findViewById(R.id.txt_fab_damage_1);
//        Example for data input from edit text
        edt_txt_cut_no = (EditText) view.findViewById(R.id.edt_txt_cut_no);
        // data can be retrieved ...cut_val = edt_txt_cut_no.getText().toString();.....

        btn_retrieve = view.findViewById(R.id.btn_retrieve);
        btn_retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), edt_txt_cut_no.getText(), Toast.LENGTH_SHORT).show();
                Log.d("TAG123",edt_txt_cut_no.getText().toString());

            }
        });


        txt_fab_damage_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init_popup(view);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(final View view) {
                TableRow tr_head = new TableRow(getContext());
                tr_head.setId(10);
                tr_head.setLayoutParams(new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));

                for (int i=11;i<24;i++){
                    EditText new_box = new EditText(getContext());
                    String edt_txt_id = "txt_fab_damage_"+i;
                    new_box.setId(i);
                    if (i==16){
                        new_box.setFocusable(false);
                        new_box.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View popview) {
                                init_popup(popview);

                            }
                        });

                    }
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

    public void init_popup(View v){

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.damage_popup, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

    }

}
