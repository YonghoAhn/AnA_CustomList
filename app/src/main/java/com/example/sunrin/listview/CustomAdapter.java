package com.example.sunrin.listview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sunrin on 2016-07-20.
 */
public class CustomAdapter extends BaseAdapter{
    private ArrayList<String> list;
    public CustomAdapter(){
        list = new ArrayList<String>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_list,parent,false);

            TextView textView = (TextView) convertView.findViewById(R.id.list_text);
            textView.setText(list.get(position));
            ImageView image = (ImageView) convertView.findViewById(R.id.mImage);
            if(pos == 0)
            {
                image.setImageResource(R.drawable.civ);
            }
            else if(pos == 1)
            {
                image.setImageResource(R.drawable.stc);
            }
            else if(pos == 2)
            {
                image.setImageResource(R.drawable.cod);
            }
            else if(pos == 3)
            {
                image.setImageResource(R.drawable.btf);
            }
            else if(pos == 4)
            {
                image.setImageResource(R.drawable.sim);
            }
            else if(pos == 5)
            {
                image.setImageResource(R.drawable.fall);
            }
            Button btn = (Button) convertView.findViewById(R.id.list_btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String description = "";
                    if(pos == 0)
                    {
                        description = "Sid Meier's Civilization V ";
                    }
                    else if(pos == 1)
                    {
                        description = "Blizzard Starcraft";
                    }
                    else if(pos == 2)
                    {
                        description = "Activision Call of Duty";
                    }
                    else if(pos == 3)
                    {
                        description = "EA DICE Battlefield";
                    }
                    else if(pos == 4)
                    {
                        description = "MAXIS SimCity";
                    }
                    else if(pos == 5)
                    {
                        description = "Bethesda Fallout";
                    }
                    //Toast.makeText(context,"리스트"+list.get(pos),Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            context);

                    // set title
                    alertDialogBuilder.setTitle("Information");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage(description)
                            .setCancelable(false)
                            .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                }

            });
            convertView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(context,"롱클릭"+list.get(pos),Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }

        return convertView;
    }
    public void add(String str)
    {
        list.add(str);
    }

    public void remove(int pos)
    {
        list.remove(pos);
    }


}
