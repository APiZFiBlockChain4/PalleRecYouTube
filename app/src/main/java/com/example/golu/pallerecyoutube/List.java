package com.example.golu.pallerecyoutube;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    String courseID;
   RecyclerView recyclerView;
    int cnt = 0;
    Bundle bundle;
    ArrayList<Data> al;

    String vidId = "";
    String durations = "";
    String strngElmnt = "";
    String topcNme = "";
    MyAdapter myadapter;

    private String[] csharp_freshers_demo_videos = {
            "C# program compilation/ltgDdukzQ7I/18:47",
            "C# data types/L_gFuuSp4V0/17:53",
            "C# class/l1C4FZGCab0/10:48",
            "C# class as virtual entity/HSdIq3k51bg/9:15",
            "Objects in C#/SM_QqUdMXY0/22:14",
            "Debugging in visual studio/8hXH5HxQfFU/10:41",
            "C# Arrays/CLnA6OAlNPk/24:50",
            "Declaring and Modifying data in c# arrays/O2QI3YFupxM/9:06",
            "Arrays Assignment/Zt85ireWQWw/7:49",
            "Loops/u_k75WcEpHM/5:51",
    };

    private String[] csharp_exp_demo_videos = {
            "C# program compilation/ltgDdukzQ7I/18:47",
            "Debugging in visual studio/8hXH5HxQfFU/10:41",
            "Inheritence/TOBLe0qoA_o/9:24",
            "Inheritence Part 2/T7G8NFXDXFE/24:07",
            "Base keyword/WaAbIMz2dqg/22:08",
            "Overriding Intro/w6ldKhR4YUs/23:31",
            "Overriding an override method/fdPslUmRqm0/12:52",
            "Static Variables/zvk_hS4vEOw/9:27",
            "What is the use of properties in c#/UdiU6sp68Tc/16:16",
            "C# properties/5nHmt5Zi7l8/15:03",
    };
    private String[] sql_server_freshers_demo_videos = {
            "SQLServer Overview/Kdc84lpF4GM/16:25",
            "Normalization/7Dc7_I48ZTg/14:30",
            "Orderby Clause/quuwLXzZl3g/6:59",
            "Delete drop and truncate statements/yZNyUzSMsT8/6:58",
            "Aggregate Functions/2IYykxAXaB8/13:54",
            "Group by Clause/qx0j5iWajqg/20:22",
            "Joins and Inner Join with simple explanation/i0vwTFFHTU8/33:02",
            "Stored procedure/jmZsXlAYe7Y/17:11",
            "User Defined Functions in sql/8cJFtDESxiQ/9:01",
            "Indexes/hrVpqW_Bh2o/21:09"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent i = getIntent();
        bundle = i.getExtras();
        courseID = bundle.getString("id");
        al = new ArrayList<Data>();
        myadapter = new MyAdapter();


        switch (courseID) {
            case "csharpFreshers":

                getStrng(csharp_freshers_demo_videos );

                break;
            case "csharpProf":

                getStrng(csharp_exp_demo_videos );

                break;
            case "sql":

                getStrng(sql_server_freshers_demo_videos );

                break;
        }


        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setAdapter(myadapter);

        LinearLayoutManager mng=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mng);

    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // load row.xml
            View v=getLayoutInflater().inflate(R.layout.row ,parent,false);
            //pass row.xml to view Holder(Our Vie Holder
            ViewHolder viewHolder=new ViewHolder(v);

            return viewHolder; //Return ViewwHolder
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            //get data from source (Arraylist) based on position
            final Data data=al.get(position);

            //Apply data onto row.xml(viewHolder)
            holder.tv1.setText(data.getSlno());
            holder.tv2.setText(data.getTopic());
            holder.tv3.setText(data.getDuration());
           holder.b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String video = data.getVideo().toString();
                    Intent i = new Intent(List.this,YoutubeView.class);
                    i.putExtra("videoId",video);
                    startActivity(i);

                }
            });

        }

        @Override
        public int getItemCount() {
            return al.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            //declare row xml in our case there is 3 TextView
            TextView tv1,tv2,tv3;
            Button b1;
            public ViewHolder(View itemView) {
                super(itemView);
                tv1=(TextView) itemView.findViewById(R.id.tv_count);
                tv2=(TextView) itemView.findViewById(R.id.tv_header);
                tv3=(TextView) itemView.findViewById(R.id.tv_duration);
                b1=(Button) itemView.findViewById(R.id.button_demo);
            }
        }
    }

    private void getStrng(String[] online_video_link) {

        for (int j = 0; j < online_video_link.length; j++) {

            cnt = cnt + 1;

            for (int k = 0; k <= online_video_link[j].length(); k++) {

                strngElmnt = online_video_link[j];

                topcNme = strngElmnt.substring(0, online_video_link[j].indexOf("/"));

                vidId = strngElmnt.substring(online_video_link[j].indexOf("/") + 1, online_video_link[j].lastIndexOf("/"));

                durations = strngElmnt.substring(online_video_link[j].lastIndexOf("/") + 1, online_video_link[j].length());
            }

            al.add(new Data("" + cnt, topcNme, durations,vidId));

            myadapter.notifyDataSetChanged();


        }
    }
    }

